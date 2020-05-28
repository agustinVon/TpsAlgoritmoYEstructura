package MetroVias;

import MetroVias.QueueDynamic.DynamicQueue;

import java.util.Random;

public class WindowPost {
    Random rand=new Random();
    DynamicQueue<Person> queue=new DynamicQueue();
    TimeCounter internalTime;
    Finances internalFinances;

    // Window post constructor
    WindowPost(TimeCounter timeCounter,Finances finances){
        internalTime=timeCounter;
        internalFinances=finances;
    }

    //Each time this method is executed, the window has a 50% chance of process a new customer in the queue
    //First, it dequeues the person, then generates a ticket with the wait time and the amount paid
    public void process(TimeCounter tc,Finances finances,StationStack stack,Clock clock){
        int chanceToProcess = rand.nextInt(2);
        if(chanceToProcess==1&&!queue.isEmpty()){
            Person ppl=queue.dequeue();
            Ticket tick= ppl.getTicket();
            tc.giveTime(tick.getTime(),clock);
            internalTime.giveTime(tick.getTime(),clock);
            stack.addTicket(tick);
            internalFinances.pay();
            finances.pay();
        }
    }

    //Enqueues a person
    public void addPpl(Person person){
        queue.enqueue(person);
    }

    // Returns the mean time of the window
    public int getMeanTime(){
        return internalTime.getMeanOfTime();
    }

    //Returns the earnings of the window
    public int getEarnings(){
        return internalFinances.getEarnings();
    }
}
