package ChessHorse;

import java.util.ArrayList;

public class PossibleMovementCalculator {

    private int lines=8;
    private int columns=8;

    private Position startingPosition=new Position(0,0);

    private int movement1;
    private int movement2;


    PossibleMovementCalculator(int movement1, int movement2){
        this.movement1=movement1;
        this.movement2=movement2;
    }

    /**
     * Creates a list starting with a stack created from the possible movements from starting position
     * Then next add is created from possible movements from first position stored in last stack
     * Procedure is repeated n times
     * Then method enters a loop that ends when arrayList can no longer rebuild itself
     * In each cycle it prints the path formed by the first position of each stack in list
     * Then pops it to later rebuild the list to n length
     *
     *
     * @param n indicates the amount of moves that limits the horse
     */
    public void printPosiblePaths(int n){
        ArrayList<StackDynamic<Position>> arrayOfPositions = new ArrayList<>();
        StackDynamic<Position> positions;

        Position auxPositionMarker=startingPosition;
        for (int i = 0; i < n; i++) {
            positions = posibleMovementsStack(auxPositionMarker);
            auxPositionMarker = (Position) positions.peek().data;
            arrayOfPositions.add(arrayOfPositions.size(), positions);
        }

        while (reBuildStacks(arrayOfPositions)){
            for (int i = 0; i < arrayOfPositions.size(); i++) {
                auxPositionMarker = (Position) arrayOfPositions.get(i).peek().data;
                System.out.print(auxPositionMarker.print() + " ");
            }
            System.out.println("");
            arrayOfPositions.get(arrayOfPositions.size()-1).pop();
        }
    }

    /**
     * Checks if the next stack in list is not empty for each stack, except for last one
     * If next one is empty it pops the last position in stack
     * If there are no more positions left in stack it reRuns the method to check if stack behind has any left
     * If it reruns and fins no more positions in first stack left then its impossible to rebuild
     * Else next stack is built from possible movements from last position
     *
     * @param arrayList the list that is rebuilt
     * @return if it is possible to rebuild or not
     */
    private boolean reBuildStacks(ArrayList<StackDynamic<Position>> arrayList){
        if(arrayList.size()==1){
            if(arrayList.get(0).isEmpty()){
                return false;
            }
        }
        for (int i = 0; i < arrayList.size()-1; i++) {
            if(arrayList.get(0).isEmpty()){
                return false;
            }
            else if(arrayList.get(i+1)!=null){
                if(arrayList.get(i+1).isEmpty()){
                    arrayList.get(i).pop();
                    if(arrayList.get(i).isEmpty()) return reBuildStacks(arrayList);
                    Position positionStored=(Position) arrayList.get(i).peek().data;
                    arrayList.set(i+1,posibleMovementsStack(positionStored));
                    return reBuildStacks(arrayList);
                }
            }
        }
        return true;
    }

    /**
     * Method tries every possible combination of movements stated in class
     *
     * @param positionToEvaluate Position from movements are evaluated
     * @return returns StackDynamic from possible positions to move
     */
    private StackDynamic<Position> posibleMovementsStack(Position positionToEvaluate) {
        StackDynamic<Position> positionStack = new StackDynamic<>();
        Position testPosition = new Position(positionToEvaluate.getX(),positionToEvaluate.getY());

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
                testPosition = new Position(positionToEvaluate.getX(),positionToEvaluate.getY());
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
                testPosition = new Position(positionToEvaluate.getX(),positionToEvaluate.getY());
            }
        }
        return positionStack;
    }
}
