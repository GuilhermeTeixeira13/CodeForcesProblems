import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class P1263D {
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
        Scanner  in    = new Scanner(System.in);
    	int n = in.nextInt();
        ArrayList<String> palavras = new ArrayList<String>();
        in.nextLine(); 
    	for (int i = 0; i < n; i++) {
        	palavras.add(in.nextLine());
    	}

        System.out.println(equivalentes(palavras.get(0), palavras));
    }

    public static Boolean equivalentesR1(String a, String b){
        boolean equi = false;

        for(int i=0; i<a.length();i++){
            if(b.indexOf(a.charAt(i)) != -1){
                equi = true;
            }
        }

        return equi;
    }

    public static Boolean equivalentesR2(String a, String b, ArrayList<String> arr){
        boolean equi = false;
 
        equi = equivalentesR1(a, b);

        int pos = 0;
        while(pos<arr.size()){
            if(equivalentesR1(a, arr.get(pos)) == true && equivalentesR1(b, arr.get(pos)) ==  true)
                equi = true;
            pos++;
        }

        return equi;
    }

    public static ArrayList<String> equivalentes(String a, ArrayList<String> arr){
        ArrayList<String> equivalentesStringA = new ArrayList<String>();

        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<a.length(); j++){
                if(arr.get(i).indexOf(a.charAt(j)) != -1){
                    equivalentesStringA.add(arr.get(i));
                    break;
                }
            }
            for(int j=0; j<arr.size(); j++){
                if((equivalentesR2(a, arr.get(j), arr) == true && equivalentesR2(arr.get(i), arr.get(j), arr) ==  true) && i != j){
                    equivalentesStringA.add(arr.get(i));
                    break;
                }
            }
        }

        return equivalentesStringA;
    }
}
