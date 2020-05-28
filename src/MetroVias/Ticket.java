package MetroVias;

import java.util.Random;

public class Ticket {

    int num;
    int timeOfCreation;

    public Ticket(Clock watch) {
        Random rand=new Random();
        timeOfCreation=watch.getTime();
        num= rand.nextInt(99999);
    }

    public int getTime() {
        return timeOfCreation;
    }
}
