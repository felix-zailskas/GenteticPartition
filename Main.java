import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main{
  public static void main(String[] args){
      int numBlocks = 20;
      int chromLength = numBlocks;
      int popSize = 10;
      int blockHeights[] = new int[numBlocks];
      Scanner scanner = new Scanner(System.in);

      // input the block heights
      System.out.println("Input " + numBlocks + " heights of blocks");
      for (int i = 0; i < numBlocks; i++) {
          blockHeights[i] = scanner.nextInt();
      }

      // print all block sizes
      for (int i = 0; i < numBlocks; i++) {
          System.out.println(blockHeights[i]);
      }
  }
}
