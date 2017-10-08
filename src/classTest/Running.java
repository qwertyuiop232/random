package classTest;
import java.util.*;

public class Running {

	   public static void main(String [] args) {                    // L 3
		     
		   	  Scanner Scanner;                                          // L 4
		      Scanner = new Scanner(System.in) ;                        // L 5

		      RandomClass randClass;                                        // L 6
		      int lenSide;                                              // L 7
		      double area;                                              // L 8

		      System.out.print("Enter the length of a side: ");          // L 9
		      lenSide = Scanner.nextInt();                              // L 10

		      randClass = new RandomClass(lenSide);                         // L 11
		      area = randClass.calcArea();                               // L 12

		      if (true)
		    	  Scanner.close();
		      System.out.println();                                     // L 13
		      System.out.printf("The area is: %5.2f", area);              // L 14
		      System.out.println();                                     // L 15

		   }                                                            // L 16
}                                                // L 17
                                                       // L 26
     