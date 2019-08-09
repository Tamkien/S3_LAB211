import java.util.*;//.

public class issort {
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
        boolean hp = false;
        Random random = new Random();//obj random
        int[] arr = new int[sz];//khoi tao array voi length sz
        System.out.print("Unsorted array: [");//in ra array luc dau
        for (int i = 0; i < arr.length; i++) arr[i] = random.nextInt(20);//gan 1 gia tri bat ky tu 0 den 20
        show(arr);//in ra
        for (int i = 1; i < arr.length; i++) {//chay tu 1 den het
            int k = i - 1;//k nay la index cua so ngay dang sau so dang xet, tuc la so dau tien phai so sanh
            while (arr[i] < arr[k]) {//chung nao so i con nho hon so k thi con phai fix
                hp = true;//con phai fix
                if (k == 0) {//neu da quet den cuoi
                    fix(arr, i, 0);//thi thay dung vao arr 0
                    hp = false;//reset
                    break;//thoat vong lap. 
                } else k--;//neu chua den cuoi thi van xet tiep so sau nua
            }
            if (hp) {//neu con phai fix
                fix(arr, i, k + 1);//thi fix
                hp = false;//reset
            }
        }
        System.out.print("Sorted array: [");//chay het vong lap se in ra ket qua
        show(arr);
    }

    private static void fix(int[] arr, int i, int k) {//method nay de dich so tu i len i+1
        int min;
        min = arr[i];//tam thoi nhac i ra ngoai
        for (int j = i; j > k; j--) arr[j] = arr[j - 1];//tu i den k+1, cu so sau bang so truoc
        arr[k] = min;//so k se bang so i luc nay
    }

    private static void show(int[] arr) {//in ra
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
            else System.out.println("]");
        }
    }
}
