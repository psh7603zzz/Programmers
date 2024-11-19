import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            사용변수 count =1, start_index = 1, end_index = , sum = 1
            while (end_index != N){
                if(sum == N) count 증가, end_index 증가, sum값 변경
                else if (sum > N) sum값 변경, start_index 증가
                else if (sum < N) end_index 증가, sum값 변경
            }
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index != n){
            if(sum==n){
                count++; end_index++;
                sum = sum + end_index;
            }
            else if(sum>n) {
                sum = sum - start_index;
                start_index++;
            }
            else{
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}