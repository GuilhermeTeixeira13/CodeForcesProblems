import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;

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

        
    }

    public Boolean equivalentesBoolean(String a, String b, ArrayList<String> arr){
        boolean equi = false;

        for(int i=0; i<a.length();i++){
            if(b.indexOf(a.charAt(i)) != -1){
                equi = true;
            }
        }

        int pos = 0;
        while(pos<arr.size()){
            if(equivalentesBoolean(a, arr.get(pos), arr) == true || equivalentesBoolean(b, arr.get(pos), arr) ==  true)
                equi = true;
        }

        return equi;
    }

    public ArrayList<String> equivalentes(String a, ArrayList<String> arr){
        ArrayList<String> equivalentesStringA = new ArrayList<String>();

        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<a.length(); j++){
                if(arr.get(i).indexOf(a.charAt(j)) != -1){
                    equivalentesStringA.add(arr.get(i));
                }
            }
            for(int j=0; j<arr.size(); j++){
                if((equivalentesBoolean(a, arr.get(j), arr) == true || equivalentesBoolean(arr.get(i), arr.get(j), arr) ==  true) && i != j){
                    equivalentesStringA.add(arr.get(i));
                }
            }
        }

        return equivalentesStringA;
    }
}
