import java.util.*;
public class slsort {
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
        int swap;
        boolean happen = false;//neu ko co swap thi la false
        Random random = new Random();//obj random
        int[] arr = new int[sz];//khoi tao array voi length sz
        System.out.print("Unsorted array: [");//in ra array luc dau
        for (int i = 0; i < arr.length; i++) arr[i] = random.nextInt(20);//gan 1 gia tri bat ky tu 0 den 20
        show(arr);
        int min, j, m=0;
        for (int i = 0; i < arr.length - 1; i++) {//i chay tu 1 den so ap chot
            min = arr[i];//theo thuat toan nay thi arr[i] la so can xu ly, con cac so truoc do deu da dc sap xep xong
            for (j = i + 1; j < arr.length; j++) if (arr[j] < min) {//tim tu so sau arr i den so cuoi
                    min = arr[j];//neu be hon arr j thi tam cho la min
                    m = j;//ghi lai vi tri trong array
                    happen = true;//tuc la co su thay doi
                }
            if (happen) {//neu co su thay doi
                swap = arr[i];//thi lam thoi :D
                arr[i] = arr[m];
                arr[m] = swap;
                happen = false;//reset de tinh tiep
            }
        }
        System.out.print("Sorted array: [");//chay het vong lap se in ra ket qua
        show(arr);
    }
    private static void show(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
            else System.out.println("]");
        }
    }
}
