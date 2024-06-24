public class patterns {
    public static void main(String[] args) {
        // right angled triangle
        /*
         * 
         * *
         * * *
         * * * *
         * * * * *
         */

        // Code:- (nested for loop)
        // 5 -> no of columns
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* "); // print *
            }
            System.out.println(); // move to the new line
        }
        
    }
}