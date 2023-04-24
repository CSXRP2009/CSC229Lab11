package com.mycompany.csc229_bst_example;

/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        doInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
        // ToDo 1: complete InOrder Traversal 
    }

    public void preOrderTraversal() {

        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal . 
    }

    public void doPreOrder(BstNode root) {
        if (root == null) {
            return;
        }
         System.out.print(root.getData() + " ");
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        return findHeight(root,0);
        
        // ToDo 3: Find the height of a tree
    }
    public int findHeight(BstNode node, int count){
        if (node==null){
            return -1;
        }
        if (node.getLeft()==null && node.getRight()== null){
            return count;
        }
        int left = 0;
        int right = 0;
         if (node.getLeft()!= null){
            left= findHeight(node.getLeft(), count +1);
         }  
         if (node.getRight()!= null){
             right = findHeight(node.getRight(), count +1);
         }  
         return Math.max(left, right);
    }
    public int getDepth(BstNode node) {
        return getDepth(root , node , 0);
        
        //ToDo 4: complete getDepth of a node 
    }
    public int getDepth(BstNode node, BstNode value, int count){
        if (node == null || value == null){
            return -1;
        }
        if (node.getData()== value.getData()){
            return count;
        }
        else if (node.getData() > value.getData()){
            return getDepth(node.getLeft(), value, count + 1);
        }
        else {
            return getDepth(node.getRight(), value, count + 1);
        }
    }
    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        doInOrder(root);
        // ToDo 5: complete the print of the BST
    }

}
