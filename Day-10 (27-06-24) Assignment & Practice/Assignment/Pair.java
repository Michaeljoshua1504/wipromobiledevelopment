public class Pair<T, U> {
    private T first;
    private U second;

    // Constructor to initialize the Pair with two objects
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Getter for the first object
    public T getFirst() {
        return first;
    }

    // Getter for the second object
    public U getSecond() {
        return second;
    }

    // Method to return a reversed version of the Pair
    public Pair<U, T> reverse() {
        return new Pair<>(second, first);
    }

    // Override toString for a readable representation of the Pair
    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // Main method to test the Pair class
    public static void main(String[] args) {
        // Create a Pair with a String and an Integer
        Pair<String, Integer> originalPair = new Pair<>("Michael", 3000);

        // Print the original Pair
        System.out.println("Original Pair: " + originalPair);

        // Get the reversed Pair
        Pair<Integer, String> reversedPair = originalPair.reverse();

        // Print the reversed Pair
        System.out.println("Reversed Pair: " + reversedPair);
    }
}
