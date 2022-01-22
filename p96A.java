import java.io.*;
import java.util.*;


public class p96A {
    private static class Ler{
        public static String umaString() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
            while(s.length() > 100){
                in = new BufferedReader(new InputStreamReader(System.in));
                s = in.readLine();
            }
        } 
        catch (IOException e) {
             System.out.println("Erro ao ler fluxo de entrada.");
        }
        return s;
        }
    }

	public static void main(String[] args) {
		String lida = Ler.umaString();
        char seqDe = lida.charAt(0);
        int contaSeguidos = 1;

        for(int i=1;i<lida.length() && contaSeguidos < 7;i++){
            if(lida.charAt(i) == seqDe)
                contaSeguidos++;
            else{
                seqDe = lida.charAt(i);
                contaSeguidos=1;
            }
        }
        if(contaSeguidos >= 7)
            System.out.println("YES");
        else
            System.out.println("NO");
	}
}