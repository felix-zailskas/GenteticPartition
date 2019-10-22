import javax.swing.JFrame;

public class Main{
	private static JFrameSimulation window;
  public static void main(String[] args){
	  /*
      int numBlocks = 20;
      int popSize = 10;
      Control control = new Control(popSize, numBlocks);
      control.startSimulation();
      */
	  window = new JFrameSimulation();
	  window.requestFocus();
	  window.setVisible(true);
	  window.toFront();
	  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
