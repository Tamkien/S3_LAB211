import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {
        for (; ; ) {//lap vo tan
            try {
                System.out.println("Enter number of array:");
                Scanner scanner = new Scanner(System.in);//obj scanner
                int sz = scanner.nextInt();//nhap length cua array
                System.out.println("Enter search value:");
                int target = scanner.nextInt();//nhap so can tim
                if (sz == 0) break;//thoat
                sort(sz, target);//buoc tim kiem dau tien, tim all trong arr
            } catch (Exception e) {//catch loi
                System.out.println(e);
            }
        }
    }

    private static int sort(int sz, int target) {
        Random random = new Random();//obj random
        int[] arr = new int[sz];//khoi tao array voi length sz
        System.out.print("The array: [");//in ra array luc dau
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);//gan 1 gia tri bat ky tu 0 den 20
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
            else System.out.println("]");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found " + target + " at index: " + i);
                return 1;
            }
        }
        System.out.println("Not Found!");
        return 1;
    }
}
