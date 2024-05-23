package 그래프;

import java.util.*;

//점 만날 때마다 도형의 개수 ++

public class 방의_개수 {
    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        System.out.println(solution(arrows)); //3
    }

    public static int solution(int[] arrows) {
        int answer = 0;

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        Node curNode = new Node(0, 0);

        Map<Node, List<Node>> visited = new HashMap<>();
        visited.put(curNode, new ArrayList<>()); // 시작점을 방문 처리

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업
                Node nextNode = new Node(curNode.x + dx[arrow], curNode.y + dy[arrow]);

                if (!visited.containsKey(nextNode)) {
                    visited.put(nextNode, new ArrayList<>());
                    visited.get(curNode).add(nextNode);
                } else if (!visited.get(nextNode).contains(curNode)) {
                    visited.get(nextNode).add(curNode);
                    visited.get(curNode).add(nextNode);
                    answer++;
                }

                // 이동 완료
                curNode = nextNode;
            }
        }

        return answer;
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
