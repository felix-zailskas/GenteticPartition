import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Scanner;

public class Control extends Canvas implements Runnable{
	private ArrayList<Generation> generations = new ArrayList<Generation>();
	private Scanner keyboard;
	private int popSize;
	private int chromLength;
	private int numBlocks;
	private int blockHeights[];
	private int totalHeight;
	private int pixelsPerBlockUnit;
	private int currentGeneration;
	private int bestFitness;
	private int maxFitness;
	private int limit;
	private int notChanged;
	private int localBest;
	private Generation bestGeneration;
	private ArrayList<Block> blocks;
	
	public Control(int popSize, int numBlocks) {
		super();
		this.totalHeight = 0;
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
		this.notChanged = 0;
		this.localBest = 0;
		this.blocks = new ArrayList<Block>(this.numBlocks);
		//we set how many pixels will one block unit measure...
		this.pixelsPerBlockUnit = 800/this.totalHeight;
		initializeBlocks();
		initialGeneration();
		
	}
	
	private void initializeBlocks() {
		for(int i=0;i<blockHeights.length;i++) {
			this.blockHeights[i] = keyboard.nextInt();
			//we add up to the total block height
			this.totalHeight += blockHeights[i];
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

	public void update() {
		
		if(!(notChanged == this.limit || this.bestFitness == this.maxFitness)) {
			
			localBest = generations.get(currentGeneration).getFittestChromosome().getFitness();
			
			if(localBest > this.bestFitness) {
				
				//change towers to draw...
				updateBlockList(generations.get(currentGeneration).getFittestChromosome());
				
				
				
				this.notChanged = 0;
				
			}else {
				
				this.notChanged+=1;
				
			}
			this.generations.add(new Generation(this.popSize, this.generations.get(this.currentGeneration).crossOver(), this.blockHeights));
			this.currentGeneration+=1;
		}
	}
	@Override
	public void run() {
		//target of 80fps...
		double target = 80;
		//equivalent to 1 second per tick...
		double nsPerTick = 1000000000.0/target;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		int fps = 0;
		int tps = 0;
		boolean canRender = false;
		double unprocessed = 0.0;
		  
			
			
			
	    running = true;
	    while(running) {
	    	long now = System.nanoTime();
	    	unprocessed += (now-lastTime)/nsPerTick;
	    	lastTime = now;
	    	
	    	if(unprocessed>=1.0) {
	    		update();
	    		unprocessed--;
	    		tps++;
	    		canRender = true;
	    	}else {
	    		canRender = false;
	    	}
	    	
	    	try {
	    		Thread.sleep(1);
	    	}catch(InterruptedException e){
	    		e.printStackTrace();
	    	}
	    	
	    	if(canRender) {
	    		render();
	    		fps++;
	    	}
	    	if(System.currentTimeMillis() -1000>timer) {
	    		timer +=1000;
	    		System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
	    		fps = 0;
	    		tps = 0;
	    	}
	    }
	    
	    
	    System.exit(1);   // so enclosing JFrame/JApplet exits
		
	}
	
	//update the list of Blocks to be printed, means a new best generation has been found; thus a new best chromosome to be printed...
	private void updateBlockList(Chromosome c) {
		
		for(int i = 0; i < c.getChromSize(); i++) {
			int val;
			
			//we get the value for the gene in index i (true or false)
			boolean current = c.getGenes()[i];
			if (current == true) {
				val = 1;
			}else {
				val = 0;
			}
			
			//we assign different coordinates based on the true or false value, which determines the tower...
			switch(val) {
			
				//means it is tower A (different coordinates than B in x...)
				case 0:
					
				break;
				
				//means it is tower B (different coordinates than A in x...)
				case 1:
					
				break;
				
			}
		}
		
	}
	
	
}
