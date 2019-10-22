import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Hud extends GraphicObject{
	
	private int generation;
	private boolean finalGeneration;
	private int mutationChance;
	private float accuracy;
	
	public Hud(){
		//default generation attribute...
		generation = 0;
		
	}
	@Override
	public void render(Graphics g) {
		//title of towers
		g.setColor(color.black);
		g.setFont(new Font("Arial", Font.PLAIN, 35)); 
		g.drawString("Accuracy: "+this.accuracy+"%", 60, 160);
		g.drawString("Tower A", 350, 450);
		g.drawString("Tower B", 900, 450);
		if(!this.finalGeneration) {
			g.drawString("Current generation: "+this.generation, 60, 80);
		}else {
			g.setColor(color.red);
			g.drawString("Final generation: "+this.generation, 60, 80);
			g.setColor(color.black);
			g.drawString("Accuracy: "+this.accuracy+"%", 60, 160);
		}
		
		
	}
	public boolean isFinalGeneration() {
		return finalGeneration;
	}
	public void setFinalGeneration(boolean finalGeneration) {
		this.finalGeneration = finalGeneration;
	}
	public int getMutationChance() {
		return mutationChance;
	}
	public void setMutationChance(int mutationChance) {
		this.mutationChance = mutationChance;
	}
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}
}
