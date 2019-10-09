import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//variables and objects...
	private PaintingCanvas canvas;
	
	 
	public Window(int width, int height) {
		super();
		setLayout(new BorderLayout());
		canvas = new PaintingCanvas();
		this.add(canvas, BorderLayout.CENTER);
		this.setSize(width, height);
	}
}	
