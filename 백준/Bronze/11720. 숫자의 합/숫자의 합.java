import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // N이 100까지 --> int,long 으로 받기 힘들다
        // String으로 받아서 toCharArray 쓰면된다.
        // char -> int 형변환

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();

        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // char 형태는 -'0'을 해주면 숫자로 변한다.
        }

        System.out.println(sum);
    }
}