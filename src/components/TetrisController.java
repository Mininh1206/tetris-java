package components;

import engine.base.BasicControllerM;
import types.Movements;

public class TetrisController extends BasicControllerM<Movements> {


    @Override
    public void run() {
        while(running) {
            synchronized(this) {
                if(movements.isEmpty()) {
                   try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } 
                }

                if(!movements.isEmpty()) {
                    System.out.println(movements.poll());
                }
            }
        }
    }
}
