package MetroVias;

import java.util.ArrayList;

public class TimeCounter {
    ArrayList<Integer> times;

    TimeCounter(){
        times=new ArrayList<>();
    }

    public void giveTime(int time, Clock clock) {
        times.add(clock.getTime()-time);
    }

    public int getMeanOfTime(){
        if(times.size()==0) return 0;
        else return sumOfTimes()/times.size();
    }

    private int sumOfTimes(){
        int sum=0;
        for (Integer time:times) {
            sum=sum+time;
        }
        return sum;
    }
}
