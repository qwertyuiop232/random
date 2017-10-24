package random;

import java.util.Scanner;

public class UpperCase {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String in, out;
		System.out.println("Enter the string");
		in = scanner.nextLine();
		out = toUpperCase(in);
		System.out.println(out);
		scanner.close();
		
	}
	
	 private static String toUpperCase(String str)
	{
	    char[] ch = str.toCharArray();
	    String upStr = "";
	    for (int i = 0; i < str.length() ; i++) {
	        
	        ch[i] = Character.toUpperCase(ch[i]);
	        upStr += ch[i];
	         
	    }
	    return upStr;
	}


}
