package ChessHorse;

import org.junit.Test;

public class PossibleMovementCalculatorTest {

    @Test
    public void whenCalculatingStackForPossibleMovementsShouldSucced(){
        PossibleMovementCalculator posibleMovementCalculator=new PossibleMovementCalculator(2,1);
        posibleMovementCalculator.printPosiblePaths(3);
    }

}