import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 큐 - 선입선출
        // 양쪽 삽입 삭제 큐로 구현 가능

        // 맨위카드 버리기 poll, 맨위카드 가장 아래 카드밑으로 이동 poll() -> add()

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();
            int temp = q.poll();
            q.add(temp);
        }
        System.out.println(q.poll());
    }
}