package problems;
import java.io.*;
import java.util.*;

public class p118A {
	private static class Ler {
		public static String umaString() {
	        String s = "";
	        try {
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	            s = in.readLine();
	        } catch (IOException e) {
	            System.out.println("Erro ao ler fluxo de entrada.");
	        }
	        return s;
    	}
	}

	public static void main(String[] args) {
		String input = Ler.umaString();

		String inputEmArray[] = new String[input.length()];

		for(int i=0; i<input.length(); i++)
			inputEmArray[i] = String.valueOf(input.charAt(i));

		// Elimina vogais
		int contaVogais = 0;
		for(int i=0; i<input.length(); i++){
			if(inputEmArray[i].equals("A") || inputEmArray[i].equals("E") || inputEmArray[i].equals("I") || inputEmArray[i].equals("O") || inputEmArray[i].equals("U") || inputEmArray[i].equals("Y") || inputEmArray[i].equals("a") || inputEmArray[i].equals("e") || inputEmArray[i].equals("i") || inputEmArray[i].equals("o") || inputEmArray[i].equals("u") || inputEmArray[i].equals("y"))
				contaVogais++;
		}
		String inputEmArraySemVogais[] = new String[input.length()-contaVogais];
		int k=0;
		for(int i=0; i<input.length(); i++){
			if(!inputEmArray[i].equals("A") && !inputEmArray[i].equals("E") && !inputEmArray[i].equals("I") && !inputEmArray[i].equals("O") && !inputEmArray[i].equals("U") && !inputEmArray[i].equals("Y") && !inputEmArray[i].equals("a") && !inputEmArray[i].equals("e") && !inputEmArray[i].equals("i") && !inputEmArray[i].equals("o") && !inputEmArray[i].equals("u") && !inputEmArray[i].equals("y")){
				inputEmArraySemVogais[k] = inputEmArray[i];
				k++;
			}
		}

		// Adiciona Pontos antes das consoantes
		int tamanhoArrayPontos = 2*(inputEmArraySemVogais.length);
		String arrayPontos[] = new String[tamanhoArrayPontos];
		for(int i=0; i<arrayPontos.length; i+=2){
			arrayPontos[i] = ".";
		}
		int p = 0;
		for(int i=1; i<arrayPontos.length; i+=2){
			arrayPontos[i] = inputEmArraySemVogais[p];
			p++;
		}

		// Passa as consoantes maiúsculas para consoantes minúsculas
		for(int i=1; i<arrayPontos.length; i+=2){
			if(Character.isUpperCase(arrayPontos[i].charAt(0)));
				arrayPontos[i] = arrayPontos[i].toLowerCase();
		}

		// Mostra resultado final
		for(int i=0; i<(arrayPontos.length); i++)
			System.out.print(arrayPontos[i]);

	}
}