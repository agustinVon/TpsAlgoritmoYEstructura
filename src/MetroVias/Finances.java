package MetroVias;

public class Finances {
    int amountOfPayments=0;
    int price;

    Finances(int priceOfTicket){
        price=priceOfTicket;
    }

    public void pay() {
        amountOfPayments++;
    }

    public int getEarnings() {
        return amountOfPayments*price;
    }
}
