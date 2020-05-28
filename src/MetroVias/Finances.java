package MetroVias;

public class Finances {
    int amountOfPayments=0;
    int price;

    //Finances initialization
    Finances(int priceOfTicket){
        price=priceOfTicket;
    }

    //Each time a customer pays, the amount of sales increment by 1
    public void pay() {
        amountOfPayments++;
    }

    public int getEarnings() {
        return amountOfPayments*price;
    }
}
