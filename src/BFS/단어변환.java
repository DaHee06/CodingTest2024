package BFS;

public class 단어변환 {
    static int answer = 0 ;
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        System.out.println(solution(begin, target, words));
    }
    public static int solution(String begin, String target, String[] words) {

        boolean[] check = new boolean[words.length];
        dfs(begin, target, words, check, 0);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, boolean[] check, int cnt){
        if(begin.equals(target)){
            answer = cnt ;
            return;
        }

        cnt++;
        for(int i = 0 ;i < words.length; i++){
            if(check[i]) continue;
            int k = 0;
            for(int j =0 ; j < begin.length();j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }

            if(k == begin.length() -1){
                check[i] = true;
                dfs(words[i], target, words, check, cnt);
                check[i] = false;
            }
        }
    }
}
