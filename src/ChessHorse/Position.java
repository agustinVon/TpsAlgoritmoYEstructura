package ChessHorse;

public class Position implements Comparable<Position> {

    private int x;
    private int y;

    Position(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Position positionToCompare) {
        if(positionToCompare.getX()==x &&positionToCompare.getY()==y) return 0;
        else return -1;
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

    /**
     * Evaluates if position can exist giving max limits and minimum 0
     *
     * @param limitX limit on the x axis
     * @param limitY limit on the y axis
     * @return if position is possible
     */
    public boolean isPosible(int limitX,int limitY){
        if(x<0||x>=limitX) return false;
        else if(y<0||y>=limitY) return false;
        else return true;
    }

    /**
     * Transforms positions to expected Sting
     *
     * @return Position expressed in String
     */
    public String print(){
        char xChar= (char) (x+65);
        int n=y+1;
        return ""+xChar+n;
    }
}
