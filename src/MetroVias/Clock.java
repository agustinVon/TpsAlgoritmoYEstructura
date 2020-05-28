package MetroVias;

//Global clock
public class Clock {

    int time=0;

    public int getTime() {
        return time;
    }

    public void advanceTime(){
        time=time+ 30;
    }
}
