package ChessHorse;

public class PosibleMovementCalculator {

    private int lines=8;
    private int columns=8;

    Position currentPosition=new Position(0,0);

    private int movement1;
    private int movement2;

    PosibleMovementCalculator(int movement1,int movement2){
        this.movement1=movement1;
        this.movement2=movement2;
    }

    public StackDynamic<Position> returnPosibleMovements(){
        return posibleMovementsStack();
    }



    private StackDynamic<Position> posibleMovementsStack() {
        StackDynamic<Position> positionStack = new StackDynamic<>();
        Position testPosition = currentPosition;

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
            for (int j = 0; j < 4; j++) {
                int y = 0;
                switch (i) {
                    case 0:
                        y = -movement1;
                        break;
                    case 1:
                        y = -movement2;
                        break;
                    case 2:
                        y = movement1;
                        break;
                    case 3:
                        y = movement2;
                        break;
                    default:
                        break;
                }
                testPosition.setX(testPosition.getX() + x);
                testPosition.setY(testPosition.getY() + y);
                if (testPosition.isPosible(lines, columns)) positionStack.push(new DynamicNode(testPosition));
                testPosition = currentPosition;
            }
        }
        return positionStack;
    }

}
