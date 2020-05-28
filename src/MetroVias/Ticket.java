package MetroVias;

import java.util.Random;

//Ticket generates when a person is enqueued
public class Ticket {

    int num;
    int timeOfCreation;

    // Ticket stores a time of creation and a random number
    public Ticket(Clock watch) {
        Random rand=new Random();
        timeOfCreation=watch.getTime();
        num= rand.nextInt(99999);
    }

    public int getTime() {
        return timeOfCreation;
    }
}
