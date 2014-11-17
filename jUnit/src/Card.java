import java.util.Random;

/**
 * <strong>Card.java</strong> - Card class used to build card games
 *
 * @author Peter K. Johnson - <a href="http://WebExplorations.com"
 *         target="_blank"> http://WebExplorations.com</a><br >
 *         Written: Nov 10, 2014<br >
 *         Revised: Nov 10, 2014<br>
 */

public class Card
{
   static final int NUMBER_OF_CARDS = 5;
   String[ ] deck = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
   String[ ] suit = {"Spades", "Clubs", "hearts", "diamonds"};
   //String[ ] thisHand = new String[cardCount];
   
   public String[ ] dealHand(int cardCount)
   {      
	   String [] handArray = new String[cardCount];
	   int cardIndex = 0;
	   int suitIndex = 0;
	   
	   for (int count=0; count<cardCount; count++) {
		   cardIndex = getRandomCard();
		   suitIndex = getRandomSuit();
		   // Save the card and dsuit in the array
		   handArray[count] = deck[cardIndex] + " " + suit[suitIndex];
	   }
	   displayHand(handArray);
       return handArray;  
   }
   
   
   public int getRandomCard( )
   {
	   Random random = new Random();
	   int cardIndex;
	   // Create a pseudo-random number between 0-12. 
       cardIndex = random.nextInt(13);
       System.out.println("Random card index: " + cardIndex);
       return cardIndex;
   } // end of getRandomCard( )

   
   public int getRandomSuit( )
   {
	   Random random = new Random();
	   int suitIndex;
	   suitIndex = random.nextInt(4);
	   System.out.println("Random suit index: " + suitIndex);
      return suitIndex;
   }
   
   
   public void displayHand(String[ ] hand )
   {
      System.out.println("This is the hand that was dealt.");
      //for(int x=0;x<thisHand.length;x++) {
    	//  System.out.println(thisHand[x] + "  ");
      //}
      System.out.println();
   } //End of displayHand
   
 } // end of Card
