package TpArchivos;

import java.io.*;
import java.util.ArrayList;

public class DestinationRecord {
    File destinationFile;
    FileOutputStream destinationFOS;
    ObjectOutputStream destinationOOS;
    FileInputStream destinationFIS;
    ObjectInputStream destinationOIS;
    int fileSize, registerSize;

    public DestinationRecord(String directory){
        try {
            destinationFile = new File(directory);
            destinationFOS = new FileOutputStream(destinationFile);
            destinationOOS = new ObjectOutputStream(destinationFOS);
            destinationFIS = new FileInputStream(destinationFile);
            destinationOIS = new ObjectInputStream(destinationFIS);
            registerSize = 23;
            fileSize = 0;
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void write(Destination destination){
        try {
            destinationOOS.writeObject(destination.getDestinationCode());
            destinationOOS.writeObject(destination.getDescription());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        fileSize++;
    }

    public Destination read() throws Exception{
        return new Destination((String) destinationOIS.readObject(), (String) destinationOIS.readObject());
    }

    public void remove(){

    }
}
