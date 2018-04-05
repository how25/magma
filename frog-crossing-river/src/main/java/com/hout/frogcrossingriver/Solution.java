package com.hout.frogcrossingriver;

/**
 * Created by hout on 2018/4/5.
 */
public class Solution {
    public boolean canCross(int[] stones) {
        // if the second stone is not 1 return false
        if (stones[1] != 1) {
            return false;
        }
        // collect the interval one by one
        int[] interval = collectInterval(stones);

        for (int i = interval.length -1 , j = 0; i >= 0;  i--) {
            j += interval[i];
            if (canCross(interval, j-1 , i) || canCross(interval, j , i) || canCross(interval, j+1, i)){
                return true;
            }
        }
        return false;
    }

    public int[] collectInterval(int[] from) {
        int[] interval = new int[from.length - 1];
        for (int i = 1; i < from.length; i++) {
            interval[i - 1] = from[i] - from[i-1];
        }
        return interval;
    }

    public boolean canCross(int[] a, int step, int index) {
        if (index == 0 ) {
            if (step == 1)
                return true;
            else
                return false;
        }
        index--;

        if (step == 0) {
            return false;
        }

        int b = index - step;
        if (b < -1) return false;
        for (int j =0;index > step - 2;index--) {
            j+= a[index];
            if (j > step) return false;
            if (step == j) {
                if (canCross(a, step -1 , index) || canCross(a, step  ,index) || canCross(a, step +1 ,index)) {
                    return true;
                }
            }
        }
        return false;
    }
}
