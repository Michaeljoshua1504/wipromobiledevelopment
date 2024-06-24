public class stringex {
    public static void split() {
        String str = "Michael, Joshua, Mikey, MJ";
        String[] arr = str.split(", ");
        for (String s : arr) { // for-each loop
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        String str = "   MiChAeL   "; // uppercase
        String str2 = "mIChaEL"; // lowercase

        System.out.println(str.trim());
        System.out.println(str2.charAt(str2.length() - 1));

        char[] ch = str2.toCharArray();
        for (char c : ch) {
            System.out.println(c);
        }

        /* if(str.equalsIgnoreCase(str2)) {
            System.out.println("both string are equal");
        } else {
            System.out.println("both string are not equal");
        } */
    }
}