package com.ascending.algorithm;

public class Dfs {
    public void preOrder(TreeNode node){
        if( node != null){
            System.out.println(node.value);
        }else {return;}

        if (node.left != null){
            preOrder(node.left);
        }

        if(node.right != null){
            preOrder(node.right);
        }
    }

    public void postOrder(TreeNode node){
        if (node == null)return;

        if(node.left != null){
            postOrder(node.left);
        }

        if(node.right != null){
            postOrder(node.right);
        }

        System.out.println(node.value);
    }

    public void inOrder(TreeNode node){
        if(node == null)return;

        if (node.left != null){
            inOrder(node.left);
        }

        System.out.println(node.value);

        if (node.right != null){
            inOrder(node.right);
        }
    }


    public static void main(String[] arg){
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(2);
        right.right=new TreeNode(2);

        Dfs dfs = new Dfs();
        System.out.println("preOrder Tree:");
        dfs.preOrder(root);
        System.out.println("postOrder Tree:");
        dfs.postOrder(root);
        System.out.println("inOrder Tree:");
        dfs.inOrder(root);
    }
}
