package problems;
import java.io.*;
import java.util.*;

public class p405A {
	private static class LargestInArray{  
		public static int getLargest(int[] a, int total){  
			int temp, i; 
			int newA[] = new int[total]; 

			for (i = 0; i < total; i++)
				newA[i] = a[i];

			for (i = 0; i < total; i++)   
	        		{  
	            		for (int j = i + 1; j < total; j++)   
	            		{  
	                		if (newA[i] > newA[j])   
	                		{  
	                    		temp = newA[i];  
	                    		newA[i] = newA[j];  
	                    		newA[j] = temp;  
	                		}  
	            		}  
	        		}  
	       		return newA[total-1];  
		}
	} 

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int colunaMax = s.nextInt();
      	
		int blocosNaColuna[]=new int[colunaMax];
		for(int i=0;i<colunaMax;i++)
			blocosNaColuna[i]=s.nextInt();

		
	    int linhaMax = LargestInArray.getLargest(blocosNaColuna, colunaMax);
	   	int matrix[][] = new int[linhaMax][colunaMax];
	   	int l, c, k, i, p, contaZeros = 0, contaUns = 0;

	   	// Preenche Matrix com 1s
	   	for(l=0; l<linhaMax; l++){
	   		for(c=0; c<colunaMax; c++){
	   			matrix[l][c] = 1;
	   		}
	   	}

	   	// Coloca 0s na matrix
	   	for(c=0; c<colunaMax; c++){
	   		k = linhaMax - blocosNaColuna[c];
	   		for(l=0; l<k; l++)
	   			matrix[l][c] = 0;
	   	}

	   	// Altera matrix quando a gravidade se altera
	   	for(l=0; l<linhaMax; l++){
	   		for(c=0; c<colunaMax; c++){
	   			if(matrix[l][c] == 0)
	   				contaZeros++;
	   		}
	   		for(i=0; i<contaZeros; i++)
	   			matrix[l][i] = 0;
	   		for(p=contaZeros; p<colunaMax; p++){
	   			matrix[l][p] = 1;
	   		}
	   		contaZeros = 0;
	   	}

	   	// Conta quantos 1's (nº de blocos) há em cada coluna 
	   	for(c=0; c<colunaMax; c++){
	   		for(l=0; l<linhaMax; l++){
	   			if(matrix[l][c] == 1)
	   				contaUns++;
	   		}
	   		System.out.print(contaUns+" ");
	   		contaUns = 0;
	   	}
	}
}