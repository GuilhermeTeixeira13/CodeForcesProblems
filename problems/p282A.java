package problems;
import java.io.*;
import java.util.*;

public class p282A {
	public static void main(String[] args) {
		Scanner  in    = new Scanner(System.in);
    	String[] input = new String[in.nextInt()];
    	in.nextLine(); 
    	int x = 0;

    	for (int i = 0; i < input.length; i++) {
        	input[i] = in.nextLine();
    	}

    	for (String s : input) {
        	if(s.equals("++X") || s.equals("X++"))
        		x++;
        	else if(s.equals("--X") || s.equals("X--"))
        		x--;
    	}
    	System.out.println(x);
	}
}