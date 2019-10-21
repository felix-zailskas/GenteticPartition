import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class GraphicObject {
	protected int posX;
	protected int posY;
	protected Color color;
	protected Random r;
	
	public GraphicObject() {
		posX=0;
		posY=0;
		//color= new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
	}

	
	public abstract void render(Graphics g);
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
	
	
}
