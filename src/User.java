import java.util.ArrayList;

class User {
    private Seat seatInfo;
    private String name;
    private String phoneNum;
    private long studentId;
    private ArrayList<User> friendList = new ArrayList<User>();

    private String address;


    public User(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
        studentId = 0;
        address = "";
    }

    public User(String name, String phoneNum, long studentId, String address) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.studentId = studentId;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getAddress() {
        return address;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changePhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void changeStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void changeAddress(String address) {
        this.address = address;
    }     // 정보 변경 메소드들.

    public void saveSeatInfo(Seat seatInfo, String line, int row) {
        this.seatInfo = seatInfo;
        this.seatInfo.setRow(row);
        this.seatInfo.setLine(line);
    }

    public void setSeatInfo(Seat seatInfo) {
        this.seatInfo = seatInfo;
    }

    public Seat getSeatInfo() {
        return seatInfo;
    }

    public void addFriend(User friend) {
        this.friendList.add(friend);
        friend.friendList.add(this);
    } //친구 추가 메소드

    public void delFriend(User friend) {
        for (int i = 0; i < friendList.size(); i++) {
            if (friend.getName().equals(friendList.get(i).getName())) {
                friendList.remove(i);
            }
        }
        for (int i = 0; i < friendList.size(); i++) {
            if (friend.friendList.get(i).getName().equals(name)) {
                friend.friendList.remove(i);
            }
        }
    } // 친구 삭제 메소드

    public void printFriendList() {
        for (int i = 0; i < friendList.size(); i++) {
            System.out.println(friendList.get(i));
        }
    } // 친구 목록 츌력 메소드
}