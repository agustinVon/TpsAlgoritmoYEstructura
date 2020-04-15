package ChessHorse;

import org.junit.Test;

import static org.junit.Assert.*;

public class PosibleMovementCalculatorTest {

    public static void main(String[] args) {

    }


    @Test
    public void whenCalculatingStackForPossibleMovementsShouldSucced(){
        PosibleMovementCalculator posibleMovementCalculator=new PosibleMovementCalculator(2,1);
        posibleMovementCalculator.printPosiblePaths(5);

    }
    @Test
    public void aa(){
        PosibleMovementCalculator posibleMovementCalculator=new PosibleMovementCalculator(2,1);
        StackDynamic<Position> movements=posibleMovementCalculator.returnPosibleMovements();
        while(!movements.isEmpty()){
            Position position=(Position) movements.peek().data;
            System.out.println(position.print());
            movements.pop();
        }

    }

}