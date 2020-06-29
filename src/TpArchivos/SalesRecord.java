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
        raf.writeInt(sale.getCuantity());
        raf.writeDouble(sale.getPriceInDolars());
        raf.writeInt(sale.getDay());
        raf.writeInt(sale.getMonth());
    }

    public void close() throws IOException {
        raf.close();
    }

    public void start() throws IOException {
        raf.seek(0);
    }

    public void end() throws IOException {
        raf.seek(raf.length());
    }

    public long cantReg() throws IOException {
        return raf.length()/sizeReg;
    }

    public Sale read() throws IOException {
        try {
            return new Sale(raf.readUTF(),raf.readUTF(),raf.readInt(),raf.readDouble(),new Date(raf.readInt(),raf.readInt()));
        } catch (WrongSize wrongSize) {
            throw new RuntimeException("Corrupted Files");
        }
    }
}
