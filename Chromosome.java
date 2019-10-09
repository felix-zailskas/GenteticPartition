import java.util.Arrays;
import java.util.Random;

// a chromosome has a boolean array of genes determining on which tower a certain block should be
public class Chromosome{
    private int chromSize;
    private boolean genes[];
    private int fitness;
    private int mutationChance = 10;

    // create a chromosome with random genes
    public Chromosome(int chromSize){
        this.chromSize = chromSize;
        this.genes = new boolean[this.chromSize];
        Random random = new Random();
        for (int i = 0; i < this.chromSize; i++) {
            this.genes[i] = random.nextBoolean();
        }
    }

    // create a chromosome with given genes
    public Chromosome(int chromSize, boolean genes[]){
        this.chromSize = chromSize;
        this.genes = genes;
    }

    // getter
    public int getChromSize(){
        return this.chromSize;
    }

    // getter
    public boolean[] getGenes(){
        return this.genes;
    }

    // mutate this chromosome; the chance of mutation is given by mutationChance in percent
    public void mutate(){
        Random random = new Random();
        int toMutate = random.nextInt(101);
        int index = random.nextInt(this.chromSize);
        if (toMutate < this.mutationChance) {
            this.genes[index] = !this.genes[index];
        }
    }

    // calculate the fitness of this chromosome based on the towers it creates
    public int calculateFitness() {

        return 0;
    }
}
