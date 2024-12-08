import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        // 그리디 - 최솟값 만들기 위해 가능한 한 큰 수를 빼야 함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String example = br.readLine();
        String[] str = example.split("-");

        for (int i = 0; i < str.length; i++) {
            if(i == 0 ){
                answer = SUM(str[i]);
            }else{
                answer -= SUM(str[i]);
            }
        }

        System.out.println(answer);
    }

    static int SUM(String example){
        int result = 0;
        String[] str = example.split("\\+");
        for (int i = 0; i < str.length; i++) {
            result += Integer.parseInt(str[i]);
        }
        return result;
    }

}