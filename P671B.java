import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;

public class P671B {
    public static FastReader sc;
    public static PrintWriter out;
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer str;
 
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
 
        String next()
        {
            while (str == null || !str.hasMoreElements())
            {
                try
                {
                    str = new StringTokenizer(br.readLine());
                }
                catch (IOException  end)
                {
                    end.printStackTrace();
                }
            }
            return str.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException end)
            {
                end.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) throws java.lang.Exception{
        out = new PrintWriter(new BufferedOutputStream(System.out));
        sc = new FastReader();
        int citizens = sc.nextInt();
        int daysLeft = sc.nextInt();
        ArrayList<Integer> bank = new ArrayList<Integer>();
        for(int i = 0; i < citizens; i++)
            bank.add(sc.nextInt());
        
        int richestCoins = bank.get(0);
        int posOfTheRichest = 0;
        int poorestCoins = bank.get(0);
        int posOfThePoorest = 0;
        for(int j = 0; j < daysLeft; j++){
            for(int i = 0; i < citizens; i++){
                if(bank.get(i)>richestCoins){
                    richestCoins = bank.get(i);
                    posOfTheRichest = i;
                }
                if(bank.get(i)<poorestCoins){
                    poorestCoins = bank.get(i);
                    posOfThePoorest = i;
                }
            }
            bank.set(posOfTheRichest, bank.get(posOfTheRichest)-1);
            bank.set(posOfThePoorest, bank.get(posOfThePoorest)+1);
        }

        richestCoins = bank.get(0);
        poorestCoins = bank.get(0);
        for(int i = 0; i < citizens; i++){
            if(bank.get(i)>richestCoins)
                richestCoins = bank.get(i); 
            if(bank.get(i)<poorestCoins)
                poorestCoins = bank.get(i);
        }
        System.out.println(richestCoins-poorestCoins);
    }
}