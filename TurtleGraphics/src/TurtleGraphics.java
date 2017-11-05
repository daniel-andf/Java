/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
import java.util.Scanner;
import java.util.Arrays;

public class TurtleGraphics {
    public static void main (String args[]){
        
        Scanner scan = new Scanner(System.in);
        int turtlePosition [][] = new int [20][20];
        int x = 0; //x-axis - move horizontally
        int y = 0;//y-axis - move vertically
        int moveTurtle = 0;// number of spaces to be moved
        int option =0;// input option
        int lastOption = 0;// to get the last option typed before option 5 or 6 was selected
         
        for(int i =0;i<20;i++) // fill all elements with 0
            for(int j =0;j<20;j++)
                    turtlePosition [i][j] = 0;
        
        turtlePosition [0][0] = 1;// start position (0,0) = 1
        
        while(option != 9){
            
            System.out.println("Enter a number to move the turtle");
            System.out.println("Pen up : 1");
            System.out.println("Pen down : 2");
            System.out.println("Turn right : 3");
            System.out.println("Turn left : 4");
            System.out.println("Move forward :5");
            System.out.println("Display the 20-by-20 array : 6");
            System.out.println("End of data : 9");
            System.out.println("Enter command (9 to end input): ");
            
            option = scan.nextInt();
       
            if ((option==1) || (option==2) || (option==3) || (option==4) || (option==5) || (option==6) || (option==9)){
                if ((option == 5)&&((lastOption != 0)&&(lastOption != 6))){// This command is to allow the turtle to move only when the option 5 is selected.
                    System.out.println("Enter forward spaces: ");          //To know which direction to move, the program is considering the lastOption variable
                    moveTurtle = scan.nextInt();

                    if (lastOption == 1){// move up


                        for (int i= y - 1; i>= y - moveTurtle ;i--){
                            if (i >= 0)
                                 turtlePosition [i][x] = 1;
                            else
                                break;//Stop the for loop if the number is < 0
                        }

                        if(y - moveTurtle >= 0)//store the last y position
                             y = y - moveTurtle;
                        else
                            y=0;
                    }

                    if (lastOption == 2){// move down

                        for (int i= y + 1; i<= y + moveTurtle ;i++){
                            if (i < 20)
                                turtlePosition [i][x] = 1;
                            else
                                break;//Stop the for loop if the number is > 19
                        }
                        if(y + moveTurtle < 20)//store the last y position
                            y = y + moveTurtle;
                        else
                            y=19;

                    }

                    if (lastOption == 3){//move right

                        for (int i= x + 1; i<=x + moveTurtle ;i++){
                            if (i < 20)
                                turtlePosition [y][i] = 1;
                            else
                                break; //Stop the for loop if the number is > 19
                        }
                        if (x + moveTurtle< 20)//store the last x position
                            x = x + moveTurtle;
                        else
                            x=19;

                    }

                    if (lastOption == 4){//move left

                        for (int i= x - 1; i>= x - moveTurtle ;i--){
                            if (i >= 0)
                               turtlePosition [y][i] = 1;
                            else
                                break;//Stop the for loop if the number is < 0
                        }
                        if (x - moveTurtle >= 0)//store the last x position
                            x = x - moveTurtle;
                        else
                            x=0;


                    }


                }

                if ((option == 6) && (lastOption !=0)){// print on the screen according with the value on each element. If the value = '1', print '*'. If the value = 0, print ' ' 
                       System.out.println("The drawing is: ");
                       System.out.println();
                       for (int i=0;i<20;i++){
                           for(int j=0; j<20; j++){
                               if(turtlePosition[i][j] == 1)
                                   System.out.print("*");
                               else
                                   System.out.print(" ");
                           }
                           System.out.println();
                       }
                 }

                if((option !=5) && (option !=6))
                    lastOption = option;
                else
                    if(lastOption == 0)
                        System.out.println( "Try another option!!!");
                
                System.out.println();   
               }
            
            else{
                System.out.println( "Try another option!!!");
                System.out.println();
            }
            
        }
       
  
        
          
    }
    
}
