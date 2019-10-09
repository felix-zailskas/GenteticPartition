import java.util.Arrays;
import java.util.Random;

public class Chromosome{
    public int chromSize;
    public boolean genes[];
    public int fitness;

    public Chromosome(int chromSize){
        this.chromSize = chromSize;
        Random random = new Random();
        for (int i = 0; i < this.chromSize; i++) {
            this.genes[i] = random.nextBoolean();
        }
    }

    public Chromosome(int chromSize, boolean genes[]){
        this.chromSize = chromSize;
        this.genes = genes;
    }


    public void mutate(){
        Random random = new Random();
        int toMutate = random.nextInt(101);
        int change;
    }
}
