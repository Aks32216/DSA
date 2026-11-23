package TwoPointers;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx=m+n-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 || j>=0){
            int val1=(i>=0) ? nums1[i] : Integer.MIN_VALUE;
            int val2=(j>=0) ? nums2[j] : Integer.MIN_VALUE;
            if(val1>val2){
                nums1[idx]=val1;
                idx--;
                i--;
            } else {
                nums1[idx]=val2;
                idx--;
                j--;
            }
        }
    }
}
