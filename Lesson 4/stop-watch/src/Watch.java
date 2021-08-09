public class Watch {
    public long startTime = 0;
    public long endTime = 0;
    public boolean isRunning = false;

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.isRunning = true;
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
        this.isRunning =  false;
    }
    public long getElapsedTime() {
        long elapsed;
        if (isRunning) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (endTime - startTime);
        }
        return elapsed;
    }
}
