package com.freakhouse.algorithms;

/**
 *
 * @author freakhouselabs
 */
public class MergeSortPassingParamN {

    public void mergeSort(Integer[] a, Integer n) {
        if (n < 2) {
            return;
        }
        Integer mid = n / 2;
        Integer[] l = new Integer[mid];
        Integer[] r = new Integer[n - mid];

        for (Integer i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (Integer i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public void merge(
            Integer[] a, Integer[] l, Integer[] r, Integer left, Integer right) {

        Integer i = 0, j = 0, k = 0;
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
}
