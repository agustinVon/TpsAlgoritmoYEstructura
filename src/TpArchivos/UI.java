package TpArchivos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public static void main(String[] args){
        String sellsRecordFile="C:\\Users\\User\\Documents\\TpsAlgoritmoYEstructura\\src\\TpArchivos\\Files\\salesrecordfile";
        String destinyRecordFile="C:\\Users\\User\\Documents\\TpsAlgoritmoYEstructura\\src\\TpArchivos\\Files\\destinyrecordfile";
        String valueRecordFile="C:\\Users\\User\\Documents\\TpsAlgoritmoYEstructura\\src\\TpArchivos\\Files\\valuerecordfile";

        AbmSales sales=new AbmSales(sellsRecordFile);
        ABMDestination destiny=new ABMDestination(destinyRecordFile);
        ABMExchangeRate exchangeRate=new ABMExchangeRate(valueRecordFile);

        Sale[] salesArr=null;
        Destination[] destinyArr;
        ExchangeRate[] exchangeRateArr=null;

        Scanner scn=new Scanner(System.in);
        while(true){
            switch (menu(scn)){
                case 1:
                    boolean inputIsIncorrect=true;
                    while(inputIsIncorrect) {
                        System.out.println("Enter destination code: ");
                        String destination = scn.next();
                        try {
                            if(!destiny.contains(destination)){
                                destiny.alta(destination);
                                sales.alta(destination);
                                inputIsIncorrect = false;
                            }
                            else{
                                System.out.println("Add to existing destination: ");
                                sales.alta(destination);
                                inputIsIncorrect = false;
                            }

                        }
                        catch(WrongSize | Exception exception){
                            System.out.println(exception.getMessage());
                        }
                    }
                    break;
                case 2:
                    try {
                        exchangeRate.alta();
                    } catch (YearHasFinishedExeption yearHasFinishedExeption) {
                        yearHasFinishedExeption.printStackTrace();  //TODO manejar que pasa si termina el año
                    }
                    break;
                case 3:
                    try {
                        salesArr=sales.obtainArrOfSales();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ArrayList<String> destinys=new ArrayList<>();
                    for (int i = 0; i < salesArr.length; i++) {
                        if(!destinys.contains(salesArr[i].getDestinyCode())){
                            destinys.add(salesArr[i].getDestinyCode());
                        }
                    }
                    exchangeRateArr=exchangeRate.obtainArrOfExchangeRates();

                    for (String destinyCurrent:destinys) {
                        for (int j = 0; j < salesArr.length; j++) {
                            if(salesArr[j].getDestinyCode().equals(destinyCurrent)){
                                double price= salesArr[j].getPriceInDolars() * exchangeRateArr[salesArr[j].getMonth()-1].getDollarValue(); //lina obtiene precio del producto en pesos
                                //obtiene valor en dolar de producto y se fija el valor en pesos de la lista de cotizaciones
                                //sabemos que el valor de cotizacion del dolar esta en la posicion getMonth-1 porque el archivo de cotizacion
                                //esta ordenado por mes
                                System.out.println(salesArr[j].articleCode +" "+ price);
                            }
                        }
                    }
                    break;
                case 4:
                    try {
                        salesArr=sales.obtainArrOfSales();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    destinyArr=destiny.getArrOfDestinations();
                    exchangeRateArr=exchangeRate.obtainArrOfExchangeRates();
                    for (int i = 0; i < exchangeRateArr.length; i++) { //recorro la longitud de exchange porque obtengo los valores en pesos del mes
                        // en caso de que el mes de la venta no tenga una cotizacion establecida este no sera imprimido
                        for (int j = 0; j < salesArr.length; j++) {
                            if(salesArr[j].getMonth()==i+1){
                                double price= salesArr[j].getPriceInDolars()*exchangeRateArr[i].getDollarValue();
                                System.out.println(salesArr[j].articleCode+" "+ price);
                            }
                        }

                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Select valid option");
                    break;
            }
        }
    }

    private static int menu(Scanner scn){
        System.out.println("Select operation: \n");
        System.out.println("1.Add sale");
        System.out.println("2.Add exchange rate");
        System.out.println("3.Get sum of sales in pesos by destiny");
        System.out.println("4.Get sum of sales in pesos by month");
        System.out.println("5.Exit");
        return scn.nextInt();
    }




}
