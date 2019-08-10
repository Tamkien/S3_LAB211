public class fibonacci {
    public static void main(String[] args) {
        System.out.println("The 45 sequence Fibonacci:");
        int f0 = 0, f1 = 1, f2;
        System.out.print("0, 1");
        for (int i = 2; i < 45; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
            System.out.print(", " + f2);
        }
    }
}
