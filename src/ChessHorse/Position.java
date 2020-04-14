package ChessHorse;

public class Position {

    private int x;
    private int y;

    Position(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPosible(int limitX,int limitY){
        if(x<0||x>limitX) return false;
        else if(y<0||y>limitY) return false;
        else return true;
    }

    public String print(){
        char xChar= (char) (x+65);
        return xChar+" "+y+1;
    }
}
