package 树.遍历.中序;

import 树.遍历.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {
    //递归解法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =new ArrayList();
        inorder(root,result);
        return result;
    }
    private void inorder(TreeNode root ,List<Integer> result){
        if(root==null) return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    //非递归解法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result =new ArrayList();
        Deque<TreeNode> stack=new LinkedList();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode node=stack.pop();
            result.add(node.val);
            root=node.right;
        }
        return result;
    }

}
