package 树.遍历.后序;

import 树.遍历.TreeNode;

public class 前序后序BuildTree {
    //pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
    //
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7}, post = {4, 5, 2, 6, 7, 3, 1};
        constructFromPrePost(pre ,post);
    }
    static int preIndex = 0, posIndex = 0;
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }
}
