package TwoPointers;

// Brute Force
class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        for(int i=0;i<height.length;++i){
            for(int j=i+1;j<height.length;++j){
                int curArea=(j-i)*Math.min(height[i],height[j]);
                maxArea=Math.max(maxArea,curArea);
            }
        }
        return maxArea;
    }
}

// Two Pointer
class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int i=0,j=height.length-1;
        while(i<j){
            int curArea=(j-i)*Math.min(height[i],height[j]);
            maxArea=Math.max(maxArea,curArea);
            if(height[i]<=height[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
