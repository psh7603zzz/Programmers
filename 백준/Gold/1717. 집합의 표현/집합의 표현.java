import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        // 유니온파인드 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) { // 초기화
            parent[i] = i;
        }

        for(int i = 0; i < M; i++){ // 질의계산
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(question == 0){ // union
                union(a,b);
            }else{ // 두원소 같은지 보기
                 boolean result = checkSame(a,b);
                 if(result){
                     System.out.println("YES");
                 }else{
                     System.out.println("NO");
                 }
            }
        }
    }

    private static void union(int a, int b) {
        // 대표노드를 찾아서 연결
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a; // 두개 연결
        }
    }

    private static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]); // 경로압축
    }

    private static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return true;
        return false;
    }

}