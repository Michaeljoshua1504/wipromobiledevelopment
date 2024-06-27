public class th{
    public static void printHelloworld() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(() -> printHelloworld());
        Thread th2 = new Thread(() -> System.out.println(2+2));


        Thread.sleep(3000); //wait
        th.start();
        th2.start();
    }
}