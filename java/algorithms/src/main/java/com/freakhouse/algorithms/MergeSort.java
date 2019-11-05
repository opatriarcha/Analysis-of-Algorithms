package com.freakhouse.algorithms;

/**
 *
 * @author freakhouselabs
 */
public class MergeSort {

    public void mergeSort(Integer[] array) {
        if (array.length < 2) {
            return;
        }
        int n = array.length;
        int mid = n / 2;
        //int mid = Math.floorDiv(n, 2);
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[n - mid];

        System.arraycopy(array, 0, left, 0, mid);
        if( n % 2 == 0)
            System.arraycopy(array, mid, right, 0, mid);
        else
            System.arraycopy(array, mid, right, 0, mid+1);

        printArray("ARRAY ORIGINAL: ", array);
        printArray("ARRAY LEFT: ", left);
        printArray("ARRAY RIGHT: ", right);
        
        mergeSort(left);
        mergeSort(right);

        this.merge(array, left, right, mid, n - mid);

    }

    private void merge(Integer[] a, Integer[] l, Integer[] r, int left, int right) {
        printArray("A: ", a);
        printArray("left: ", l);
        printArray("right: ", r);
        System.out.println("LEFT index: " + left);
        System.out.println("RIGHT index: " + right);
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    
    protected void printArray(String msg, Integer[] array){
        StringBuilder builder = new StringBuilder();
        builder.append(msg);
        
        
        for( Integer i : array){
            builder.append(i);
            builder.append(", ");
        }
        String result = builder.toString();
        System.out.println(result.subSequence(0, result.lastIndexOf(", ")).toString());
        
    }
}
