package 树.遍历.前序;

import 树.遍历.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {
    //递归解法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        preorder(root,result,(x->System.out.println(x)));
        return result;
    }
    private void preorder(TreeNode root , List<Integer> result, Consumer<TreeNode> c){
        if(root==null) return;
        result.add(root.val);
        c.accept(root);
        preorder(root.left,result ,c);
        preorder(root.right,result,c);
    }

    //迭代解法
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> stack=new LinkedList();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node =stack.pop();
            result.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(12);
        TreeNode treeNode1 = new TreeNode(11);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(8,treeNode,treeNode1);
        TreeNode treeNode5= new TreeNode(7,treeNode2,treeNode3);
        TreeNode root= new TreeNode(6,treeNode4,treeNode5);
        new Test().preorderTraversal(root);

    }

}
