package TpArchivos;

import java.util.Scanner;

public class ABMExchangeRate {

    private ExchangeRateRecord exchangeRateRecord;
    private Scanner myScanner;

    public ABMExchangeRate(String directory){
        exchangeRateRecord = new ExchangeRateRecord(directory);
    }

    public void alta() {
        try {
            System.out.println("Add new exchange rate: ");
            System.out.println();
            System.out.println("Enter month: ");
            int month = myScanner.nextInt();
            System.out.println("Enter dollar value: ");
            double dollarValue = myScanner.nextDouble();
            exchangeRateRecord.write(new ExchangeRate(month, dollarValue));
            System.out.println("Destination added successfully");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void baja(){
        System.out.println("Enter month to remove: ");
        int month = myScanner.nextInt();
        exchangeRateRecord.remove(month);
    }

    public ExchangeRate[] obtainArrOfExchangeRates(){
        ExchangeRate[] exchangeRates = new ExchangeRate[exchangeRateRecord.size()];
        for (int i = 0; i < exchangeRateRecord.size(); i++) {
            exchangeRates[i] = exchangeRateRecord.getAllExchangeRates().get(i);
        }
        return exchangeRates;
    }

}
