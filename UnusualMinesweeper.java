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

            Board board = new Board(k);
            board.setMines(mines);

            board.buildBoard();
        }
    }
}

class Mine {
    Point location = new Point();
    private int TimeUntilExplosion;

    public Mine(){
        Point location = new Point();
        this.TimeUntilExplosion = TimeUntilExplosion;
    }

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
    public int getTimeUntilExplosion(){
        return TimeUntilExplosion;
    }

    public void setLocation(int x, int y){
        this.location.x = x;
        this.location.y = y;
    }
}

class Board {
    ArrayList<Mine> mines;
    int k;

    public Board(int k){
        ArrayList<Mine> mines = new ArrayList<Mine>();
        this.k = k;
    }

    public void setMines(ArrayList<Mine> mines){
        this.mines = (ArrayList<Mine>) mines.clone();
    }

    public int calculateBoardSize(){
        double lowerCordinateX = 0;
        double lowerCordinateY = 0;
        double higherCordinate = 0;
        int transactionX = 0;
        int transactionY = 0;
        Mine mineFarAwayX = new Mine();
        Mine mineFarAwayY = new Mine();
        for(int i = 0; i < this.mines.size() ; i++){
            if(mines.get(i).getLocationX() < lowerCordinateX){
                mineFarAwayX = this.mines.get(i);
                lowerCordinateX = mines.get(i).getLocationX();
            }
            if(mines.get(i).getLocationY() < lowerCordinateY){
                mineFarAwayY = this.mines.get(i);
                lowerCordinateY = mines.get(i).getLocationY();
            }
        }
        transactionX = (int)mineFarAwayX.getLocationX()*-1;
        transactionY = (int)mineFarAwayY.getLocationY()*-1;

        for(int i = 0; i < this.mines.size() ; i++){
            mines.get(i).setLocation((int)mines.get(i).getLocationX()+transactionX, (int)mines.get(i).getLocationY()+transactionY);

            if(mines.get(i).getLocationX() > higherCordinate)
                higherCordinate = mines.get(i).getLocationX();
            if(mines.get(i).getLocationY() > higherCordinate)
            higherCordinate = mines.get(i).getLocationY();
        }

        return (int)higherCordinate;
    }

    public void printBoard(int higherCordinate, int[][] board){
        System.out.println();
        for(int y=higherCordinate; y>=0; y--){
            for(int x=0; x<=higherCordinate; x++){
                System.out.print(board[y][x]+" ");
            }
            System.out.println();
        }
    }

    public void buildBoard(){
        int higherCordinate = calculateBoardSize();;

        int[][] board = new int[higherCordinate+1][higherCordinate+1];

        for(int y=0; y<higherCordinate; y++){
            for(int x=0; x<higherCordinate; x++){
                board[y][x] = 0;
            }
        }

        for(int i = 0; i<this.mines.size(); i++){
            board[(int)this.mines.get(i).getLocationY()][(int)this.mines.get(i).getLocationX()] = this.mines.get(i).getTimeUntilExplosion();
        }

        printBoard(higherCordinate, board);
    }
}
