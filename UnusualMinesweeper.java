import java.io.IOException;
import java.util.ArrayList;
import java.awt.Point;
import java.util.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;

public class UnusualMinesweeper {
    public static String[] ReadLine() throws IOException{
        Scanner scaninput = new Scanner(System.in);
        String inputSentence = scaninput.nextLine();
        String[] result=inputSentence.split(" ");
        return result;
    }
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
        int t = sc.nextInt();

        ArrayList<Integer> solution = new ArrayList<Integer>();
        for(int testCase = 0; testCase<t; testCase++){
            System.out.println("");
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Mine> mines = new ArrayList<Mine>();
            for(int mineCount = 0; mineCount < n; mineCount++){
                int LocationX = sc.nextInt();
                int LocationY = sc.nextInt();
                int TimeUntilExplosion = sc.nextInt();
                Mine mine = new Mine(TimeUntilExplosion);
                mine.setLocation(LocationX, LocationY);
                mines.add(mine);
            }
            //System.out.println(mines+"\nn="+n+"  k="+k);
            Board board = new Board(k);
            board.setMines(mines);
            board.buildBoard();
            int timeUntilAllExplodes=-1;
            Mine mineChoosedToExplode = new Mine();
            ArrayList<Mine> minesThatWillExplodeNEXT = new ArrayList<Mine>();
            ArrayList<Mine> minesThatWillExplodeNEXTCopy = new ArrayList<Mine>();
            ArrayList<Mine> minesThatWillExplodeAroundTheChoice = new ArrayList<Mine>();
            ArrayList<Mine> minesThatWillExplodeByTime = new ArrayList<Mine>();
            while(board.verifyIfAllMinesExploded() == false){
                timeUntilAllExplodes++;
                minesThatWillExplodeByTime = board.explodeMinesWithTime(timeUntilAllExplodes);
                mineChoosedToExplode = board.chooseMineToExplode();
                minesThatWillExplodeAroundTheChoice = board.explodeMinesAround(mineChoosedToExplode);
                minesThatWillExplodeNEXT.addAll(minesThatWillExplodeAroundTheChoice);
                minesThatWillExplodeNEXT.addAll(minesThatWillExplodeByTime);
                
                while(!minesThatWillExplodeNEXT.isEmpty() == true){
                    minesThatWillExplodeNEXTCopy = (ArrayList<Mine>) minesThatWillExplodeNEXT.clone();
                    minesThatWillExplodeNEXT.clear();
                    for(int l=0; l < minesThatWillExplodeNEXTCopy.size(); l++){
                        minesThatWillExplodeNEXT.addAll(board.explodeMinesAround(minesThatWillExplodeNEXTCopy.get(l)));
                    }
                };
            }
            solution.add(timeUntilAllExplodes);
        }
        for(int o = 0; o < solution.size(); o++)
            System.out.println(solution.get(o));
        out.close();
    }
}
class Mine {
    Point location = new Point();
    private int TimeUntilExplosion;
    private boolean exploded;
    public Mine(){
        Point location = new Point();
        this.TimeUntilExplosion = 0;
        this.exploded = false;
    }
    public Mine(int TimeUntilExplosion){
        Point location = new Point();
        this.TimeUntilExplosion = TimeUntilExplosion;
        this.exploded = false;
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
    public void setTimeUntilExplosion(int time){
        this.TimeUntilExplosion = time;
    }
    public void setLocation(int x, int y){
        this.location.x = x;
        this.location.y = y;
    }
    public void setExploded(boolean state){
        this.exploded = state;
    }
    public boolean getStateOfMine(){
        return this.exploded;
    }
    public String toString(){
        String s;
        s = "Location:"+this.location;
        return s;
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
    public int getHigherCordinate(){
        double higherCordinate = 0;
        for(int i = 0; i < this.mines.size() ; i++){
            if(mines.get(i).getLocationX() > higherCordinate)
                higherCordinate = mines.get(i).getLocationX();
            if(mines.get(i).getLocationY() > higherCordinate)
                higherCordinate = mines.get(i).getLocationY();
        }
        return (int) higherCordinate;
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
        for(int i = 0; i < this.mines.size() ; i++)
            mines.get(i).setLocation((int)mines.get(i).getLocationX()+transactionX, (int)mines.get(i).getLocationY()+transactionY);
        
        higherCordinate = getHigherCordinate();
        return (int)higherCordinate;
    }
    public void printBoard(int higherCordinate, int[][] board){
        System.out.println();
        for(int y=higherCordinate+2; y>=0; y--){
            for(int x=0; x<=higherCordinate+2; x++){
                System.out.print(board[y][x]+" ");
            }
            System.out.println();
        }
    }
    public void buildBoard(){
        int higherCordinate = calculateBoardSize();;
        int[][] board = new int[higherCordinate+3][higherCordinate+3];
        for(int y=0; y<higherCordinate+3; y++){
            for(int x=0; x<higherCordinate+3; x++){
                board[y][x] = 0;
            }
        }
        for(int i = 0; i<this.mines.size(); i++){
            board[(int)this.mines.get(i).getLocationY()][(int)this.mines.get(i).getLocationX()] = this.mines.get(i).getTimeUntilExplosion();
        }
        printBoard(higherCordinate, board);
    }
    public Mine chooseMineToExplode(){
        int higherTimeToExplode = 0;
        Mine mineToExplode = new Mine();
        for(int i=0; i<this.mines.size(); i++){   
            if(this.mines.get(i).getTimeUntilExplosion() > higherTimeToExplode && this.mines.get(i).getStateOfMine() == false){
                higherTimeToExplode = this.mines.get(i).getTimeUntilExplosion();
                mineToExplode = this.mines.get(i);
            }
        }
        mineToExplode.setExploded(true);
        mineToExplode.setTimeUntilExplosion(-1);
        return mineToExplode;
    }
    public boolean verifyIfAllMinesExploded(){
        int countExplosions=0; 
        for(int i=0; i<this.mines.size(); i++){
            if(this.mines.get(i).getStateOfMine() == true)
                countExplosions += 1;
        }
        if(this.mines.size() == countExplosions)
            return true;
        else
            return false;
    }
    public ArrayList<Mine> explodeMinesAround(Mine mainMine){
        int mainMineX = (int)mainMine.getLocationX();
        int mainMineY = (int)mainMine.getLocationY();
        int x1, x2, y1, y2;
        ArrayList<Mine> SelectedCases = new ArrayList<Mine>();
        ArrayList<Mine> MinesThatWillAutomaticlyExplode = new ArrayList<Mine>();
        for(int i = 1; i <= this.k; i++){
            x1 = mainMineX + i; 
            Mine mine1 = new Mine();
            mine1.setLocation(x1, mainMineY);
            SelectedCases.add(mine1);
            y1 = mainMineY + i; 
            Mine mine2 = new Mine();
            mine2.setLocation(mainMineX, y1);
            SelectedCases.add(mine2);
            x2 = mainMineX - i; 
            if(x2 < 0)
                x2 = 0;
            Mine mine3 = new Mine();
            mine3.setLocation(x2, mainMineY);
            SelectedCases.add(mine3);
            y2 = mainMineY - i; 
            if(y2 < 0)
                y2 = 0;
            Mine mine4 = new Mine();
            mine4.setLocation(mainMineX, y2);
            SelectedCases.add(mine4);
        }
        for(int j = 0; j < SelectedCases.size(); j++){
            for(int k = 0; k < this.mines.size(); k++){
                if( (SelectedCases.get(j).getLocationX() == this.mines.get(k).getLocationX())  &&  (SelectedCases.get(j).getLocationY() == this.mines.get(k).getLocationY())  &&  (this.mines.get(k).getStateOfMine() == false)){
                    this.mines.get(k).setExploded(true);
                    this.mines.get(k).setTimeUntilExplosion(-1);
                    MinesThatWillAutomaticlyExplode.add(this.mines.get(k));
                }
            }
        }
        return MinesThatWillAutomaticlyExplode;
    }
    public ArrayList<Mine> explodeMinesWithTime(int timeUntilExplosion){
        ArrayList<Mine> minesThatWillExplode = new ArrayList<Mine>();
        for(int k = 0; k < this.mines.size(); k++){
            if(this.mines.get(k).getTimeUntilExplosion() == timeUntilExplosion && timeUntilExplosion != 0){
                this.mines.get(k).setExploded(true);
                this.mines.get(k).setTimeUntilExplosion(-1);
                minesThatWillExplode.add(this.mines.get(k));
            }
        }  
        return minesThatWillExplode;
    }
}