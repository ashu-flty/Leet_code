class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        inOrderTraversal(root, list);
        int min=Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++){
            min= Math.min(min, list.get(i+1)-list.get(i));
        }
        return min;
        
    }
    public void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root==null) return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}