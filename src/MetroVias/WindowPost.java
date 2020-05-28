package MetroVias;

import QueueDynamic.DynamicQueue;

import java.util.Random;

public class WindowPost {
    Random rand=new Random();
    DynamicQueue<Person> queue=new DynamicQueue();
    TimeCounter internalTime;
    Finances internalFinances;

    WindowPost(TimeCounter timeCounter,Finances finances){
        internalTime=timeCounter;
        internalFinances=finances;
    }

    public void queuePerson(Person ppl){
        queue.enqueue(ppl);
    }

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

    public void addPpl(Person person){
        queue.enqueue(person);
    }

    public int getMeanTime(){
        return internalTime.getMeanOfTime();
    }

    public int getEarnings(){
        return internalFinances.getEarnings();
    }
}
