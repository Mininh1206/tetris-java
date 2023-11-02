package engine.base;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BasicControllerM<MovementsTypes> implements Runnable {

    protected volatile boolean running;

    protected Queue<MovementsTypes> movements;

    public BasicControllerM() {
        movements = new LinkedList<>();
    }

    /**
     * Add the movement to que Controller Queue
     * @param movement is the movement that will be added
     * @return false if it doesn't have any space in memory
     */
    public synchronized boolean addMovement(MovementsTypes movement) {
        boolean success = movements.add(movement);

        notifyAll();

        return success;
    }

    public synchronized Thread start() {
        running = true;

        Thread thread = new Thread(this, "ControllerThread");
        thread.start();

        return thread;
    }

    public synchronized void stop() {
        running = false;

        notifyAll();
    }
    
}
