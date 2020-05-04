package BinarySearchTree;

public class Genome implements Comparable<Genome> {
    GenomeCode codeGenome;
    String typeOfGenome;
    String descriptionOfGenome;
    int size;

    public Genome(GenomeCode codeGenome, String typeOfGenome, String descriptionOfGenome, int size) {
        this.codeGenome = codeGenome;
        this.typeOfGenome = typeOfGenome;
        this.descriptionOfGenome = descriptionOfGenome;
        if(size>99 || size<-99){
            throw new RuntimeException();
        }
        this.size = size;
    }

    public GenomeCode getCodeGenome() {
        return codeGenome;
    }

    public String getTypeOfGenome() {
        return typeOfGenome;
    }

    public String getDescriptionOfGenome() {
        return descriptionOfGenome;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Genome o) {
        return codeGenome.compareTo(o.getCodeGenome());
    }

    public boolean equals(Object o){
        Genome toCompare=(Genome) o;
        if(toCompare.getCodeGenome().equals(codeGenome))return true;
        else return false;
    }
}
