import java.awt.Color;
import java.awt.Graphics;

public class Hud extends GraphicObject{
	
	private int generation;
	
	
	public Hud(int posX, int posY, Color color){
		//default generation attribute...
		generation = 0;
		
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
