package com.whlib.testjavalib.algorithms;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

/**
 * Created by wanghui on 17-1-9.
 */

public class TryQuickSort extends ABaseTry {

    @Override
    public void startTry() {
        super.startTry();

        Loger.d("start TryQuickSort");
    }

    private void test1() {

    }

    private static int[] data = new int[]{5, 2, 3, 6, 1};

    private void qs1(int[] data, int sI, int eI) {
        int pivot = data[sI];

        int index = sI + 1;
        int startI = sI;
        int endI = eI;
        while(index <= eI) {
            if (data[index] < pivot) {
                data[startI] = data[index];
                data[index] = pivot;
                startI = index;
            } else {
                // no need swap
            }

            ++index;
        }
    }

    private void qs2(int[] data, int low, int high) {

        int pivot = data[low];

        while(low < high) {

        }
    }
}
