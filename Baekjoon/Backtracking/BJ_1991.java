package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1991 {
    /*
     * 백준 1991
     * 트리순회
     */
    static int N;
    static ArrayList<ArrayList<TreeNode>> list;
    static String pre, mid, post;

    static class TreeNode {
        char idx, left, right;

        public TreeNode(char idx, char left, char right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>()); // A -> 65
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char sN = st.nextToken().charAt(0);
            char lN = st.nextToken().charAt(0);
            char rN = st.nextToken().charAt(0);

            list.get(sN - 65).add(new TreeNode(sN, lN, rN));

        }

        // input 끝
        pre = "";
        mid = "";
        post = "";
        preOrder(0);
        midOrder(0);
        postOrder(0);
        System.out.println(pre);
        System.out.println(mid);
        System.out.println(post);

    }

    public static void preOrder(int root) {

        TreeNode t = list.get(root).get(0);
        if (t.idx == '.')
            return;
        pre += t.idx;

        if (t.left != '.')
            preOrder(t.left - 65);
        if (t.right != '.')
            preOrder(t.right - 65);

    }

    public static void midOrder(int root) {
        TreeNode t = list.get(root).get(0);

        if (t.idx == '.')
            return;

        if (t.left != '.')
            midOrder(t.left - 65);

        mid += t.idx;

        if (t.right != '.')
            midOrder(t.right - 65);
    }

    public static void postOrder(int root) {
        TreeNode t = list.get(root).get(0);

        if (t.idx == '.')
            return;

        if (t.left != '.')
            postOrder(t.left - 65);

        if (t.right != '.')
            postOrder(t.right - 65);
        post += t.idx;
    }
}
