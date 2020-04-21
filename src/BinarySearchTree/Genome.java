package BinarySearchTree;

public class Genome implements Comparable<Genome> {
    int codeGenome;
    String typeOfGenome;
    String descriptionOfGenome;
    int size;

    public Genome(int codeGenome, String typeOfGenome, String descriptionOfGenome, int size) {
        this.codeGenome = codeGenome;
        this.typeOfGenome = typeOfGenome;
        this.descriptionOfGenome = descriptionOfGenome;
        this.size = size;
    }

    public int getCodeGenome() {
        return codeGenome;
    }

    public void setCodeGenome(int codeGenome) {
        this.codeGenome = codeGenome;
    }

    public String getTypeOfGenome() {
        return typeOfGenome;
    }

    public void setTypeOfGenome(String typeOfGenome) {
        this.typeOfGenome = typeOfGenome;
    }

    public String getDescriptionOfGenome() {
        return descriptionOfGenome;
    }

    public void setDescriptionOfGenome(String descriptionOfGenome) {
        this.descriptionOfGenome = descriptionOfGenome;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Genome o) {
        return codeGenome-o.getCodeGenome();
    }
}
