import java.util.Arrays;
import java.util.Random;

public class Generation{
    public int popSize;
    public Chromosome chromosomes[];

    public Generation(int popSize){
        this.popSize = popSize;
        for (int i = 0; i < this.popSize; i++) {
            chromosomes[i] = new Chromosome();
        }
    }

    public Generation(int popSize, Chromosome chromosomes[]){
        this.popSize = popSize;
        this.chromosomes = chromosomes;
    }
}
