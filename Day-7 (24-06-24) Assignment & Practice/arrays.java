public class arrays {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 5;
        arr[1] = 5;
        arr[2] = 45;
        arr[3] = 5;
        arr[4] = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 5) {
                arr[i] = 67;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
