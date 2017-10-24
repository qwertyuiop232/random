package random;

import java.util.Scanner;

public class DoubleVowels {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type in anything and the vowels will be doouubleed");
		String input = scanner.nextLine();
		String output = doubleVowel(input);
		System.out.println(output);
		scanner.close();
	}
	
	public static String doubleVowel(String str)
	{
	    String out = "";
	    char[] ch = str.toCharArray();
	    for (int i = 0; i < ch.length; i++)
	    {
	        if (ch[i] == 'o')
	        out += "o";
	        if (ch[i] == 'e')
	        out += "e";
	        if (ch[i] == 'i')
	        out += "i";
	        if (ch[i] == 'u')
	        out += "u";
	        if (ch[i] == 'a')
	        out += "a";
	        out += ch[i];
	    }
	    
	    return out;
	}
}
