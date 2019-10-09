import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

// a Generation consists of a set of chromosomes representing a certain partition of the blocks
public class Generation{
    private int popSize;
    private Chromosome chromosomes[];

    // create a Generation with random chromosomes
    public Generation(int popSize, int chromLength){
        this.popSize = popSize;
        this.chromosomes = new Chromosome[popSize];
        for (int i = 0; i < this.popSize; i++) {
            chromosomes[i] = new Chromosome(chromLength);
        }
    }

    // create a Generation with a given set of chromosomes
    public Generation(int popSize, Chromosome chromosomes[]){
        this.popSize = popSize;
        this.chromosomes = chromosomes;
    }

    // mutate all chromosomes inside the Generation
    public void mutateChromosomes(){
        for (int i = 0; i < this.popSize; i++) {
            this.chromosomes[i].mutate();
        }
    }

    // create a new Generation by crossing over chromosomes based on fitness values
    public Chromosome[] crossOver(){
        Chromosome newGen[] = new Chromosome[this.popSize];
        ArrayList<Integer> possibleParents = new ArrayList<Integer>();
        Random random = new Random();
        int crossIndex = random.nextInt(this.chromosomes[0].getChromSize());
        // fill array list with possible parents based on their fitness
        for (int i = 0; i < this.popSize; i++) {
            int fitness = chromosomes[i].calculateFitness();
            for (int j = 0; j < fitness; j++) {
                possibleParents.add(i);
            }
        }

        for (int i = 0; i < this.popSize; i++) {
            // for each Chromosome in the new Generation choose two parents
            int parent1 = possibleParents.get(random.nextInt(possibleParents.size()));
            int parent2 = possibleParents.get(random.nextInt(possibleParents.size()));
            // make genes for new chromosome
            boolean childGenes[] = new boolean[this.chromosomes[0].getChromSize()];
            for (int j = 0; j < childGenes.length; j++) {
                // choose from which parent genes should be inhereted
                if (j < crossIndex) {
                    childGenes[j] = this.chromosomes[parent1].getGenes()[j];
                }
                else {
                    childGenes[j] = this.chromosomes[parent2].getGenes()[j];
                }
            }
            // add a new chromosome to the new Generation with the generated genes
            newGen[i] = new Chromosome(this.chromosomes[0].getChromSize(), childGenes);
        }
        return newGen;
    }
}
