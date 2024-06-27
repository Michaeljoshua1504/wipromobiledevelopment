import java.util.Arrays;

public class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        System.out.println("Before swap: " + Arrays.toString(intArray));
        swap(intArray, 0, 2);
        System.out.println("After swap: " + Arrays.toString(intArray));

        String[] stringArray = {"apple", "banana", "cherry"};
        System.out.println("Before swap: " + Arrays.toString(stringArray));
        swap(stringArray, 1, 2);
        System.out.println("After swap: " + Arrays.toString(stringArray));
    }
}