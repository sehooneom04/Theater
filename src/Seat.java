class Seat{
    private int check;

    private int row;
    private String line;
    public String toString(){
        return line + " " + row;
    }
    public void setLine(String line){
        this.line = line;
    }
    public void setRow(int row){
        this.row = row;
    }
    public String getLine(){
        return line;
    }
    public int getRow(){
        return row;
    }
    public Seat(){
        this.check = 0;
    }
    public void setCheck(int check){
        this.check = check;
    }
    public int getCheck(){
        return check;
    }
}