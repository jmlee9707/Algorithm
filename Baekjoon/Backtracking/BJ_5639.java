package Backtracking;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_5639 {
    /*
     * 백준 5639
     * 이진 검색 트리
     */
    static Scanner sc;

    static class TreeNode {
        int root;
        TreeNode right;
        TreeNode left;

        public TreeNode(int root) {
            this.root = root;
            this.left = null;
            this.right = null;
        }

        public void insert(TreeNode node) {
            if (this.root > node.root) {
                if (this.left == null)
                    this.left = node;
                else {
                    this.left.insert(node);
                }
            } else {
                if (this.right == null)
                    this.right = node;
                else
                    this.right.insert(node);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeNode rootNode = new TreeNode(Integer.parseInt(br.readLine()));
        while (true) {
            String temp = br.readLine();

            if (temp == null || temp.equals(""))
                break;
            rootNode.insert(new TreeNode(Integer.parseInt(temp)));
        }
        postOrder(rootNode);

    }

    public static void postOrder(TreeNode node) throws IOException {

        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null)
            postOrder(node.right);
        System.out.println(node.root);
        return;
    }
}
