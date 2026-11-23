package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private void leftMax(List<Integer> lmax, int[] height){
        int m=0;
        for(int i=0;i<height.length;++i){
            m=Math.max(m,height[i]);
            lmax.set(i,m);
        }
    }

    private void rightMax(List<Integer> rmax,int[] height){
        int m=0;
        for(int i=height.length-1;i>=0;--i){
            m=Math.max(m,height[i]);
            rmax.set(i,m);
        }
    }

    public int trap(int[] height) {
        int n=height.length;
        List<Integer> lmax = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> rmax = new ArrayList<>(Collections.nCopies(n, 0));
        leftMax(lmax,height);
        rightMax(rmax,height);

        int waterTrapped=0;
        for(int i=0;i<height.length;++i){
            int localHeightMin=Math.min(lmax.get(i),rmax.get(i));
            waterTrapped+=(localHeightMin-height[i]);
        }
        return waterTrapped;
    }
}