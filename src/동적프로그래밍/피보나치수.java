package 동적프로그래밍;

/**
 * 피보나치수
 * 수열의 값이 커지기 때문에 나머지의 값으로 저장하여 성능을 올린다
 * 각각의 숫자들의 마너지 합 = 각 숫자들의 합의 나머지와 같다 (%)
 */
public class 피보나치수 {
    static int n = 3;
    static int[] arr;

    //전역변수 이용
    public static void main(String[] args) {
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        arr = new int[n+1];
        int answer = fibonacci(n);
        return answer;
    }

    private static int fibonacci(int n) {
        if (n < 2) return n;
        else if (arr[n] != 0) {
            return arr[n] % 1234567;
        } else return arr[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567;
    }

    //메모이제이션 이용
//    public static int solution(int n){
//        int[] memo = new int[n+1]; // 메모이제이션을 위한 배열 초기화
//
//        // 메모이제이션 배열 초기화
//        if (n > 0) {
//            memo[1] = 1;
//        }
//
//        return fibonacci(memo, n);
//    }
//
//    public static int fibonacci(int[] memo, int n){
//        if (n < 2) return n; // 기본 조건: 피보나치 수 0과 1은 자기 자신
//
//        // 이미 계산된 값을 체크하여 재계산 방지
//        if (memo[n] != 0) {
//            return memo[n]; // 이미 계산된 값이 있으면 그 값을 반환
//        }
//
//        // 아직 계산되지 않은 경우, 재귀적으로 계산
//        memo[n] = (fibonacci(memo, n-1) + fibonacci(memo, n-2)) % 1234567;
//        return memo[n]; // 계산된 값을 저장하고 반환
//    }
}
