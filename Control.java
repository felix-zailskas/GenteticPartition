import java.util.ArrayList;
import java.util.Scanner;

public class Control {
	private ArrayList<Generation> generations = new ArrayList<Generation>();
	private Scanner keyboard;
	private int popSize;
	private int chromLength;
	private int numBlocks;
	private int blockHeights[];
	private int currentGeneration;
	private int bestFitness;
	private int maxFitness;
	private int limit;
	private Generation bestGeneration;
	
	public Control(int popSize, int numBlocks) {
		this.keyboard = new Scanner(System.in);
		this.popSize = popSize;
		this.chromLength = numBlocks;
		this.numBlocks = chromLength;
		this.currentGeneration = 0;
		this.bestFitness = 0;
		this.maxFitness = 0;
		this.limit = 40;
		this.bestGeneration = null;
		this.blockHeights = new int[this.numBlocks];
		initializeBlocks();
		initialGeneration();
		
	}
	
	private void initializeBlocks() {
		
		for(int i=0;i<blockHeights.length;i++) {
			this.blockHeights[i] = keyboard.nextInt();
			this.maxFitness+=this.blockHeights[i];
		}
	}
	private void initialGeneration() {
		generations.add(new Generation(this.popSize, this.numBlocks, this.blockHeights));
	}
	
	public void startSimulation() {
		int notChanged=0;
		int localBest = 0;
		while(!(notChanged == this.limit ||this.bestFitness == this.maxFitness)) {
			localBest = generations.get(currentGeneration).getFittestChromosome().getFitness();
			if(localBest > this.bestFitness) {
				System.out.println("Current best generation: ");
				this.generations.get(this.currentGeneration).printChromosomes();
				this.bestFitness = localBest;
				this.bestGeneration = this.generations.get(this.currentGeneration);
				notChanged = 0;
			}else {
				notChanged++;
			}
			
			generations.add(new Generation(this.popSize, this.generations.get(this.currentGeneration).crossOver(),this.blockHeights));
			this.currentGeneration++;
			
		
		}
		/*for(int i=0;i<this.generations.size();i++) {
			this.generations.get(i).printChromosomes();
		}*/
		System.out.println("\n\nBest generation: ");
		this.bestGeneration.printChromosomes();
		System.out.println("MAX FITNESS FOR SIMULATION: "+ this.maxFitness+" Final generation: "+this.currentGeneration);
	}
	
	
}
