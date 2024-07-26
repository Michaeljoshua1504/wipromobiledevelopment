public class methods {
    public void sum(int a, int b) {
        System.out.println("The sum is: " + (a + b));
    }

    public static void sub(int a, int b) {
        System.out.println("Sub: " + (a - b));
    }

    public static int prod(int a, int b) {
        return a * b;
    }

    public static double sine(int a) {
        return Math.sin(a);
    }

    public static void main(String[] args) {
        methods m = new methods();
        m.sum(5, 6);
        m.sum(6, 9);

        sub(4, 1);
        int result = prod(5, 6);
        System.out.println("product: " + result); 

        //TODO: calculator methods

        System.out.println("sine: " + sine(0)); // 1 radians
    }
}