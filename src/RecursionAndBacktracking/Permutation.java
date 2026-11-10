package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

// Bactracking with visited array

class Solution {

    private void solve(int[] nums, boolean[] visited,List<List<Integer>> res,List<Integer> temp){
        if(nums.length==temp.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            temp.add(nums[i]);
            solve(nums,visited,res,temp);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        boolean[] visited=new boolean[n];
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(nums,visited,res,temp);
        return res;
    }
}

// backtracking with modifying the original array

class Solution {

    private void solve(int[] nums,List<List<Integer>> res,List<Integer> temp){
        if(nums.length==temp.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(nums[i]==Integer.MAX_VALUE){
                continue;
            }
            int curValue=nums[i];
            nums[i]=Integer.MAX_VALUE;
            temp.add(nums[i]);
            solve(nums,res,temp);
            temp.remove(temp.size()-1);
            nums[i]=curValue;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(nums,res,temp);
        return res;
    }
}


// swap in place

class Solution {

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void solve(int idx,int[] nums,List<List<Integer>> res){
        if(idx==nums.length){
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        for(int i=idx;i<nums.length;++i){
            swap(nums,idx,i);
            solve(idx+1,nums,res);
            swap(nums,idx,i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        solve(0,nums,res);
        return res;
    }
}