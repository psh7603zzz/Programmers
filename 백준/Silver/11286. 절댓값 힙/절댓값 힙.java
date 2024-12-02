import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 우선순위 큐 사용
        // 절대값 정렬 필요 ( 우선순위 큐 정렬수정 )

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 절대값이 같은 경우 음수 우선
            if(first_abs == second_abs){
                return o1 - o2;
            }
            // 절대값 작은 데이터 우선
            return first_abs - second_abs;
        });

        for(int i = 0; i < N; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(myQueue.isEmpty()){
                    System.out.println("0");
                }else {
                    System.out.println(myQueue.poll());
                }
            }else{
                myQueue.add(request);
            }
        }
    }
}