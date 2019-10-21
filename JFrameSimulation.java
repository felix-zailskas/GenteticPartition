import javax.swing.JFrame;

public class JFrameSimulation extends JFrame{
	
	private Control control;
	private int numBlocks;
	private int popSize;
	public JFrameSimulation() {
		super();
		//number of blocks to be used in simulation...
		numBlocks = 20;
		//size of each population along the simulation...
		popSize = 10;
		control = new Control(numBlocks, popSize);
		
	}
	
	
	
}
