package MultiThreading;

public class Threading implements Runnable {

    private int[] ara1;
    private int[] ara2;

    int[] ans = new int[10];

    private String name;

    Threading(int[] ara1, int[] ara2, String name) {
        this.ara1 = ara1;
        this.ara2 = ara2;
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            ans[i] = ara1[i] + ara2[i];

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
