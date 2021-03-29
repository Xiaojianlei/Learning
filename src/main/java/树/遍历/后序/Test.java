package 树.遍历.后序;

import 树.遍历.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {
    //递归解法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList();
        if(root==null) return result;
        postorder(root,result);
        return result;
    }
    private void postorder(TreeNode root,List<Integer> result){
        if(root==null) return;
        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }

    //迭代解法
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre=null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            if(node.right==null || node.right==pre){
                pre=stack.pop();
                result.add(pre.val);
                root=null;
            }
            else root=node.right;
        }
        return result;
    }

}
