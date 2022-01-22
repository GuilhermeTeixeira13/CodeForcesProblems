import java.io.*;
import java.util.*;

public class p71A {
	public static void main(String[] args) {
		Scanner  in    = new Scanner(System.in);
    	String[] input = new String[in.nextInt()];
    	in.nextLine(); //consuming the <enter> from input above

    	for (int i = 0; i < input.length; i++) {
        	input[i] = in.nextLine();
    	}

    	for (String s : input) {
        	if(s.length() > 10)
        		System.out.println((s.charAt(0))+""+(s.length() - 2)+""+(s.charAt(s.length()-1)));        		
        	else
        		System.out.println(s);
    	}
	}
}