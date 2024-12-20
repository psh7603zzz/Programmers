import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 최소공배수 = a*b / 최대공약수
            System.out.println(a*b/gcd(a,b));
        }

    }

    // 최대공약수
    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}