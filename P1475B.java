import java.util.*;

public class P1475B {

    public static void main(String[] args) {    
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        int n[] = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = s.nextInt();
        }
    
        int divInt;
        for (int j = 0; j < t; j++) {
            divInt = n[j]/2021;
            if (n[j] < 2020)
                System.out.println("NO");
            else{
                if (n[j] % 2020 == 0 || n[j] % 2021 == 0)
                    System.out.println("YES");
                else{
                    if (n[j] % 2021 >= (2021-divInt) || n[j] % 2020 <= divInt) 
                        System.out.println("YES");
                    else 
                        System.out.println("NO");
                    
                }
            }
        }
    }
}
