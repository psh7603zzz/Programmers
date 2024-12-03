import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 선택정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] a = new int[str.length()];
        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i+1; j < str.length(); j++) {
                if(a[j]>a[max]){
                    max = j;
                }
            }
            if(a[i] < a[max]){
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(a[i]);
        }
    }
}