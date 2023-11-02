package engine.base;

import java.awt.Graphics;

public abstract class DrawerM implements Runnable {
    protected volatile Graphics graphics;

    public DrawerM(Graphics graphics) {
        this.graphics = graphics;
    }

    protected volatile boolean running;

    public void draw() {

    }

    public void drawFPS(float fps) {

    }

    public synchronized Thread start() {
        running = true;

        Thread thread = new Thread(this, "DrawerThread");
        thread.start();

        return thread;
    }

    public synchronized void stop() {
        running = false;

        notifyAll();
    }
}
 