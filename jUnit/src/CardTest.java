import static org.junit.Assert.*;

import org.junit.Test;


public class CardTest {

	Card testCard = new Card();
	
	@Test
	public void testGetRandomCardReturnRange() {
		int returnValue;
		returnValue = testCard.getRandomCard();
		assertTrue(returnValue > -1 && returnValue < 13);
	}
	
	/* 
	 * Test to make sure that the random int we get is between
	 * the allowed range of 0 and 12.
	 */
	@Test
	public void testGetRandomSuitReturnRange() {
		int returnValue;
		returnValue = testCard.getRandomSuit();
		assertTrue(returnValue > -1 && returnValue < 4);
	}
	
	@Test
	/* Test to make sure that getRandomCard doesn't return a null.
	 * 
	 */
	public void testGetRandomCard() {
		assertNotNull ("getRandomCard() returned an object", testCard.getRandomCard());
	}
	
	@Test
	/* Test to make sure that getRandomCard doesn't return a null.
	 * 
	 */
	public void testGetRandomSuit() {
		assertNotNull ("getRandomCard() returned an object", testCard.getRandomSuit());
	}
	
	@Test
	public void testDealHandArrayLengthInvalid () {
		String[] testArray = testCard.dealHand(4);
		assertNotEquals("Array is wrong length",5,testArray.length);
	}
	
	@Test
	public void testDealHandArrayLengthValid() {
		String[] testArray = testCard.dealHand(4);
		assertEquals("Array is wrong length",5,testArray.length);
	}

} // end of CardTest()
