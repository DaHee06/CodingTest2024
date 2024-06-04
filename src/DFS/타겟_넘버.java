package DFS;

/**
 * dfs(numbers, 1, target, 1):
 *
 * plus = dfs(numbers, 2, target, 2) = 1
 * minus = dfs(numbers, 2, target, 0) = 0
 * return plus + minus = 1 + 0 = 1
 * dfs(numbers, 1, target, -1):
 *
 * plus = dfs(numbers, 2, target, 0) = 0
 * minus = dfs(numbers, 2, target, -2) = 0
 * return plus + minus = 0 + 0 = 0
 */
public class 타겟_넘버 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }

    public static int dfs(int[] numbers, int depth, int target, int result) {
        if (depth == numbers.length) {
            return result == target ? 1 : 0;
        }

        int plus = dfs(numbers, depth + 1, target, result + numbers[depth]);
        int minus = dfs(numbers, depth + 1, target, result - numbers[depth]);

        // 각각의 재귀 호출에서 반환된 경우의 수를 합산하여 반환
        return plus + minus;
    }
}
