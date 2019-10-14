import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
      int numBlocks = 20;
      int popSize = 10;
      Control control = new Control(popSize, numBlocks);
      control.startSimulation();
      
  }
}
