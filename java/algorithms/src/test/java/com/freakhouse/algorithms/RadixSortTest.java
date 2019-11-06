package com.freakhouse.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author freakhouselabs
 */
public class RadixSortTest extends BaseTestCaseForIntegers{
    
    public RadixSortTest() {
        super();
    }
    
    @Test
    public void testExecuteTenPositions() {
        System.out.println("InsertionSort with ten positions...");        
        InsertionSort instance = new InsertionSort();
        Integer[] expected = this.TEN_POSITIONS_ARRAY.clone();
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        Integer[] result = instance.execute(this.TEN_POSITIONS_ARRAY);
        
        assertArrayEquals(expected, result);                
    }
    
    @Test
    public void testExecuteHundredPositions() {
        System.out.println("InsertionSort with Hundred positions...");        
        InsertionSort instance = new InsertionSort();
        Integer[] expected = this.HUNDRED_POSITIONS_ARRAY.clone();
        
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
                
        Integer[] result = instance.execute(this.HUNDRED_POSITIONS_ARRAY);
        
        assertArrayEquals(expected, result);                
    }
    
    @Test
    public void testExecuteThousandPositions() {
        System.out.println("InsertionSort with ONE THOUSAND positions...");        
        InsertionSort instance = new InsertionSort();
        Integer[] expected = this.THOUSAND_POSITIONS_ARRAY.clone();
        
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        Integer[] result = instance.execute(this.THOUSAND_POSITIONS_ARRAY);
        
        assertArrayEquals(expected, result);                
    }
}
