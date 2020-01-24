import java.util.Scanner;
public class Game{

    public static void main(String[]args){
        Board b=new Board();
        Computer c=new Computer();
        Scanner sc = new Scanner(System.in);
        System.out.println("To play choose a column:0-7");
        System.out.println("Player x's Turn");
        b.PrintBoard();
        while(b.game==true){
            if(b.game==true){
                int colX=sc.nextInt();
                b.dropX(colX);
                b.PrintBoard();
                if (b.catsGame()==true){
                    System.out.println("Cats Game!");
                }if (b.game==true&&b.catsGame()!=true){
                    System.out.println("Computer's Turn");
                }if (b.game==false&&b.catsGame()==false){
                    System.out.println("Yay player x has won!");
                }
            }
            if (b.game==true){
                int colO=c.nextMove(b);
                b.dropO(colO);
                b.PrintBoard();
                if (b.catsGame()==true){
                    System.out.println("Cats Game!");
                }if (b.game==true&&b.catsGame()!=true){
                    System.out.println("Player x's Turn");
                }if (b.game==false&&b.catsGame()==false){
                    System.out.println("Yay the computer has won!");
                }
            }
        }
    }
}
