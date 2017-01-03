package exam.logic.abstraction;

public class StopWatch extends Thread {

    private long startTime;

    public void startThread() {
        this.startTime = System.currentTimeMillis();
        run();
        this.start();
    }

    private long getTime() {
        return System.currentTimeMillis() - this.startTime;
    }

    public int getHour() {
        return (int) (getTime() / 3600000);
    }

    public int getMinute() {
        return (int) (getTime() / 60000) % 60;
    }

    public int getSecond() {
        return (int) (getTime() / 1000) % 60;
    }

    public int getMilliSeconds() {
        return (int) getTime() % 1000;
    }

    public void reset() {
        this.startTime = System.currentTimeMillis();
    }
}