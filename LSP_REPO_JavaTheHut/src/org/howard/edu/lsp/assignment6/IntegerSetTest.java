package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;




/**
 * Defines the Junit tests for my IntegerSet Implementation
 */
public class IntegerSetTest {

    IntegerSet set1;
    IntegerSet set2;
    IntegerSet set3;
    IntegerSet set4;

    @BeforeEach
    void setUp() throws Exception {
        set1 = new IntegerSet();
        set1.add(1);
        set1.add(4);
        set1.add(3);
        set1.add(7);

        set2 = new IntegerSet();
        set2.add(10);
        set2.add(6);
        set2.add(44);
        set2.add(7);
        
        set3 = new IntegerSet();
        set3.add(7);
        
        set4 = new IntegerSet();
    }
    
    @Test
    @DisplayName("Test Cases for Clear")
    void testClear() {
    	set3.clear();
    	//Compares the set3 to set4 that is already empty
    	assertEquals(set4, set3);
    }
    
    @TestFactory
    @DisplayName("Test Cases for Length")
    Iterable<DynamicTest> testLength() {
        return Arrays.asList(
                DynamicTest.dynamicTest("4 Item in Set Length Test",
                        () -> assertEquals(4, set1.length())),
                DynamicTest.dynamicTest("1 Item in Set Length test",
                        () -> assertEquals(1, set3.length())),
                DynamicTest.dynamicTest("Empty Set Length test",
                        () -> assertEquals(0, set4.length()))
        );
    }
    
    @TestFactory
	@DisplayName("Test Cases for Equals")
	Iterable<DynamicTest> testEquals() {
		return Arrays.asList(
				DynamicTest.dynamicTest("True Equal test",
		        () -> assertEquals(true, set2.equals(set2))),
				DynamicTest.dynamicTest("False Equal Test",
		        () -> assertEquals(false, set3.equals(set4))));
	}
    
    @TestFactory
	@DisplayName("Test Cases for Contains") 
	Iterable<DynamicTest> testContains() {
		return Arrays.asList(
				DynamicTest.dynamicTest("True Contains Test",
		        () -> assertEquals(true, set2.contains(6))),
				DynamicTest.dynamicTest("False Contains Test",
		        () -> assertEquals(false, set3.contains(11))));
	}
    
    @TestFactory
    @DisplayName("Test Cases for Largest")
    Iterable<DynamicTest> testLargest() throws IntegerSetException {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
        	set4.smallest();
        });
        String expectedMessage = "IntegerSet is empty";
        String actualMessage = exception.getMessage();

        return Arrays.asList(
                        DynamicTest.dynamicTest("4 Item in Set Largest test",
                                () -> assertEquals(44, set2.largest())),
                        DynamicTest.dynamicTest("1 Item in Set Largest test",
                                () -> assertEquals(7, set3.largest())),
                        DynamicTest.dynamicTest("Empty Set Largest Test",
                                () -> assertTrue(actualMessage.contains(expectedMessage)))
        );
    }

    @TestFactory
    @DisplayName("Test Cases for Smallest")
    Iterable<DynamicTest> testSmallest() throws IntegerSetException {
        Exception exception = assertThrows(IntegerSetException.class, () -> {
        	set4.smallest();
        });
        String expectedMessage = "IntegerSet is empty";
        String actualMessage = exception.getMessage();

        return Arrays.asList(
                        DynamicTest.dynamicTest("4 Item in Set Smallest test",
                                () -> assertEquals(1, set1.smallest())),
                        DynamicTest.dynamicTest("1 Item in Set Smallest test",
                                () -> assertEquals(7, set3.smallest())),
                        DynamicTest.dynamicTest("Empty Set Smallest Test",
                                () -> assertTrue(actualMessage.contains(expectedMessage)))
        );
    }
    
    @TestFactory
    @DisplayName("Test Cases for Add")
    Iterable<DynamicTest> testAdd(){
    	set2.add(90);
    	set3.add(12);
    	set4.add(8);
    	
        return Arrays.asList(
        		DynamicTest.dynamicTest("4 Item in Set add test",
                                () -> assertEquals(true, set2.contains(90))),
        		DynamicTest.dynamicTest("1 Item in Set add test",
                                () -> assertEquals(true, set3.contains(12))),
                        DynamicTest.dynamicTest("Empty Set add Test",
                                () -> assertEquals(true, set4.contains(8)))
                
        );
    }
    
    @TestFactory
    @DisplayName("Test Cases for Remove")
    Iterable<DynamicTest> testRemove(){
    	set2.remove(1);
    	set3.remove(7);
    	set4.remove(7);
    	
        return Arrays.asList(
        		DynamicTest.dynamicTest("4 Item in Set Remove test",
                                () -> assertEquals(false, set2.contains(1))),
        		DynamicTest.dynamicTest("1 Item in Set Remove test",
                                () -> assertEquals(false, set3.contains(7))),
                        DynamicTest.dynamicTest("Empty Set Remove Test",
                                () -> assertEquals(false, set4.contains(7)))
                
        );
    }
    
    @TestFactory                                               
    @DisplayName("Test Case for Union")   
    Iterable<DynamicTest> testUnion() {
    	IntegerSet tempSet = new IntegerSet();
    	tempSet.add(1);
    	tempSet.add(4);
    	tempSet.add(3);
    	tempSet.add(7);
        tempSet.add(10);
        tempSet.add(6);
        tempSet.add(44);
        
        set1.union(set2);
		
		set4.union(set3);
		return Arrays.asList(
        		DynamicTest.dynamicTest("4 Item in Set Union test",
                        () -> assertEquals(true, set1.equals(tempSet))),
                DynamicTest.dynamicTest("Empty Set Union Test",
                        () -> assertEquals(true, set4.equals(set3)))
                
        );
    }
    
    @TestFactory                                               
    @DisplayName("Test Case for Intersect")   
    Iterable<DynamicTest> testIntersect() {
    	IntegerSet tempSet = new IntegerSet();
    	tempSet.add(7);
        
        set1.intersect(set2);
		
        set3.intersect(set4);
		return Arrays.asList(
        		DynamicTest.dynamicTest("4 Item in Set Intersect test",
                                () -> assertEquals(true, set1.equals(tempSet))),
                        DynamicTest.dynamicTest("Empty Set Intersect Test",
                        () -> assertEquals(true, set4.equals(set3)))
                
        );
    }
    
    @TestFactory                                               
    @DisplayName("Test Case for Diff")   
    Iterable<DynamicTest> testDiff() {
    	IntegerSet tempSet = new IntegerSet();
    	tempSet.add(1);
    	tempSet.add(4);
    	tempSet.add(3);
        
        set1.diff(set2);
		
        set3.diff(set4);
		return Arrays.asList(
        		DynamicTest.dynamicTest("4 Item in Set Diff test",
                        () -> assertEquals(true, set1.equals(tempSet))),
                DynamicTest.dynamicTest("Empty Set Diff Test",
                        () -> assertEquals(false, set3.equals(set4)))
                
        );
    }
    @TestFactory                                               
    @DisplayName("Test Case for Complement")   
    Iterable<DynamicTest> testComplement() {
    	IntegerSet tempSet = new IntegerSet();
    	tempSet.add(10);
    	tempSet.add(6);
    	tempSet.add(44);
        
        set1.complement(set2);
		
        set3.complement(set4);
		return Arrays.asList(
        		DynamicTest.dynamicTest("4 Item in Set Complement test",
                        () -> assertEquals(true, set1.equals(tempSet))),
                DynamicTest.dynamicTest("Empty Set Complement Test",
                        () -> assertEquals(true, set3.equals(set4)))
                
        );
    }
    
    @TestFactory
	@DisplayName("Test Cases for Empty")  
	Iterable<DynamicTest> testEmpty() throws IntegerSetException {
		return Arrays.asList(
				DynamicTest.dynamicTest("True Empty test",
                        () -> assertEquals(true, set4.isEmpty())),
                DynamicTest.dynamicTest("False Empty test",
                        () -> assertEquals(false, set1.isEmpty()))
                
		);
	}
    
    
    @TestFactory
	@DisplayName("Test Cases for toString") 
	Iterable<DynamicTest> testToString() {
    	List<Integer> tempList = new ArrayList<Integer>();
    	tempList.add(7);
    	
    	List<Integer> emptyList = new ArrayList<Integer>();
    	
		return Arrays.asList(
				DynamicTest.dynamicTest("Empty ToString test",
		        () -> assertEquals(set4.toString(), emptyList.toString())),
				DynamicTest.dynamicTest("Filled Set ToString Test",
		        () -> assertEquals(set3.toString(), tempList.toString())));
	}
}