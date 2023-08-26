import java.util.Scanner;
import java.util.ArrayList;
class Theater {
    private ArrayList<User> users = new ArrayList<User>();
    private Seat s[][] = new Seat[3][5];
    Scanner s1 = new Scanner(System.in);

    public Theater(){
        for(int i = 0;i<3;i++){
            for(int j = 0;j<5;j++){
                s[i][j] = new Seat();
            }
        }
    }
    public void printMenu(){
        System.out.println("--------------------------");
        System.out.println("영화관 자리 예매 시스템입니다.");
        System.out.println("1.회원가입");
        System.out.println("2.자리 예약");
        System.out.println("3.예약 현황 확인");
        System.out.println("4.좌석 번호 확인");
        System.out.println("5.예약 취소");
        System.out.println("6.자기 정보 확인");
        System.out.println("7.종료");
        System.out.println("--------------------------");
        System.out.print("메뉴를 선택하세요>>");
    }
    public User logIn(){
        String phoneNum;
        String name;
        String answer;
        while(true) {
            System.out.print("이름과 전화번호를 입력하시오>>");
            name = s1.next();
            phoneNum = s1.next();
            if(getIndex(name,phoneNum) <= users.size() ){
                System.out.println(users.get(getIndex(name,phoneNum)).getName()+"님 반갑습니다.");
                return users.get(getIndex(name,phoneNum));
            }
            else{
                System.out.println("존재하지 않는 회원입니다. 다시 입력해주세요.");
                System.out.print("회원 가입을 하시겠습니까?(y,n)>>");
                answer = s1.next();
                if(answer.equals("y")){
                    register();
                }
            }
        }
    }
    public int getIndex(String name, String phoneNum){
        int forReturn = users.size()+1;
        for(int i = 0;i<users.size(); i++){
            if(users.get(i).getName().equals(name)&&users.get(i).getPhoneNum().equals(phoneNum)){
                forReturn = i;
            }
        }
        return forReturn;
    }
    public int exchangeEngToNum(String row){
        int rowNum;
        if(row.equals("A")){
            rowNum = 0;
        }
        else if (row.equals("B")) {
            rowNum = 1;
        }
        else{
            rowNum = 2;
        }
        return rowNum;
    }
    public String exchangeNumToEng(int rowNum){
        String row;
        if(rowNum == 0){
            row = "A";
        }
        else if(rowNum == 1){
            row = "B";
        }
        else{
            row = "C";
        }
        return row;
    }
    public void reserve(){
        User forSave;
        System.out.println("로그인 해주세요.");
        forSave = logIn();
        System.out.print("예약하고자 하는 좌석을 선택하시오(A,B,C열의 1~5번 좌석)[ex) A 3]>>");
        String line = s1.next();
        int row = s1.nextInt();
        if(s[exchangeEngToNum(line)][row-1].getCheck() == false) {
            s[exchangeEngToNum(line)][row-1].setCheck(true);
            forSave.saveSeatInfo(s[exchangeEngToNum(line)][row-1],line,row);

            System.out.println("예약이 완료되었습니다.");
        }
        else{
            System.out.println("이미 예약된 좌석입니다.");
        }
    }
    public void register(){
        String answer;
        String name;
        String phoneNum;
        long studentId;
        String address;
        while(true) {
            System.out.print("이름과 전화번호를 입력하시오>>");
            name = s1.next();
            phoneNum = s1.next();
            if(users.size() != 0) {
                for (int i = 0; i < users.size() + 1; i++) {
                    if (users.get(i).getPhoneNum().equals(phoneNum)) {
                        System.out.println("이미 등록된 회원입니다.");
                    }
                    else {
                        System.out.print("주소와 학번을 등록하시겠습니까?(y/n)>>");
                        answer = s1.next();
                        if (answer.equals("y")) {
                            System.out.print("학번을 입력하시오>>");
                            studentId = s1.nextInt();
                            System.out.print("주소를 입력하시오>>");
                            address = s1.nextLine();
                            users.add(users.size(), new User(name, phoneNum, studentId, address));
                            break;
                        }
                        else {
                            users.add(users.size(), new User(name, phoneNum));
                            break;
                        }
                    }
                }
            }
            else {
                System.out.print("주소와 학번을 등록하시겠습니까?(y/n)>>");
                answer = s1.next();
                if (answer.equals("y")) {
                    System.out.println("주소를 입력하시오.");
                    s1.nextLine();
                    address = s1.nextLine();
                    System.out.print("학번을 입력하시오>>");
                    studentId = s1.nextInt();
                    users.add(users.size(), new User(name, phoneNum, studentId, address));
                    break;
                } else {
                    users.add(users.size(), new User(name, phoneNum));
                    break;
                }
            }
        }
    }
    public void printInfo(){
        User user;
        user = logIn();
        System.out.println("--------------------------");
        System.out.println("이름:"+user.getName());
        System.out.println("전화번호:"+user.getPhoneNum());
        System.out.println("주소:"+user.getAddress());
        if(user.getStudentId() == 0) {
            System.out.println("학번: ");
        }
        else{
            System.out.println("학번:"+user.getStudentId());
        }
        System.out.println("--------------------------");
    }

    public void printTheater(){
        for(int i = 0;i<3;i++){
            for(int j = 0;j<5;j++){
                if(s[i][j].getCheck() == true){
                    System.out.print("*");
                }
                else {
                    System.out.print("-");
                }
            }
            if(i == 0) {
                System.out.println("A열");
            }
            else if (i == 1) {
                System.out.println("B열");
            }
            else{
                System.out.println("C열");
            }
        }
    }
    public void chkSeat(){
        User forSave;
        forSave = logIn();
        if(forSave.getSeatInfo().getCheck() == false){
            System.out.println("좌석을 예약하지 않았습니다.");
        }
        else{
            System.out.println("좌석은 " + forSave.getSeatInfo().getLine() +"열 " + forSave.getSeatInfo().getRow() + "번입니다.");
        }

    }
    public void delSeat(){
        User forSave;
        forSave = logIn();
        System.out.println("현재 좌석은 "+ forSave.getSeatInfo().getLine() + "열 " + forSave.getSeatInfo().getRow()+"번입니다.");
        s[exchangeEngToNum(forSave.getSeatInfo().getLine())][(forSave.getSeatInfo().getRow())].setCheck(false);
        forSave.setSeatInfo(null);
        System.out.println("자리를 예약이 취소되었습니다.");
    }

}
