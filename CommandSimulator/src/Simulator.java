
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
public class Simulator {
    
    private final int READ = 10;
    private final int WRITE = 11;
    
    private final int LOAD = 20;
    private final int STORE = 21;
    
    private final int ADD = 30;
    private final int SUBTRACT = 31;
    private final int DIVIDE = 32;
    private final int MULTIPLY = 33;
    
    private final int BRANCH = 40;
    private final int BRANCHNEG = 41;
    private final int BRANCHZERO = 42;
    private final int HALT = 43;
    
    private int memory[] = new int[100];
    
 
    private int instructionCounter = 0;
    private int instructionRegister = 0;
    private int accumulator = 0;
    private int operand = 0;
    private int operationCode = 0;
    
    Scanner scan = new Scanner(System.in);
    
    
    public Simulator(){
        Arrays.fill(memory, 0000);
        
        int input;
        int i=0;
               
        System.out.println("*** Welcome to Simpletron!***");
        System.out.println("*** Please enter your program one instruction ***");
        System.out.println("*** (or data word) at time. I will display  ***");
        System.out.println("*** the location number and a question mark (?)***");
        System.out.println("*** You then type the word for that location.  ***");
        System.out.println("*** Type -99999 to stop entering your program.    ***");
        
        do{
           input=scan.nextInt();
           
            System.out.printf("%02d ? ",i);
           
           if (input >= 0)
            System.out.printf("+%04d",input);
           else
            System.out.printf("%04d",input);   
           
           if(input!=-99999)
               memory[i]=input;
           
           System.out.println();
           
           if(input==-99999){
               System.out.println("*** Program loading completed ***");
               System.out.println("*** Program execution begins ***");
           }
           i++;
        }while (input!=-99999);
        
        readInstruction();
        dump();
    }
    
    public void readInstruction(){
        
        while(instructionCounter<memory.length){
            
            instructionRegister = memory[instructionCounter];
            
            if ((accumulator <=-9999)||(accumulator >=9999)){
                System.out.println("*** The accumulator must be in a range of -9999 <= operand <= 9999 ***"); 
                System.out.println("*** Simpletron execution abnormally terminated ***");
                System.exit(0);
            }
            
            if ((instructionRegister >=-9999)||(instructionRegister <=9999)){
                operationCode= instructionRegister/100;
                operand = instructionRegister%100;
                
               

                    switch(operationCode){
                    case READ:  read(operand); break;
                    case WRITE:  write(operand); break;
                    case LOAD:  load(operand); break;
                    case STORE:  store(operand); break;
                    case ADD:   add(operand); break;
                    case SUBTRACT:   subtract(operand); break;
                    case DIVIDE:   divide(operand); break;
                    case MULTIPLY:   multiply(operand); break;
                    case BRANCH:   branch(operand); break;
                    case BRANCHNEG:   branchneg(operand); break;
                    case BRANCHZERO:  branchzero(operand); break;
                    case HALT:  System.out.println("*** Simpletron execution terminated ***");return;

                    default: System.out.println("*** Invalid operationCode. ***"); System.out.println("*** Simpletron execution abnormally terminated ***"); System.exit(0);
                }
                instructionCounter++;
            }
            else {
                if(instructionRegister!=-99999){
                System.out.println("*** The operation code must be in a range of -9999 <= operand <= 9999 ***"); 
                System.out.println("*** Simpletron execution abnormally terminated ***");
                System.exit(0);
            
                }
            }
        }
        
    }
    
    public void read(int operand){
        
               
        System.out.println("Enter an integer : ");
        int input =scan.nextInt();
        
        memory[operand]= input;

            
    }
    public void write (int operand){
    
        System.out.println(memory[operand]);
    }
    
    public void load (int operand){
        accumulator =memory[operand];
        
    }
    
    public void store (int operand){
    
        memory[operand]=accumulator;
    }
    
    public void add (int operand){
        accumulator +=memory[operand];
    
    }
    
    public void subtract (int operand){
        accumulator -=memory[operand];
    
    }
    public void divide (int operand){
        if (memory[operand]!=0)
            accumulator /=memory[operand];
        else{
            System.out.println("*** Attempt to divide by zero ***"); 
            System.out.println("*** Simpletron execution abnormally terminated ***"); 
            System.exit(0);
        }
    }
    public void multiply (int operand){
        accumulator *=memory[operand];
    
    }
    public void branch (int operand){
        instructionCounter=operand-1;
    
    }
    public void branchneg (int operand){
        if(accumulator<0)
            instructionCounter = operand-1;
    }    
    public void branchzero (int operand){
        if(accumulator == 0)
            instructionCounter = operand-1;
    }  
    
    public void dump(){
    
        System.out.println();
        System.out.println("REGISTERS:");
        System.out.printf("%s%10d","accumulator",accumulator);
        System.out.println();
        System.out.printf("%s%10d","instructionCounter",instructionCounter+1);
        System.out.println();
        System.out.printf("%s%10d","instructionRegister",instructionRegister);
        System.out.println();
        System.out.printf("%s%10d","operationCode",operationCode);
        System.out.println();
        System.out.printf("%s%10d","operand",operand);
        System.out.println(); 
        System.out.println("MEMORY:");
        System.out.println("       0     1     2     3     4     5     6     7     8     9");
        System.out.println(); 
        
        for(int i=0;i<10;i++){
        
            System.out.printf("%02d",i);
            
            for(int j=0;j<10;j++){
                if(memory[(10*i)+j]>=0)
                    System.out.printf(" %+05d",memory[(10*i)+j]);
                else
                    System.out.printf(" %05d",memory[(10*i)+j]);
            }
            System.out.println();
        }
    }
}
