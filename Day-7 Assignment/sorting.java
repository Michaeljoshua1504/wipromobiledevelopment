public class sorting {
    public static int[] sort(int[] arr) {
       
        return arr;
    }
    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Sorting --> (Bubble sort)
        int[] arr = {8, 9, 0, 56, 45, 7};
        // Sort(arr) -> [0, 7, 8, 9, 45, 56]
        // printArr(sort(arr));


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        
    }
}