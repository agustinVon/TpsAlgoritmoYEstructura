package TpArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SalesRecord {
    private File f;
    private RandomAccessFile raf;
    private int sizeReg =38;


    SalesRecord(String name) throws FileNotFoundException {
        f= new File(name);
        raf=new RandomAccessFile(f,"rw");
    }

    public void write(Sale sale) throws IOException {
        raf.writeUTF(sale.getDestinyCode());
        raf.writeUTF(sale.getArticleCode());
    }
}
