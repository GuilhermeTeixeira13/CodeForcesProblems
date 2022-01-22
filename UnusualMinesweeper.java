import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.Point;

public class UnusualMinesweeper {
    public static String[] ReadLine() throws IOException{
        BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
        String[] Strings = Reader.readLine().split(" ");
        return Strings;
    }
    public static void main(String[] args) throws IOException{
        String[] T_String = ReadLine();
        int t = Integer.parseInt(T_String[0]);

        for(int testCase = 0; testCase<t; testCase++){
            System.out.println("");
            String[] N_K_String = ReadLine();

            int n = Integer.parseInt(N_K_String[0]);
            int k = Integer.parseInt(N_K_String[1]);
            ArrayList<Mine> mines = new ArrayList<Mine>();

            for(int mineCount = 0; mineCount < n; mineCount++){
                String[] X_Y_TimeUntilExplosion_String = ReadLine();

                int TimeUntilExplosion = Integer.parseInt(X_Y_TimeUntilExplosion_String[2]);
                int LocationX = Integer.parseInt(X_Y_TimeUntilExplosion_String[0]);
                int LocationY = Integer.parseInt(X_Y_TimeUntilExplosion_String[1]);

                Mine mine = new Mine(TimeUntilExplosion);
                mine.setLocation(LocationX, LocationY);
                mines.add(mine);
            }

            // tabuleiro recebe minas e k
        }
    }
}

class Mine {
    Point location;
    private int TimeUntilExplosion;

    public Mine(int TimeUntilExplosion){
        Point location = new Point();
        this.TimeUntilExplosion = TimeUntilExplosion;
    }

    public double getLocationX(){
        return this.location.getX();
    }
    public double getLocationY(){
        return this.location.getY();
    }

    public void setLocation(double x, double y){
        this.location.setLocation(x, y);
    }
}
