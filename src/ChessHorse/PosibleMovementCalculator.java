package ChessHorse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class PosibleMovementCalculator {

    private int lines=8;
    private int columns=8;

    Position startingPosition=new Position(0,0);
    Position currentPosition=startingPosition;

    private int movement1;
    private int movement2;


    PosibleMovementCalculator(int movement1,int movement2){
        this.movement1=movement1;
        this.movement2=movement2;
    }

    public StackDynamic<Position> returnPosibleMovements(){
        return posibleMovementsStack();
    }

    public void printPosiblePaths(int n){
       ArrayList<StackDynamic<Position>> stacksOfPositions = new ArrayList<>();
       StackDynamic<Position> positions;

        for (int i = 0; i < n; i++) {
            positions=posibleMovementsStack();
            currentPosition=(Position) positions.peek().data;
            stacksOfPositions.add(stacksOfPositions.size(),positions);
        }
        while(currentPosition.compareTo(startingPosition)!=0){
            System.out.print(currentPosition.print());

        }

       positions=posibleMovementsStack();

    }

    private StackDynamic<Position> posibleMovementsStack() {
        StackDynamic<Position> positionStack = new StackDynamic<>();
        Position testPosition = new Position(currentPosition.getX(),currentPosition.getY());

        for (int i = 0; i < 4; i++) {
            int x = 0;
            switch (i) {
                case 0:
                    x = -movement1;
                    break;
                case 1:
                    x = -movement2;
                    break;
                case 2:
                    x = movement1;
                    break;
                case 3:
                    x = movement2;
                    break;
                default:break;
            }
            for (int j = 0; j < 2 && (x==movement1 || x==-movement1); j++) {
                int y = 0;
                switch (j) {
                    case 0:
                        y = movement2;
                        break;
                    case 1:
                        y = 0-movement2;
                        break;
                    default:
                        break;
                }
                testPosition.setX(testPosition.getX() + x);
                testPosition.setY(testPosition.getY() + y);
                if (testPosition.isPosible(lines, columns)){
                    positionStack.push(new DynamicNode<>(testPosition));

                }
                testPosition = new Position(currentPosition.getX(),currentPosition.getY());
            }
            for (int j = 0; j < 2&& j < 2 && (x==movement2 || x==-movement2); j++) {
                int y = 0;
                switch (j) {
                    case 0:
                        y = movement1;
                        break;
                    case 1:
                        y = 0-movement1;
                        break;
                    default:
                        break;
                }
                testPosition.setX(testPosition.getX() + x);
                testPosition.setY(testPosition.getY() + y);
                if (testPosition.isPosible(lines, columns)) positionStack.push(new DynamicNode<>(testPosition));
                testPosition = new Position(currentPosition.getX(),currentPosition.getY());
            }
        }
        return positionStack;
    }
}
