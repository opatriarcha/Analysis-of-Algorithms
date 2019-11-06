package com.freakhouse.algorithms;

/**
 *
 * @author freakhouselabs
 */
public class CountingSort {
    public void sort(Integer[] a, Integer[] b, Integer n, Integer k){
        Integer[] c = new Integer[a.length + 1];
        
        //Zera a merda do array ( se tiver q fazer isso todo algoritmo tamo cagado)
        for( int i = 0; i < c.length; i++){
            c[i] = 0;
        }
                
        //for( int j = 1; j <= n; j++){
        for( int j = 0; j < n; j++){
            c[a[j]] = c[a[j]] + 1;
        }
        
        for( int i = 1; i <= k; i++){
            c[i] = c[i] + c[i-1];
        }
        
        for(int j = n-1; j >= 0; j--){            
            b[c[a[j]]] = a[j];
            c[a[j]] = c[a[j]] -1;
            
            System.out.println("b[c[a[j]]] = a[j] => " + b[c[a[j]]]  + " " + a[j]);
            System.out.println("c[a[j]] = c[a[j]] -1;] => " + c[a[j]]);
        }
        
    }
}
