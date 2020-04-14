package ChessHorse;

import org.junit.Test;

import static org.junit.Assert.*;

public class PosibleMovementCalculatorTest {

    public static void main(String[] args) {

    }


    @Test
    public void whenCalculatingStackForPossibleMovementsShouldSucced(){
        PosibleMovementCalculator posibleMovementCalculator=new PosibleMovementCalculator(2,1);
        posibleMovementCalculator.printPosiblePaths(4);

    }

}