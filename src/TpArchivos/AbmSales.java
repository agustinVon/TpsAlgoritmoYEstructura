package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AbmSales {

    private String file;

    public AbmSales(String file) {
        this.file = file;
    }

    public void alta() throws IOException {
        SalesRecord salesRecord=new SalesRecord(file);
        Scanner scn= new Scanner(System.in);
        System.out.println("Add new sale: ");
        boolean inputIsCorrect=false;
        int quantity;
        double price;
        int day;
        int month;
        String destiny = "";
        String description="";
        while(!inputIsCorrect){
            System.out.println("Quantity: ");
            quantity=scn.nextInt();
            System.out.println("\nDate: ");
            System.out.println("Day: ");
            day=scn.nextInt();
            System.out.println("Month: ");
            month=scn.nextInt();
            System.out.println("\nPrice: ");
            price=scn.nextDouble();
            System.out.println("Code from destiny: ");
            scn.next();
            System.out.println("Description of product: ");
            scn.next();

            try {
                salesRecord.write(new Sale(destiny,description,quantity,price,new Date(day,month)));
                inputIsCorrect=true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WrongSize wrongSize) {
            }
        }
        salesRecord.close();
    }

    public Sale[] obtainArrOfSales() throws IOException {
        SalesRecord salesRecord=new SalesRecord(file);
        Sale[] sales=new Sale[(int) salesRecord.cantReg()];
        salesRecord.start();
        for (int i = 0; i < salesRecord.cantReg(); i++) {
            sales[i]=salesRecord.read();
        }
        return sales;
    }
}
