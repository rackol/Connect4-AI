import java.util.Scanner;

public class Board {
    int width=8;
    int height=8;
    String[][]grid=new String[width][height];
    boolean game=true;
    Scanner sc = new Scanner(System.in);

    public Board(){
        for(int w=0;w<width;w++){
            for(int h=0;h<height;h++){
                grid[h][w]=" .";
            }
        }
    }

    void PrintBoard(){
        for(int w=7;w>=0;w--){
            for(int h=0;h<=7;h++){
                System.out.print(grid[w][h]);
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean catsGame(){
        boolean a=false;
        int counter=0;
        for (int h=0;h<=7;h++) {
            for (int w = 0; w <= 7; w++) {
                if(grid[w][h].equals(" x")||grid[w][h].equals(" o")){
                    counter++;
                }
            }
        }
        if(counter==64){
            a=true;
        }
        return a;
    }

    boolean upDown(String player) {
        boolean a=false;
        for (int w=0;w<=7;w++) {
            for (int h=0;h<=4;h++) {
                if (grid[h][w].equals(player)){
                    if (grid[h+1][w].equals(player)){
                        if (grid[h+2][w].equals(player)){
                            if (grid[h+3][w].equals(player)){
                                a=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    boolean rightleft(String player) {
        boolean a=false;
        for (int h=0;h<=7;h++) {
            for (int w=0;w<=4;w++) {
                if (w<6 && grid[h][w].equals(player)){
                    if (grid[h][w+1].equals(player)){
                        if (grid[h][w+2].equals(player)){
                            if (grid[h][w+3].equals(player)){
                                a=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    boolean diagonal(String player){
        boolean a=false;
        for(int w=0;w<=4;w++){
            for (int h=0;h<=4;h++){
                if(h>=5){
                    break;
                }if(w<6 && h<6 && grid[h][w].equals(player)){
                    if(grid[h+1][w+1].equals(player)){
                        if(grid[h+2][w+2].equals(player)){
                            if(grid[h+3][w+3].equals(player)){
                                a=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int w=0;w<=4;w++){
            for (int h=7;h>0;h--){
                if(h<3){
                    break;
                }if(w<6 && h>2 && grid[h][w].equals(player)){
                    if(grid[h-1][w+1].equals(player)){
                        if(grid[h-2][w+2].equals(player)){
                            if(grid[h-3][w+3].equals(player)){
                                a=true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return a;
    }

    void dropO(int col){
        int bottomrow=0;
        for (int i=0;i<height;i++){
            if (bottomrow>7||col>7){
                break;
            }if (grid[bottomrow][col]==" ."){
                grid[bottomrow][col]=" o";
                break;
            }else if(grid[bottomrow][col] == " o" || grid[bottomrow][col] == " x"){
                bottomrow++;
            }
        }
        if (upDown(" o") == true || rightleft(" o") == true || diagonal(" o") == true) {
            game = false;
        }
        if (catsGame()==true){
            game=false;
        }
    }

    void dropX(int col) {
        int bottomrow=0;
        if (col>width){
            System.out.println("That is not a valid column");
            int colX=sc.nextInt();
            dropX(colX);
        }else if (grid[7][col]!=" ."){
            System.out.println("That column is full, please choose another one");
            int colX = sc.nextInt();
            dropX(colX);
        }else{
            for (int i = 0; i < height; i++) {
                if (grid[bottomrow][col]==" ."){
                    grid[bottomrow][col]=" x";
                    break;
                } else if (grid[bottomrow][col]==" o"||grid[bottomrow][col]==" x") {
                    bottomrow++;
                }
            }
            if (upDown(" x") == true || rightleft(" x") == true || diagonal(" x") == true) {
                game = false;
            }
            if (catsGame()==true){
                game=false;
            }
        }
    }
}
//choose column
//drop:
//is column full?
//next on top
//connect 4?
//next turn