public class SwapElements {

    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Main method to demonstrate the usage of the swap method
    public static void main(String[] args) {
        // Example with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer array: ");
        printArray(intArray);
        swap(intArray, 1, 3);
        System.out.println("Integer array after swapping index 1 and 3: ");
        printArray(intArray);

        // Example with String array
        String[] strArray = {"apple", "banana", "cherry", "date"};
        System.out.println("\nOriginal String array: ");
        printArray(strArray);
        swap(strArray, 0, 2);
        System.out.println("String array after swapping index 0 and 2: ");
        printArray(strArray);
    }

    // Helper method to print the array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
