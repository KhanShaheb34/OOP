package Synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SyncChecker WithSync = new SyncChecker(1, true);
        SyncChecker WithSync2 = new SyncChecker(-1, true);

        SyncChecker WithBool = new SyncChecker(1, false);
        SyncChecker WithBool2 = new SyncChecker(-1, false);

        Thread WithSyncThread = new Thread(WithSync);
        Thread WithSyncThread2 = new Thread(WithSync2);
        Thread WithBoolThread = new Thread(WithBool);
        Thread WithBoolThread2 = new Thread(WithBool2);

        System.out.println("Before Thread With Sync: " + SyncChecker.num);
        WithSyncThread.start();
        WithSyncThread2.start();
        WithSyncThread.join();
        WithSyncThread2.join();
        System.out.println("After Thread With Sync: " + SyncChecker.num);

        System.out.println("Before Thread With Bool: " + SyncChecker.num);
        WithBoolThread.start();
        WithBoolThread2.start();
        WithBoolThread.join();
        WithBoolThread2.join();
        System.out.println("After Thread With Bool: " + SyncChecker.num);
    }
}
