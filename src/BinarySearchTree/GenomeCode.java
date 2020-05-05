package BinarySearchTree;

public class GenomeCode implements Comparable<GenomeCode> {

    String code;

    GenomeCode(String code) throws CodeIsNotCorrectSize {
        if(code.length() != 5) throw new CodeIsNotCorrectSize();
        else{
            this.code=code;
        }
    }

    public String getCode() {
        return code;
    }

    public boolean equals(Object o){
        GenomeCode toCompare= (GenomeCode) o;
        return code.equals(toCompare.getCode());
    }

    @Override
    public int compareTo(GenomeCode o) {
        return code.compareTo(o.getCode());
    }
}
