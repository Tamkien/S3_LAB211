import java.util.*;

public class Equation implements phuongtrinh {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public List<Float> calculateEquation(float a, float b) {
        ArrayList<Float> e = new ArrayList();
        if (a == 0) {
            if (b == 0) return Collections.emptyList();
            return null;
        }
        e.add(-b / a);
        return e;
    }

    @Override
    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        ArrayList<Float> q = new ArrayList<>();
        float delta = b * b - 4 * a * c;
        if (delta < 0) return null;
        else {
            q.add((-b + (float) Math.sqrt(delta) / (2 * a)));
            q.add((-b - (float) Math.sqrt(delta) / (2 * a)));
        }
        return q;
    }

    public static void main(String[] args) {
        Equation equation = new Equation();
        for (; ; ) {
            System.out.println("\n========= Equation Program =========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.println("\nPlease choose one option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ArrayList<Float> c1 = new ArrayList<>();
                    float a, b;
                    System.out.println("----- Calculate Equation -----");
                    System.out.println("Enter A:");
                    while (!sc.hasNextFloat()) {
                        System.out.println("Error! Enter A again:");
                        sc.next();
                    }
                    a = sc.nextFloat();
                    c1.add(a);
                    System.out.println("Enter B:");
                    while (!sc.hasNextFloat()) {
                        System.out.println("Error! Enter B again:");
                        sc.next();
                    }
                    b = sc.nextFloat();
                    c1.add(b);
                    if (equation.calculateEquation(a, b) == null) System.out.println("No solutions");
                    else if (equation.calculateEquation(a, b).isEmpty())
                        System.out.println("Infinitely many solutions");
                    else {
                        float r = equation.calculateEquation(a, b).get(0);
                        System.out.println("Solution x = " + r);
                        c1.add(r);
                    }
                    check(c1);
                    break;
                case 2:
                    ArrayList<Float> c2 = new ArrayList<>();
                    float A, B, C;
                    System.out.println("----- Calculate Quadratic Equation -----");
                    System.out.println("Enter A:");
                    while (!sc.hasNextFloat()) {
                        System.out.println("Error! Enter A again:");
                        sc.next();
                    }
                    A = sc.nextFloat();
                    c2.add(A);
                    System.out.println("Enter B:");
                    while (!sc.hasNextFloat()) {
                        System.out.println("Error! Enter B again:");
                        sc.next();
                    }
                    B = sc.nextFloat();
                    c2.add(B);
                    System.out.println("Enter C:");
                    while (!sc.hasNextFloat()) {
                        System.out.println("Error! Enter C again:");
                        sc.next();
                    }
                    C = sc.nextFloat();
                    c2.add(C);
                    if (A == 0) {
                        if (equation.calculateEquation(B, C) == null) System.out.println("No solutions");
                        else if (equation.calculateEquation(B, C).isEmpty())
                            System.out.println("Infinitely many solutions");
                        else {
                            float R = equation.calculateEquation(B, C).get(0);
                            System.out.println("Solution x = " + R);
                            c2.add(R);
                        }
                        break;
                    }
                    if (equation.calculateQuadraticEquation(A, B, C) == null)
                        System.out.println("No Solutions");
                    else {
                        float x1 = equation.calculateQuadraticEquation(A, B, C).get(0);
                        float x2 = equation.calculateQuadraticEquation(A, B, C).get(1);
                        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
                        c2.add(x1);
                        c2.add(x2);
                    }
                    check(c2);
                    break;
                case 3:
                    System.exit(1);
                default:
                    System.out.println("Error");
            }
        }
    }

    private static void nhap(float a) {
        try {
            a = sc.nextFloat();
        } catch (Exception e) {
            System.out.println(e);
            nhap(a);
        }
    }

    private static void check(ArrayList<Float> ar) {
        ArrayList<Float> odd = new ArrayList<>();
        ArrayList<Float> even = new ArrayList<>();
        ArrayList<Float> ps = new ArrayList<>();
        for (Float aFloat : ar) {
            if (isEven(aFloat)) even.add(aFloat);
            else odd.add(aFloat);
            if (isPerfectSquare(aFloat)) ps.add(aFloat);
        }
        System.out.print("Number is Odd: ");
        check2(odd);
        System.out.print("\nNumber is Even: ");
        check2(even);
        System.out.print("\nNumber is Perfect Square: ");
        check2(ps);
    }

    private static void check2(ArrayList<Float> ar) {
        for (int i = 0; i < ar.size(); i++) {
            System.out.print(ar.get(i));
            if (i != ar.size() - 1) System.out.print(", ");
        }
    }

    private static boolean isEven(float x) {
        return x % 2 == 0;
    }

    private static boolean isPerfectSquare(float x) {
        return ((Math.sqrt(x) - (int) (Math.sqrt(x)) == 0));
    }
}
