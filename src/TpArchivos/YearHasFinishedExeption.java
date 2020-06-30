package TpArchivos;


public class YearHasFinishedExeption extends Throwable {
    YearHasFinishedExeption(){
        super("Year has ended");
    }
}
