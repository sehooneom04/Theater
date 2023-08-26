class Seat{
    private boolean check;

    private int row;
    private String line = new String();
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
        this.check = false;
    }
    public void setCheck(boolean check){
        this.check = check;
    }
    public boolean getCheck(){
        return check;
    }
}