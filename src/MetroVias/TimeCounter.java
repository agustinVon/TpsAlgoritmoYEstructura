package MetroVias;

import java.util.ArrayList;

//Window time counter
public class TimeCounter {
    ArrayList<Integer> times;

    TimeCounter(){
        times=new ArrayList<>();
    }

    // Sets new time
    public void giveTime(int time, Clock clock) {
        times.add(clock.getTime()-time);
    }

    // Returns the mean of all the times in a given window
    public int getMeanOfTime(){
        if(times.size()==0) return 0;
        else return sumOfTimes()/times.size();
    }

    // Returns the sum of all the times in a given window
    private int sumOfTimes(){
        int sum=0;
        for (Integer time:times) {
            sum=sum+time;
        }
        return sum;
    }
}
