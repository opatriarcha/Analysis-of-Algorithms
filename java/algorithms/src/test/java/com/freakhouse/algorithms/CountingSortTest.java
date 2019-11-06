package com.freakhouse.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author freakhouselabs
 */
public class CountingSortTest extends BaseTestCaseForIntegers{
    
    public CountingSortTest() {
    }

     /**
     * Test of execute method, of class InsertionSort.
     */
    @Test
    public void testExecuteTenPositions() {
        System.out.println("InsertionSort with ten positions...");        
        CountingSort instance = new CountingSort();
        //Integer[] expected = this.TEN_POSITIONS_ARRAY.clone();
        Integer[] expected = new Integer[]{1,3,5,7,6,4,2,9,0,8};
        Integer[] entrada = new Integer[]{1,3,5,7,6,4,2,9,0,8};
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        //Integer[] result = new Integer[this.TEN_POSITIONS_ARRAY.length];
        //instance.sort(this.TEN_POSITIONS_ARRAY, result, this.TEN_POSITIONS_ARRAY.length, result.length);
        Integer[] result = new Integer[this.TEN_POSITIONS_ARRAY.length];
        instance.sort(entrada, result, entrada.length, result.length);
        
        assertArrayEquals(expected, result);                
    }
    
    
}
