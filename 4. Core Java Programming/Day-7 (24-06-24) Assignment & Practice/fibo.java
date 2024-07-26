public class fibo {
    public static void printFibo(int n) {
        int pre1 = 0, pre2 = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(pre1 + " ");

            //swap
            int temp = pre2 + pre1;
            pre1 = pre2;
            pre2 = temp;
        }
    }
    public static void main(String[] args) {
        printFibo(10);
    }
}