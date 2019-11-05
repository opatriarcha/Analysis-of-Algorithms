package com.freakhouse.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author freakhouselabs
 */
public class MergeSortPassingParamNTest extends BaseTestCaseForIntegers{
    
    public MergeSortPassingParamNTest() {
        super();
    }
    

    /**
     * Test of execute method, of class InsertionSort.
     */
    @Test
    public void testExecuteTenPositions() {
        System.out.println("InsertionSort with ten positions...");        
        MergeSortPassingParamN instance = new MergeSortPassingParamN();
        Integer[] expected = this.TEN_POSITIONS_ARRAY.clone();
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        instance.mergeSort(this.TEN_POSITIONS_ARRAY, TEN_POSITIONS_ARRAY.length);
        
        assertArrayEquals(expected, TEN_POSITIONS_ARRAY);                
    }
    
    @Test
    public void testExecuteHundredPositions() {
        System.out.println("InsertionSort with Hundred positions...");        
        MergeSortPassingParamN instance = new MergeSortPassingParamN();
        Integer[] expected = this.HUNDRED_POSITIONS_ARRAY.clone();
        
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
                
        instance.mergeSort(this.HUNDRED_POSITIONS_ARRAY, this.HUNDRED_POSITIONS_ARRAY.length);
        
        assertArrayEquals(expected, HUNDRED_POSITIONS_ARRAY);                
    }
    
    @Test
    public void testExecuteThousandPositions() {
        System.out.println("InsertionSort with ONE THOUSAND positions...");        
        MergeSortPassingParamN instance = new MergeSortPassingParamN();
        Integer[] expected = this.THOUSAND_POSITIONS_ARRAY.clone();
        
        this.printArray("Original array: ", expected);
        this.sortArray(expected);
        this.printArray("Sorted array: ", expected);
        
        instance.mergeSort(this.THOUSAND_POSITIONS_ARRAY, this.THOUSAND_POSITIONS_ARRAY.length);
        
        assertArrayEquals(expected, THOUSAND_POSITIONS_ARRAY);                
    }
   
}