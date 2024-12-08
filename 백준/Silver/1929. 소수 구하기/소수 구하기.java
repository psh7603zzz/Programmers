import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] checkArr = new boolean[m+1];
        int[] intArr = new int[m+1];
        for (int i = 1; i <= m; i++) {
            checkArr[i] = true;
            intArr[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            if(!checkArr[i]) {
                continue;
            }
            if (i == 1) {
                checkArr[i] = false;
            }else{
                for (int j = 2; j <= 500000; j++) {
                    if(i*j > m){
                        break;
                    }
                    checkArr[i*j] = false;
                }
            }
        }

        for (int i = n; i <= m; i++) {
            if(checkArr[i]) {
                System.out.println(intArr[i]);
            }
        }
    }
}