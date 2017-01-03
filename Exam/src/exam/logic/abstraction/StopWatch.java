package exam.logic.abstraction;

public class StopWatch extends Thread {

    private long startTime;

    public void startThread() {
        this.startTime = System.currentTimeMillis();
        run();
        this.start();
    }

    private int[] getTime() {
        long milliTime = System.currentTimeMillis() - this.startTime;
        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int)(milliTime / 3600000      );
        out[1] = (int)(milliTime / 60000        ) % 60;
        out[2] = (int)(milliTime / 1000         ) % 60;
        out[3] = (int)(milliTime)                 % 1000;
        return out;
    }

    public int getMinute() {
        return getTime()[1];
    }

    public int getSecond() {
        return getTime()[2];
    }

    public int getMilliSeconds() {
        return getTime()[3];
    }

    public void reset() {
        this.startTime = System.currentTimeMillis();
    }
}