import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N 정렬할 수 개수, M 탐색할 숫자 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = a.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if(a[mid] > target) {
                    end = mid - 1;
                }
                else if (a[mid] < target) {
                    start = mid + 1;
                }
                else {
                    find = true;
                    break;
                }
            }
            if(find) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

}