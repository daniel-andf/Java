/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dandradefonsec00
 */
// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;

public class DeckOfCards
{
   private Card[] deck; // array of Card objects
   private int currentCard; // index of next Card to be dealt (0-51)
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   
   private String[] faces = { "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King","Ace"};
   private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
   
   Card[] deckP1 = new Card[5];
   Card[] deckP2 = new Card[5];

   // constructor fills deck of Cards
   public DeckOfCards()
   {
     
      deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
      currentCard = 0; // first Card dealt will be deck[0]

      // populate deck with Card objects
      for (int count = 0; count < deck.length; count++) 
         deck[count] = 
            new Card(faces[count % 13], suits[count / 13]);
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         // swap current Card with randomly selected Card
         Card temp = deck[first];        
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } 
   
   public String analyzeDeck(Card[] deckP){
       
       String[] deckString;
       String card;
       String[][] deckPlayer= new String[5][2];
       String[] straightFullHouse=new String [5];
       String temp;
       String returnAnalysis="";
     
       
       int face,pair;
       int kind=0;
       int faceCheck=0; //if the hand has a three or four of a kind, the code will not let to show a pair of the same face.
       
       
             
       for(int i=0;i<5;i++){
           card=deckP[i].toString();//convert the object Card into String
           deckString = card.split(" of ");// split the variable card to get the face and suit of the each card
           deckPlayer[i][0] = deckString[0];
           deckPlayer[i][1] = deckString[1];
           
           straightFullHouse[i] = deckString[0];
        }
       
       //sort the cards ascending to check if there is a straight
       for(int i=0; i<=4;i++)
           for(int j=0; j<=4;j++)
               for(int k=0; k<13; k++){
                    if(faces[k].equals(straightFullHouse[j])){
                        temp = straightFullHouse[i];
                        straightFullHouse[i] = straightFullHouse[j];
                        straightFullHouse[j] = temp;
                    
                    }
               
               }
       
        // check the following cards after sorting and check if there is a straight
        for(int k=0; k<13; k++)
            if(faces[k].equals(straightFullHouse[0]))
                    if((faces[k+1].equals(straightFullHouse[1])) && (faces[k+2].equals(straightFullHouse[2])) && (faces[k+3].equals(straightFullHouse[3])) && (faces[k+4].equals(straightFullHouse[4])))
                        //System.out.println("A Straight");
                        returnAnalysis = "A Straight";
         
        //check if there is a full house hand
        if (((straightFullHouse[0].equals(straightFullHouse[1])) && (straightFullHouse[2].equals(straightFullHouse[3])) && (straightFullHouse[2].equals(straightFullHouse[4])))
             || ((straightFullHouse[0].equals(straightFullHouse[1])) && (straightFullHouse[0].equals(straightFullHouse[2])) && (straightFullHouse[3].equals(straightFullHouse[4]))))   
                //System.out.println("A Full House");
                returnAnalysis = "A Full House";
        
        for(int i=0;i<4;i++){
           kind=pair=face=0;
                     
           for(int j=i+1;j<5;j++){
               if(deckPlayer[i][0].equals(deckPlayer[j][0])){
                   face++;
                   
                   if(face==1)
                       pair++;
                   else
                       pair=0;
               }
               
               if(deckPlayer[i][1].equals(deckPlayer[j][1]))
                   kind++;
           }
           
           if (face >= 2){
                returnAnalysis=(face+1) + " of "+deckPlayer[i][0];
                faceCheck=1;
           }
           else
                if (pair >= 1)
                    if(pair==1)
                        //System.out.println("A Pair of "+deckPlayer[i][0]);
                        if(returnAnalysis.equals(""))
                            returnAnalysis="A Pair of "+ deckPlayer[i][0];
                        else if(faceCheck==0)
                                returnAnalysis = "2 pairs";
                        else if(!returnAnalysis.contains(deckPlayer[i][0]))
                                 returnAnalysis = returnAnalysis +"\n"+ "A Pair of "+ deckPlayer[i][0];
           
           if (kind == 4)
                //System.out.println("A Flush of " + deckPlayer[i][1]);
               returnAnalysis = "A Flush of " + deckPlayer[i][1];

       }
        
        if(returnAnalysis=="")
            returnAnalysis="none";
        
        return returnAnalysis;
   }
   
   public void decideWinner(){
       
       String[] score = {"none","A Pair of","2 pairs","3 of","4 of","A Flush","A Straight","A Full House"};
       int p1=0;
       int p2=0;
       String resultP1="";
       String resultP2="";
      
      for (int i = 0; i < 5; i++)
      {
          deckP1[i]=this.dealCard();
          
      }
      
      for (int i = 0; i < 5; i++)
      {
          deckP2[i]=this.dealCard();
          
      }
      
      System.out.println("Left Hand:         Right Hand:");
      
      // print 5 cards
      for (int i = 0; i < 5; i++)
      {
         // deal and display a Card
         System.out.printf("%-18s %s",deckP1[i],deckP2[i]);
         System.out.println();
	
      } 
      
      System.out.println();
      
      resultP1 = this.analyzeDeck(deckP1);
      resultP2 = this.analyzeDeck(deckP2);
      
      System.out.println("Hand values: ");
      System.out.println("Left Hand values: ");
      System.out.println(resultP1);
      System.out.println();
      System.out.println("Right Hand values: ");
      System.out.println(resultP2);
      System.out.println();
      
      for(int i=0;i<score.length;i++){
          if(resultP1.contains(score[i])){
              p1=i;
          }
          //else if (resultP1.indexOf(score[i])==2)
      }
      
      
      for(int i=0;i<score.length;i++){
          if(resultP2.contains(score[i])){
              p2=i;
          }
          //else if (resultP1.indexOf(score[i])==2)
      }
      System.out.println();
      
      if (p1>p2)
          System.out.println("left hand is better");
      else if(p2>p1)
             System.out.println("right hand is better");
           else
             System.out.println("tied");  
   }
} // end class DeckOfCards

