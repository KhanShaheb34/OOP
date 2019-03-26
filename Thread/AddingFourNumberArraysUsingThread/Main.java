package MultiThreading;

public class Main {
    public static void main(String[] args) {
        int[] ara0 = new int[]{2, 4, 6, 2, 6, 2, 7, 2, 7, 4};
        int[] ara1 = new int[]{7,3,7,3,6,4,1,5,1,7};
        int[] ara2 = new int[]{8,4,23,6,2,6,4,7,1,4};
        int[] ara3 = new int[]{87,32,5,2,642,6,7,3,7,8};

        Threading first = new Threading(ara0, ara1, "First");
        Threading second = new Threading(ara2, ara3, "Second");

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        firstThread.start();
        secondThread.start();

        while (firstThread.isAlive() || secondThread.isAlive());

        for (int i = 0; i < 10; i++) {
            try{
                System.out.println(first.ans[i]+second.ans[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
