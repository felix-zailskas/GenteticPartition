import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

// a chromosome has a boolean array of genes determining on which tower a certain block should be
public class Chromosome{
    private int chromSize;
    private boolean genes[];
    private int blockHeights[];
    private int fitness;
    private int mutationChance = 30;

    
	// create a chromosome with random genes
    public Chromosome(int chromSize, int blockHeights[]){
        this.chromSize = chromSize;
        this.genes = new boolean[this.chromSize];
        this.blockHeights = blockHeights.clone();
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < this.chromSize; i++) {
            this.genes[i] = random.nextBoolean();
            if (this.genes[i]) count++;
        }
        if (count == 0 || count == this.chromSize) this.forceMutate();
        this.fitness = this.calculateFitness();
    }

    // create a chromosome with given genes
    public Chromosome(int chromSize, boolean genes[], int blockHeights[]){
        this.chromSize = chromSize;
        this.genes = genes.clone();
        this.blockHeights = blockHeights.clone();
        this.fitness = this.calculateFitness();
    }

    // getter
    public int getChromSize(){
        return this.chromSize;
    }

    // getter
    public boolean[] getGenes(){
        return this.genes;
    }

    // gettter
    public int getFitness(){
        return this.fitness;
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

    // guranteed mutation
    public void forceMutate(){
        Random random = new Random();
        int index = random.nextInt(this.chromSize);
        this.genes[index] = !this.genes[index];
    }

    // calculate the fitness of this chromosome based on the towers it creates
    public int calculateFitness() {
        int maxFit = 0;
        int height1 = 0;
        int height2 = 0;
        int distance;
        // maximum fitness is the sum of the height of all blocks
        for (int i = 0; i < this.blockHeights.length; i++) {
            maxFit += this.blockHeights[i];
            // if genes[i] = true the block is on tower 1
            if (this.genes[i]){
                height1 += this.blockHeights[i];
            }
            // if genes[i] = false the block is on tower 2
            else {
                height2 += this.blockHeights[i];
            }
        }
        distance = Math.abs(height1 - height2);
        // the fitness is the maximum fitness minus the distance of tower 1 and tower 2
        return maxFit - distance;
    }
    
    public int[] getBlockHeights() {
		return blockHeights;
	}

	public void setBlockHeights(int[] blockHeights) {
		this.blockHeights = blockHeights;
	}

	public int getMutationChance() {
		return mutationChance;
	}

	public void setMutationChance(int mutationChance) {
		this.mutationChance = mutationChance;
	}

	public void setChromSize(int chromSize) {
		this.chromSize = chromSize;
	}

	public void setGenes(boolean[] genes) {
		this.genes = genes;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

}
