//debug to make sure system prints out o


//make a function for the other way diagonal, top left to bottom right, needs to be implemented in both places
//check for future wins: two in a row with empty on either side.
//check or three with a missing one, be able to prevent
//make functions operate with two in a row, to help predict in the future wins or losses
//add all new ints to nextMove function
public class Computer {

    int threeUp(String player,Board b) {
        //this function can prevent losses or create wins from three in a row vertically
        int a=10;
        for (int w=0;w<=7;w++) {
            for (int h=0;h<=5;h++) {
                if (b.grid[h][w].equals(player)){
                    if (b.grid[h+1][w].equals(player)){
                        if (b.grid[h+2][w].equals(player)){
                            if(b.grid[h+3][w].equals(" .")){
                                a=w;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    int threeRight(String player, Board b){
        //this function can prevent losses or create wins from three in a row horizontally
        int a=10;
        for (int h=0;h<=7;h++) {
            for (int w=0;w<=5;w++) {
                if (b.grid[h][w].equals(player)){
                    if (b.grid[h][w+1].equals(player)){
                        if (b.grid[h][w+2].equals(player)){
                            if(w<5 && h==0 && b.grid[h][w+3].equals(" .")){
                                a=w+3;
                                break;
                            }if(h>0 && w<5 && b.grid[h-1][w+3]!=" ."){
                                if(b.grid[h][w+3].equals(" .")){
                                    a=w+3;
                                    break;
                                }
                            }if(h==0 && w>=2 && b.grid[h][w-1].equals(" .")){
                                a=w-1;
                                break;
                            }if(h>0 && w>0 && b.grid[h-1][w-1]!=" ."){
                                if(b.grid[h][w-1].equals(" .")){
                                    a=w+3;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    int threeDiagonal(String player, Board b){
        //this checks for possible diagonals (bottom left-top right)
        //it can prevent a loss from three in a row or create a win, it only works if there are three in a row
        int a=10;
        for(int w=0;w<=6;w++){
            for (int h=0;h<=6;h++){
                if(b.grid[h][w].equals(player)){
                    if(b.grid[h+1][w+1].equals(player)){
                        if(h<6 && w<6 && b.grid[h+2][w+2].equals(player)){
                            if(w<5 && h<5 && b.grid[h+3][w+3].equals(" .")) {
                                if (b.grid[h + 2][w + 3].equals(" o") || b.grid[h + 2][w + 3].equals(" x")) {
                                    a = w + 3;
                                    break;
                                }
                            }if(h>=1 && w>=1 && b.grid[h-1][w-1].equals(" .")){
                                if(h>=2 && b.grid[h-2][w-1]!=(" .")){
                                    a=w-1;
                                    break;
                                }if(h==2){
                                    a=w-1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int w=0;w<=6;w++){
            for (int h=7;h>0;h--){
                if(b.grid[h][w].equals(player)){
                    if(b.grid[h-1][w+1].equals(player)){
                        if(h>1 && w<6 && b.grid[h-2][w+2].equals(player)){
                            if(h>3 && w<5 && b.grid[h-3][w+3].equals(" .")) {
                                if (b.grid[h-4][w + 3].equals(" o") || b.grid[h - 4][w + 3].equals(" x")) {
                                    a = w + 3;
                                    break;
                                }
                            }if(w<=6 && h>=1 && b.grid[h-1][w+1].equals(" .")){
                                if(h>=5 && b.grid[h-2][w+1]!=(" .")){
                                    a=w-1;
                                    break;
                                }
                            }if(h==3){
                                a = w + 3;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return a;
    }

    int twoRight(String player, Board b){
        int a=10;
        for (int h=0;h<=7;h++) {
            for (int w=1;w<=5;w++) {
                if (b.grid[h][w].equals(player)){
                    if (b.grid[h][w+1].equals(player)){
                        if (b.grid[h][w-1].equals(" .")&&b.grid[h][w+2].equals(" .")){
                            a=w-1;
                            break;
                        }
                    }
                }
            }
        }
        return a;
    }

    int skipRight(String player, Board b){
        //this function can prevent losses or create wins from three in a row horizontally with one missing in the middle
        int a=10;
        for (int h=0;h<=7;h++) {
            for (int w=0;w<=5;w++) {
                if (b.grid[h][w].equals(player)){
                    if (b.grid[h][w+2].equals(player)){
                        if (w<5 && b.grid[h][w+3].equals(player)){
                            if(h>0 && b.grid[h-1][w+1]!=" ." && b.grid[h][w+1].equals(" .")){
                                a=w+1;
                                break;
                            }if(h==0 && b.grid[h][w+1].equals(player)){
                                a=w+1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int h=0;h<=7;h++) {
            for (int w=0;w<=5;w++) {
                if (b.grid[h][w].equals(player)){
                    if (b.grid[h][w+1].equals(player)){
                        if (w<5 && b.grid[h][w+3].equals(player)){
                            if(h>0 && b.grid[h-1][w+2]!=" ." && b.grid[h][w+2].equals(" .")){
                                a=w+2;
                                break;
                            }if(h==0 && b.grid[h][w+2].equals(" .")){
                                a=w+2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    int nextMove(Board b){
     //each function will only run if a previous move has not been found
        int move=11;
     //these find imminent wins and make them happen
        if(threeUp(" o", b)!=10){
            move=threeUp(" o",b);
        }if(move==11 && threeRight(" o",b)!=10){
            move=threeRight(" o",b);
        }if(move==11 && threeDiagonal(" o",b)!=10){
            move=threeDiagonal(" o",b);
        }
     //finds imminent losses and makes them happen
        if(move==11 && threeUp(" x",b)!=10){
            move=threeUp(" x",b);
        }if(move==11 && threeRight(" x",b)!=10){
            move=threeRight(" x",b);
        }if(move==11 && threeDiagonal(" x",b)!=10){
            move=threeDiagonal(" x",b);
        }
     //prevents possible trap from happening in the future
        if(move==11 && twoRight(" x",b)!=10){
            move=twoRight(" x",b);
        }
        if(move==11 && skipRight(" x",b)!=10){
            move=skipRight(" x",b);
        }
     //predicts possible future wins and sets up for possible win next turn
        if(move==11 && twoRight(" o",b)!=10){
            move=twoRight("o",b);
        }
        if(move==11 && skipRight(" o",b)!=10){
            move=twoRight("o",b);
        }

        if(move>7){
            for(int i=0; i<8;i++){
                if(b.grid[7][i]==" ."){
                    move=i;
                    break;
                }
            }
        }
        return move;
    }
}
