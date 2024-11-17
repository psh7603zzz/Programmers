import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 합 배열 공식 S[i] = S[i-1] + A[i]
        // 구간 합 공식 S[j] - S[i-1]

        // 스캐너보다 버퍼리더 사용해서 데이터 받자
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 값이 길면 스트링토크나이저를 사용하자
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int suNo = Integer.parseInt(stringTokenizer.nextToken()); // 숫자개수
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // 질의 개수

        // 합배열
        long[] S = new long[suNo + 1]; // 0번째 인덱스 무시하기 위해 + 1
        S[0] = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        
        for(int q=0; q < quizNo; q++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }
    }
}