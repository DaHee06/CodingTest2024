package 그래프;

import java.util.Arrays;
import java.util.Comparator;

public class 길_찾기_게임 {
    int[][] answer;
    int idx;

    public static void main(String[] args) {
        int[][] nodeinfo = {
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };

//        System.out.println(solution(nodeinfo));

    }

    public int[][] solution(int[][] nodeinfo) {

        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) return o1.x - o2.x;
                else return o2.y - o1.y;
            }
        });

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        answer = new int[2][nodeinfo.length];
        idx = 0;
        preOrder(root);
        idx = 0;
        postorder(root);

        return answer;
    }

    public void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.data;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.data;
        }
    }

    public class Node {
        int x;
        int y;
        int data; // Node의 고유 인덱스
        Node left;
        Node right;

        Node(int x, int y, int data, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
