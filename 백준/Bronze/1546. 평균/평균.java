import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 최고점 기준 전체점수 다시 계산
        // 모든 점수 입력 - 최고점 별도 저장

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            sum += A[i];
        }

        System.out.println(sum*100.0/max/N);
    }
}