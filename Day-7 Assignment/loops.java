public class loops {
    public static void main(String[] args) {
        System.out.println("Michael"); // 100 times
        
        // for i loop
        // i --> 0 < 100; i+1
        // steps -> 0 - 99 = 100 times
        for (int i = 1; i <= 100; i++) {
            //System.out.println(i + ". Michael");
        }

        //while loops
        int i = 0;
        while (i < 100) {
            if(i % 2 != 0) { // odd
                i++;
                continue; // skip
            }
            // System.out.println(i);
            if(i == 50) {
                break; // exit the loop
            }
            i++; // update statement
        }

        // do-while loops (atleast 1 times)
        int j = 0;
        do {
            // System.out.println("Michael");
            j++;
        } while(j < 0);


    }
}