import java.util.Scanner;

public class Recurs {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        int F1, F2;
        int qtVezes = prompt.nextInt();

        for(int i = 0; i < qtVezes; i++) {
            F1 = prompt.nextInt();
            F2 = prompt.nextInt();

            System.out.println(mdc(F1, F2));
        }

    }

    public static int mdc(int F1, int F2) {
        if(F2 == 0) {
            return F1;
        }

        int resto = F1 % F2;
        F1 = F2;
        F2 = resto;

        return mdc(F1, F2);
    }

}