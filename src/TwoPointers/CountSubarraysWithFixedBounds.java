package TwoPointers;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int count=0;
        for(int i=0;i<nums.length;++i){
            int minVal=Integer.MAX_VALUE;
            int maxVal=Integer.MIN_VALUE;
            for(int j=i;j<nums.length;++j){
                minVal=Math.min(minVal,nums[j]);
                maxVal=Math.max(maxVal,nums[j]);
                if(minVal==minK && maxVal==maxK){
                    count++;
                }
            }
        }
        return count;
    }
}


class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        int lastBound=-1;
        int lastMax=-1,lastMin=-1;
        long count=0;
        for(int i=0;i<n;++i){
            if(nums[i]>=minK && nums[i]<=maxK){
                lastMax=(nums[i]==maxK) ? i : lastMax;
                lastMin=(nums[i]==minK) ? i : lastMin;
                count+=Math.max(0,Math.min(lastMin,lastMax)-lastBound);
            } else {
                lastBound=i;
                lastMax=-1;
                lastMin=-1;
            }
        }
        return count;
    }
}