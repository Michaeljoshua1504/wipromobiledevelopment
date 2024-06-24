public class conditional {
    public static void main(String[] args) {
        //comparision --> 2 things to compare
        int a = 6;
        int b = 6;

        // 1. find the bigger
        if(a > b) {
            System.out.println("a is greater than b");
        } else if(a < b) {
            System.out.println("b is greater than a");
        } else {
            System.out.println("both are equal");
        }
    }
}