package TpArchivos;

import java.util.Scanner;

public class ABMDestination {

    private DestinationRecord destinationRecord;
    private Scanner myScanner=new Scanner(System.in);

    public ABMDestination(String directory){
        destinationRecord = new DestinationRecord(directory);
    }

    public void alta(String code){

        System.out.println("Enter description of destination: ");
        String description = myScanner.nextLine();
        destinationRecord.write(new Destination(code, description));
        System.out.println("Destination added successfully");

    }

    public void baja(){
        System.out.println("Remove a destination: ");
        System.out.println();
        System.out.println("Enter code of destination to remove: ");
        int code = myScanner.nextInt();
        destinationRecord.remove(code);
    }

    public void modificacion(){
        System.out.println("Modify a destination: ");
        System.out.println();
        System.out.println("Enter code of destination to modify: ");
        String code = myScanner.nextLine();
        System.out.println("Enter new description: ");
        String newDescrip = myScanner.nextLine();
        if(destinationRecord.modify(code, newDescrip)){
            System.out.println("Destination modified successfully");
        }
        else{
            System.out.println("Failed to modify destination");
        }
    }

    public boolean contains(String code) throws Exception {
        return destinationRecord.contains(code);
    }

    public Destination[] getArrOfDestinations(){
        Destination[] destinations = new Destination[destinationRecord.size()];
        for (int i = 0; i < destinationRecord.size(); i++) {
            destinations[i] = destinationRecord.getAllDestinations().get(i);
        }
        return destinations;
    }
}
