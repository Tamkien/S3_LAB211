import java.util.*;
public class bbsort {
    public static void main(String[] args) {
        for (; ; ) {//lap vo tan
            try {
                System.out.println("Enter number of array:");
                Scanner scanner = new Scanner(System.in);//obj scanner
                int sz = scanner.nextInt();//nhap length cua array
                if (sz == 0) break;//thoat
                work(sz);//function 2
            } catch (Exception e) {//catch loi
                System.out.println("Error!");
            }
        }
    }
    private static void work(int sz) {
        int swap;//bien luu tam
        boolean sort = false;//neu ko so sort thi la false
        Random random = new Random();//obj random
        int[] arr = new int[sz];//khoi tao array voi length sz
        System.out.print("Unsorted array: [");//in ra array luc dau
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);//gan 1 gia tri bat ky tu 0 den 20
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
            else System.out.println("]");
        }
        for (int i = 0; i < arr.length - 1; i++) {//bat dau sort
            if (arr[i] > arr[i + 1]) {//neu lon hon thi swap
                swap = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = swap;
                sort = true;//neu co swap thi sort = true
            }
            if (i == arr.length - 2 & sort) {//neu xay ra swap
                i = -1;//reset, den vong lap sau i++ thi i=0
                sort = false;//reset
            }
        }
        System.out.print("Sorted array: [");//neu sort = false thi sort xong, in ket qua
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
            if (k != arr.length - 1) System.out.print(", ");
            else System.out.println("]");
        }
    }
}

