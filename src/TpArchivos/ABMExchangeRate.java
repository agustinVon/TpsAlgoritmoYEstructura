package TpArchivos;

import java.util.Scanner;

public class ABMExchangeRate {

    private ExchangeRateRecord exchangeRateRecord;
    private Scanner myScanner=new Scanner(System.in);
    private int lastMonthAdded=0;

    public ABMExchangeRate(String directory){
        exchangeRateRecord = new ExchangeRateRecord(directory);
    }

    public void alta() throws YearHasFinishedExeption {
        try {
            System.out.println("Add new exchange rate: ");
            System.out.println();
            System.out.println("Enter dollar value: ");
            double dollarValue = myScanner.nextDouble();
            lastMonthAdded=lastMonthAdded+1;
            if(lastMonthAdded>12){
                throw new YearHasFinishedExeption();
            }
            exchangeRateRecord.write(new ExchangeRate(lastMonthAdded, dollarValue));
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

    public void resetYear(){
        //TODO
    }

}
