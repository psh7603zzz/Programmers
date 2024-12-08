import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        n : 동전총종료
        k : 만들려는 가격 합
        a[] : 동전 금액
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
        int count = 0;
        for (int i = a.length-1; i >= 0; i--){
            if(a[i] <= k){
                count += k / a[i];
                k = k % a[i];
            }
        }
        System.out.println(count);
    }

}