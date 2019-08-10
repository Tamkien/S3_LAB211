public class fibonacci {
    public static void main(String[] args) {
        System.out.println("The 45 sequence Fibonacci:");
        for (int i = 0; i < 45; i++) {
            System.out.print(calc(i));
            if (i!=44) System.out.print(", ");
        }
    }

    private static int calc(int i) {
        if (i<2) return i;
        else return calc(i-1) + calc(i-2);
    }
}
