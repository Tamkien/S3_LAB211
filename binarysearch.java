import java.util.*;
public class binarysearch{
    public static void main(String[] args) {
        for (; ; ) {//lap vo tan
            try {
                System.out.println("Enter number of array:");
                Scanner scanner = new Scanner(System.in);//obj scanner
                int sz = scanner.nextInt();//nhap length cua array
                System.out.println("Enter search value:");
                int target = scanner.nextInt();//nhap so can tim
                if (sz == 0) break;//thoat
                search(sort(sz), target, 0, sz-1);//buoc tim kiem dau tien, tim all trong arr
            } catch (Exception e) {//catch loi
                System.out.println(e);
            }
        }
    }
    private static int[] sort(int sz) {
        int swap;//bien luu tam
        boolean sort = false;//neu ko co swap thi la false
        Random random = new Random();//obj random
        int[] arr = new int[sz];//khoi tao array voi length sz
        System.out.print("Unsorted array: [");//in ra array luc dau
        for (int i = 0; i < arr.length; i++) arr[i] = random.nextInt(20);//gan 1 gia tri bat ky tu 0 den 20
        show(arr);
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
        show(arr);//in arr
        return arr;
    }

    private static void search(int[] arr, int target, int start, int end) {
        int id = (start+end)/2;//tim middle index
        if (arr[id] != target && end == start) System.out.println("Not Found!");
        //neu do den cuoi, chi con 1 so, tuc la end bang start, ma target van ko thay, thi la ko co
        else if (arr[id] == target) System.out.println("Found " + target + " at index " + id);//trung thi found luon
        //neu ko trung, xay ra 2 truong hop, trong ca 2 cases ta deu tim tu so ben canh id ve end/start
        else if (arr[id] < target) search(arr, target, id+1, end);
        //tim tu so id+1 den end. Sau buoc nay start tro thanh id +1
        else if (arr[id] > target) search(arr, target, start, id-1);
        //tim tu so start den id - 1. Sau buoc nay end tro thanh id - 1
    }

    private static void show(int[] arr){//method nay de in arr
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
            else System.out.println("]");
        }
    }
}
