import java.awt.Color;
import java.awt.Graphics;

public class Block extends GraphicObject {
	
	
	private int height;
	private int width;
	
	public Block(int posX, int posY, int height, int width) {
		//automatically gives color in super contructor...
		super();
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		
		
	}

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}


	@Override
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.posX, this.posY, this.width, this.height);
		
	}
}
