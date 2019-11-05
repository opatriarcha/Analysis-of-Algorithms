package com.freakhouse.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author freakhouselabs
 */
public class MergeSortTest extends BaseTestCaseForIntegers{
    
    public MergeSortTest() {
        super();
    }
    

    /**
     * Test of execute method, of class InsertionSort.
     */
    @Test
    public void testExecuteTenPositions() {
        System.out.println("InsertionSort with ten positions...");        
        MergeSort instance = new MergeSort();
        Integer[] expected = this.TEN_POSITIONS_ARRAY.clone();
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        instance.mergeSort(this.TEN_POSITIONS_ARRAY);
        
        assertArrayEquals(expected, TEN_POSITIONS_ARRAY);                
    }
    
    @Test
    public void testExecuteHundredPositions() {
        System.out.println("InsertionSort with Hundred positions...");        
        MergeSort instance = new MergeSort();
        Integer[] expected = this.HUNDRED_POSITIONS_ARRAY.clone();
        
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
                
        instance.mergeSort(this.HUNDRED_POSITIONS_ARRAY);
        
        assertArrayEquals(expected, HUNDRED_POSITIONS_ARRAY);                
    }
    
    @Test
    public void testExecuteThousandPositions() {
        System.out.println("InsertionSort with ONE THOUSAND positions...");        
        MergeSort instance = new MergeSort();
        Integer[] expected = this.THOUSAND_POSITIONS_ARRAY.clone();
        
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        instance.mergeSort(this.THOUSAND_POSITIONS_ARRAY);
        
        assertArrayEquals(expected, THOUSAND_POSITIONS_ARRAY);                
    }
    
}
