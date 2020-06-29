package TpArchivos;

import java.io.*;
import java.util.ArrayList;

public class ExchangeRateRecord {

    File exchangeRateFile;
    ArrayList<ExchangeRate> exchangeRates;

    public ExchangeRateRecord(String directory){
        try {
            exchangeRateFile = new File(directory);
            if(exchangeRateFile.exists()){
                recover();
            }
            else{
                exchangeRates = new ArrayList<ExchangeRate>();
            }
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void write(ExchangeRate exchangeRate){
        try {
            exchangeRates.add(exchangeRate);
            write(exchangeRates);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void write(ArrayList<ExchangeRate> exchangeRates){
        try {
            FileOutputStream exchangeRateFOS = new FileOutputStream(exchangeRateFile);
            ObjectOutputStream exchangeRateOOS = new ObjectOutputStream(exchangeRateFOS);
            exchangeRateOOS.writeObject(exchangeRates);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public ArrayList<ExchangeRate> getAllExchangeRates(){
        return exchangeRates;
    }

    public ExchangeRate search(int month) throws Exception {
        for (int i = 0; i < exchangeRates.size(); i++) {
            if(exchangeRates.get(i).getMonth() == month){
                return exchangeRates.get(i);
            }
        }
        throw new Exception("Exchange rate not found");
    }

    public void remove(int month){
        //TODO
    }

    public int size(){
        return exchangeRates.size();
    }

    private void recover(){
        try {
            FileInputStream exchangeRateFIS = new FileInputStream(exchangeRateFile);
            ObjectInputStream exchangeRateOIS = new ObjectInputStream(exchangeRateFIS);
            exchangeRates = (ArrayList<ExchangeRate>) exchangeRateOIS.readObject();
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
