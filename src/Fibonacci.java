import java.util.Scanner;

public class Fibonacci {
    public static int c = 0;


    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        int num_calls = prompt.nextInt();
        int nums = prompt.nextInt();

        for(int i = 1; i <= num_calls; i ++) {
            int calls = (Fibo(nums));
            System.out.println("fib("+ nums +") = "+ (c-1) +" calls "+ calls);

            if(num_calls > 1) {
                nums = prompt.nextInt();
            }
        }
    }

    public static int Fibo(int f) {
        c++;

        if(f == 0) {
            return 0;
        } else if(f == 1) {
            return 1;
        } else

        return Fibo(f - 1) +  Fibo(f - 2);
    }
}
