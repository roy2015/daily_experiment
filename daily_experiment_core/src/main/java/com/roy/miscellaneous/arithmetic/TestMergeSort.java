package com.roy.miscellaneous.arithmetic;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by apple on 2019/3/30.
 */
public class TestMergeSort {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMergeSort.class);

    public int[] mergeSort(int[] dataArry) {
        if (dataArry.length == 0) {
            return null;
        }

        int length = dataArry.length;
        int i = length / 2;
        int[] leftArray = Arrays.copyOfRange(dataArry, 0, i);
        int[] rightArray = Arrays.copyOfRange(dataArry, i, length);

        if (dataArry.length == 1) {
            return dataArry;
        } else {
            return merge(mergeSort(leftArray), mergeSort(rightArray));
        }
    }

    private int[] merge(int[] leftArry, int[] rightArry) {
        int[] ret = new int[leftArry.length + rightArry.length];

        int i=0, j =0, k =0;
        for (; i<leftArry.length && j <rightArry.length;k++){
            if (leftArry[i] <= rightArry[j]) {
                ret[k] = leftArry[i++];
            } else {
                ret[k] = rightArry[j++];
            }
        }
        if (i< leftArry.length) {
            for (int mi = i; mi< leftArry.length; mi++,k++) {
                ret[k] = leftArry[mi];
            }
        }
        if (j< rightArry.length) {
            for (int mi = j; mi< rightArry.length; mi++,k++) {
                ret[k] = rightArry[mi];
            }
        }

        return ret;
    }


}
