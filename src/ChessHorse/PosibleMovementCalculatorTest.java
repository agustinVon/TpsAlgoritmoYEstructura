package ChessHorse;

import org.junit.Test;

import static org.junit.Assert.*;

public class PosibleMovementCalculatorTest {

    public static void main(String[] args) {

    }


    @Test
    public void whenCalculatingStackForPossibleMovementsShouldSucced(){
        PosibleMovementCalculator posibleMovementCalculator=new PosibleMovementCalculator(2,1);
        StackDynamic<Position> pos=posibleMovementCalculator.returnPosibleMovements();
        for (int i = pos.size(); i >0; i--) {
            Position daleviejaa=(Position)(pos.peek().data);
            System.out.println(daleviejaa.print());
            pos.pop();
        }

    }

}