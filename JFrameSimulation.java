import javax.swing.JFrame;

public class JFrameSimulation extends JFrame{
	
	private Control control;
	private int numBlocks;
	private int popSize;
	private final static int height = 1000;
	private final static int width = 2000;
	
	public JFrameSimulation() {
		super();
		//number of blocks to be used in simulation...
		numBlocks = 20;
		//size of each population along the simulation...
		popSize = 10;
		this.setSize(width, height);
		control = new Control(popSize, numBlocks);
		this.add(control);
		
	}
	
	
	
}
