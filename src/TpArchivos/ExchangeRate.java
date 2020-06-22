package TpArchivos;

public class ExchangeRate {
    private int month;
    private double dollarValue;

    public ExchangeRate(int month, double dollarValue) throws Exception {
        if(month<1 || month>12){
            throw new Exception("Month invalid");
        }
        if(dollarValue < 0){
            throw new Exception("Dollar value invalid");
        }
        this.month = month;
        this.dollarValue = dollarValue;
    }

    public int getMonth() {
        return month;
    }

    public double getDollarValue() {
        return dollarValue;
    }
}
