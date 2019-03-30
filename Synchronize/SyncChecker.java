package Synchronization;

public class SyncChecker implements Runnable {
    static int num = 0;
    private int adder;
    private boolean useSynch;
    private static boolean methodBusy = false;

    SyncChecker(int adder, boolean useSynch) {
        this.adder = adder;
        this.useSynch = useSynch;
    }

    private synchronized void SyncAdd() {
        num += adder;
    }

    private void NonSyncAdd() {
        methodBusy = true;
        num += adder;
        methodBusy = false;
    }


    @Override
    public void run() {
        if (useSynch){
            for (int i = 0; i < 10; i++) {
                SyncAdd();
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if(methodBusy){
                    i--;
                }
                else NonSyncAdd();
            }
        }


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
