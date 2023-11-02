package components;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import engine.base.DrawerM;

public class TetrisDrawer extends DrawerM {
    public TetrisDrawer(Graphics graphics) {
        super(graphics);
    }

    @Override
    public void draw() {
        Random r = new Random();
        
        graphics.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        
        graphics.fillRect(100, 100, 100, 100);
    }

    @Override
    public void run() {
        while(running) {
            draw();
        }
    }
    
}
