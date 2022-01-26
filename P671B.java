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
        int solution = 0;
        for(int i = 0; i < citizens; i++)
            bank.add(sc.nextInt());
        
        Collections.sort(bank);
        int richestCoins = bank.get(citizens-1);
        int poorestCoins = bank.get(0);
     
        for(int j = 0; j < daysLeft; j++){
            Collections.sort(bank);
            richestCoins = bank.get(citizens-1);
            bank.set(citizens-1, bank.get(citizens-1)-1);
            Collections.sort(bank);
            bank.set(0, bank.get(0)+1);
        }
        Collections.sort(bank);
        richestCoins = bank.get(citizens-1);
        poorestCoins = bank.get(0);
        solution = richestCoins - poorestCoins;
        
        System.out.println(solution);
    }
}

/*System.out.println("Banco: "+bank);
System.out.println("Coins do mais rico: "+richestCoins+", Pos do mais rico: "+posOfTheRichest);
System.out.println("Coins do mais pobre: "+poorestCoins+", Pos do mais pobre: "+posOfThePoorest);
System.out.println("Banco: "+bank);*/

