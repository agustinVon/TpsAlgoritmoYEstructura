package TpArchivos;

import java.io.*;
import java.util.ArrayList;

public class DestinationRecord {
    private File destinationFile;
    private ArrayList<Destination> destinations;

    public DestinationRecord(String directory){
        try {
            destinationFile = new File(directory);
            if(destinationFile.exists()){
                recover();
            }
            else{
                destinations = new ArrayList<Destination>();
            }
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void write(Destination destination){
        try {
            destinations.add(destination);
            FileOutputStream destinationFOS = new FileOutputStream(destinationFile);
            ObjectOutputStream destinationOOS = new ObjectOutputStream(destinationFOS);
            destinationOOS.writeObject(destinations);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public ArrayList<Destination> getAllDestinations(){
        return destinations;
    }

    public Destination search(String code) throws Exception {
        for (int i = 0; i < destinations.size(); i++) {
            if(destinations.get(i).getCode().equals(code)){
                return destinations.get(i);
            }
        }
        throw new Exception("Destination not found");
    }

    public void remove(){
        //TODO
    }

    private void recover() {
        try {
            FileInputStream destinationsFIS = new FileInputStream(destinationFile);
            ObjectInputStream destinationsOIS = new ObjectInputStream(destinationsFIS);
            destinations = (ArrayList<Destination>) destinationsOIS.readObject();
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
