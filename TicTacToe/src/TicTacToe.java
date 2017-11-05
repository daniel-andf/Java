
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class TicTacToe {
    private int[][] board = new int[3][3];;
    private final int EMPTY=-1;
    private final int X=1;
    private final int O=2;
    private Scanner scan = new Scanner(System.in);
           

    public TicTacToe() {
    
        for(int i=0; i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]= EMPTY;
    }
    
    public void startGame(){
        System.out.println("*** Welcome to Tic Tac Toe Game!!! ***");
        System.out.println("*** You should select a row and a column position for your move - Ex: 1 2, row=1, column=2 ***");
        int posx=0;
        int posy=0;
        
        
        do{
           do{
                System.out.println("***Player 1 (X) - Select a position : ***");
                posx = scan.nextInt();
                posy = scan.nextInt();
                
            }while((playerMove(X,posx,posy)== false));
           
          if ((checkForWin()==true) || (checkDrawGame()==true))
              System.exit(0);
              
           
           do{
                System.out.println("***Player 2 (O) - Select a position : ***");
                posx = scan.nextInt();
                posy = scan.nextInt();

           }while (playerMove(O,posx,posy)==false);
                       
                      
        }
        while((checkForWin()==false) && (checkDrawGame()==false));
        
        
        
        
    }
    
    public boolean checkForWin(){
        
        //Check for rows victory
        for(int i=0;i<3;i++){
            if ((board[i][0]== X) && (board[i][1]== X) && (board[i][2]== X)){
                System.out.print("Player 1 wins !!!");
                return true;
            }
            
            if ((board[i][0]== O) && (board[i][1]== O) && (board[i][2]== O)){
                System.out.print("Player 2 wins !!!");
                return true;
            }
        }
        
        //Check for columns victory
        for(int i=0;i<3;i++){
            if ((board[0][i]== X) && (board[1][i]== X) && (board[2][i]== X)) {
                System.out.print("Player 1 wins !!!");
                return true;
            }
            
            if ((board[0][i]== O) && (board[1][i]== O) && (board[2][i]== O)) {
                System.out.print("Player 2 wins !!!");
                return true;
            }
        }
        //Check for diagonal victory
        if ((board[0][0]== X) && (board[1][1]== X) && (board[2][2]== X))  {
                System.out.print("Player 1 wins !!!");
                return true;
        }
        
        if ((board[0][0]== O) && (board[1][1]== O) && (board[2][2]== O)) {
                System.out.print("Player 2 wins !!!");
                return true;
        }
        
        if ((board[2][0]== X) && (board[1][1]== X) && (board[0][2]== X)) {
                System.out.print("Player 1 wins !!!");
                return true;
        }
        
        if ((board[2][0]== O) && (board[1][1]== O) && (board[0][2]== O)) {
                System.out.print("Player 2 wins !!!");
                return true;
        }
        
        return false;
            
    }
    
    public boolean checkDrawGame(){
        boolean result = true;
        
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]== EMPTY)
                    result = false;
            }
                
        }
        
        if(result)
            System.out.println("Draw game!!!");
        
        return result;
    }

    public boolean playerMove(int player, int posx,int posy){
              
            if((posx>=0) && (posx<=2) && (posy>=0) && (posy<=2) ){
                if(board[posx][posy]==EMPTY){
                        
                    board[posx][posy] = player;
                    if (player == X)
                        System.out.println("Player 1 selected position ("+posx+","+posy+")");
                    else
                        System.out.println("Player 2 selected position ("+posx+","+posy+")");
                    return  true;
                }
                else{
                System.out.println("This position is already selected. Try another position!!!"); 
                    return false;

                }
            }
            else{
                System.out.println("Invalid position. Try again!!!"); 
                return false;
            }
            
    
    }
     

}
