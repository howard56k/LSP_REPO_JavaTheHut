package org.howard.edu.lspfinal.question1;

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;


/**
 * Defines the Junit tests for my IntegerSet Implementation
 */
public class ShoppingCartTest {

	ShoppingCart shoppingCart1;
	ShoppingCart shoppingCart2;


    @BeforeEach
    void setUp() throws Exception {
    	shoppingCart1 = new ShoppingCart();
    	shoppingCart1.addItem("White Rice", 4.99);


        shoppingCart2 = new ShoppingCart();
    }
    
    @TestFactory
    @DisplayName("Test for adding valid items [3 pts.]")
    Iterable<DynamicTest> testAddingValidItem() {
    	shoppingCart2.addItem("Hot Dogs", 3.98);
    	shoppingCart2.addItem("Hot Dog Dubs", 5.00);
    	
        return Arrays.asList(
                DynamicTest.dynamicTest("Adding Multiple Items",
                        () -> assertEquals(shoppingCart2.getTotalCost(), 8.98)),
                DynamicTest.dynamicTest("Adding One Item",
                        () -> assertEquals(shoppingCart1.getTotalCost(), 4.99))
        );
    }
    
    @Test
    @DisplayName("Test for Removing item in cart (expect exception)")
    void testRemovingValidItem() throws IllegalArgumentException {
    	shoppingCart1.removeItem("White Rice");
    	
    	
    	// I modified the Source Code so that Removing Items is Implemented
        // Shopping Cart Should be empty and Total Cost 0
    	assertEquals(shoppingCart1.getTotalCost(), 0);
    }
    
    
    
    @Test
    @DisplayName("Test for Removing item not in cart (expect exception)")
    void testRemovingInvalidItem() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	shoppingCart2.removeItem("Hot Dogs");
        });
        String expectedMessage = "Item Does Not Exist in Cart.";
        String actualMessage = exception.getMessage();
    	
    	
    	// I modified the Source Code so that Removing Items is Implemented
        // Matches the Exception Message String
    	assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    @DisplayName("Test for adding item with 0 price (expect exception) [3 pts.]")
    void testAddingZeroPriceItem() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	shoppingCart2.addItem("Hot Dogs", 0);
        });
        String expectedMessage = "Price cannot be Zero.";
        String actualMessage = exception.getMessage();
    	
    	
    	// I modified the Source Code so it throws an error when price is Zero
        // Matches the Exception Message String
    	assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    @DisplayName("Test for adding item with negative price (expect exception) [3 pts.]")
    void testAddingNegativePriceItem() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	shoppingCart2.addItem("Hot Dogs", -1.98);
        });
        String expectedMessage = "Price cannot be negative.";
        String actualMessage = exception.getMessage();
    	
    	
    	// Matches the Exception Message String
    	assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    @DisplayName("Test for applying \"SAVE10\"[3 pts.]")
    void testAddingSaveTenDiscountCode() {
    	shoppingCart1.applyDiscountCode("SAVE10");
    	
    	double expectedTotalCost = 4.99 * .90;
    	
    	//Gets the Total Cost of the Cart With Discount Applied 
    	// and Checks it with the Value it should be from expectedTotalCost
    	assertEquals(shoppingCart1.getTotalCost(), expectedTotalCost);
    }
    
    @Test
    @DisplayName("Test for applying \"SAVE20\" [3 pts.]")
    void testAddingSaveTwentyDiscountCode() {
    	shoppingCart1.applyDiscountCode("SAVE20");
    	
    	double expectedTotalCost = 4.99 * .80;
    	
    	//Gets the Total Cost of the Cart With Discount Applied 
    	// and Checks it with the Value it should be from expectedTotalCost
    	// I got a weird error when comparring the values it would say false because the precision was
    	// too high and would say "org.opentest4j.AssertionFailedError: expected: <3.992> but was: <3.9920000000000004>
    	// so I used https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/
    	// To Round it to 3 decimal places
    	DecimalFormat df_obj = new DecimalFormat("#.###");

    	assertEquals(df_obj.format(shoppingCart1.getTotalCost()), df_obj.format(expectedTotalCost));
    }
    
    @Test
    @DisplayName("Test for applying invalid code (expect exception) [3 pts.]")
    void testAddingSaveInvalidDiscountCode() throws IllegalArgumentException {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	shoppingCart1.applyDiscountCode("SAVE100");
        });
        String expectedMessage = "Invalid discount code.";
        String actualMessage = exception.getMessage();
    	
    	
    	// Matches the Exception Message String
    	assertEquals(expectedMessage, actualMessage);
    }

    @TestFactory
    @DisplayName("Test total cost without discount [4 pts.]")
    Iterable<DynamicTest> testTotalCost() {
    	shoppingCart2.addItem("Chicken Breasts", 12.99);
    	shoppingCart2.addItem("Brown Rice", 5.00);
    	
    	// Same Issue As Described in testAddingSaveTwentyDiscountCode
    	DecimalFormat df_obj = new DecimalFormat("#.###");
    	
        return Arrays.asList(
                DynamicTest.dynamicTest("Multiple Items Total Cost",
                        () -> assertEquals(df_obj.format(shoppingCart2.getTotalCost()), df_obj.format(17.99))),
                DynamicTest.dynamicTest("One Item Total Cost",
                        () -> assertEquals(shoppingCart1.getTotalCost(), 4.99))
        );
    }
    @Test
    @DisplayName("Test total cost with discount [5 pts.]")
    void testTotalCostWithDiscount() {
    	shoppingCart2.addItem("Tooth Paste", 4.99);
    	shoppingCart2.addItem("Mouth Wash", 5.00);
    	
    	shoppingCart2.applyDiscountCode("SAVE10");
    	
    	double expectedTotalCost = 9.99 * .90;
    	
    	// Same Issue As Described in testAddingSaveTwentyDiscountCode
    	DecimalFormat df_obj = new DecimalFormat("#.###");
    	
    	//Gets the Total Cost of the Cart With Discount Applied 
    	// and Checks it with the Value it should be from expectedTotalCost
    	assertEquals(df_obj.format(shoppingCart2.getTotalCost()), df_obj.format(expectedTotalCost));
    }
	@Test
    @DisplayName("Test total cost with empty cart [3 pts.]")
    void testTotalCostWithEmptyCart() {    	
    	assertEquals(shoppingCart2.getTotalCost(), 0);
    }
    
    
    
}