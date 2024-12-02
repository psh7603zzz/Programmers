import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 스택 후입선출

        /*
        N(수열 개수) A[](수열 배열)
         */

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(bf.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            int su = a[i];
            if( su >= num){
                while(su>=num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else{
                int nu = stack.pop();
                if(nu > su){
                    System.out.println("NO");
                    flag = false;
                    break;
                }else{
                    sb.append("-\n");
                }
            }
        }
        if(flag){
            System.out.println(sb.toString());
        }
    }
}