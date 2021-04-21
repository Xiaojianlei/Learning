package 树.遍历;

public class 前序中序BuildTree {
    int pre=0,in=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[]preorder,int[] inorder,int stop){
        if(pre==preorder.length) return null;
        if(inorder[in]==stop){
            in++;
            return null;
        }
        TreeNode root=new TreeNode(preorder[pre++]);
        root.left= buildTree(preorder,inorder,root.val);
        root.right= buildTree(preorder,inorder,stop);
        return root;
    }

    /**
     * 常规HashMap记录位置解
     *     HashMap <Integer,Integer> map=new HashMap<>();
     *     public TreeNode buildTree(int[] preorder, int[] inorder) {
     *         for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
     *         return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
     *     }
     *     private TreeNode build(int[] preorder,int pl,int pr ,int[] inorder,int il,int ir){
     *         if(pl>pr) return null;
     *         TreeNode root=new TreeNode(preorder[pl]);
     *         int index=map.get(root.val);
     *         root.left=build(preorder,pl+1,pl+index-il,inorder,il,index-1);
     *         root.right=build(preorder,pl+index-il+1,pr,inorder,index+1,ir);
     *         return root;
     *     }
     */
}
