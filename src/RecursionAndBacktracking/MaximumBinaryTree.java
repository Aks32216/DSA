package RecursionAndBacktracking;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// APPROACH - 1 DIVIDE and CONQUOR

class Solution {

    int[] findMaxValAndIdx(int start,int end,int[] nums){
        int maxVal=Integer.MIN_VALUE;
        int maxValIdx=-1;
        for(int i=start;i<=end;++i){
            if(nums[i]>maxVal){
                maxVal=nums[i];
                maxValIdx=i;
            }
        }
        return new int[]{maxValIdx,maxVal};
    }

    TreeNode solve(int start,int end,int[] nums){
        if(start>end){
            return null;
        }
        int[] valAndIdx=findMaxValAndIdx(start,end,nums);
        int maxValIdx=valAndIdx[0];
        int maxVal=valAndIdx[1];
        TreeNode root=new TreeNode(nums[maxValIdx]);
        root.left=solve(start,maxValIdx-1,nums);
        root.right=solve(maxValIdx+1,end,nums);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length-1;
        return solve(0,n,nums);
    }
}

// APPROACH - 2 MONOTONIC STACK

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> st=new Stack<>();
        for(int num:nums){
            TreeNode curElem=new TreeNode(num);

            while(!st.empty() && st.peek().val<num){
                curElem.left=st.pop();
            }
            if(!st.empty()) {
                st.peek().right = curElem;
            }
            st.push(curElem);
        }
        TreeNode root=null;
        while(!st.empty()){
            root=st.pop();
        }
        return root;
    }
}
