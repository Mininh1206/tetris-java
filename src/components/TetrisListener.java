package components;

import java.awt.event.KeyEvent;

import engine.base.ListenerM;
import engine.main.AppM;
import types.Movements;

public class TetrisListener extends ListenerM {
    @Override
    public void keyPressed(KeyEvent e) {
        synchronized(this) {
            switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                AppM.getAppM().getController().addMovement(Movements.FALL);
                break;
            case KeyEvent.VK_DOWN:
                AppM.getAppM().getController().addMovement(Movements.DOWN);
                notifyAll();
                break;
            case KeyEvent.VK_LEFT:
                AppM.getAppM().getController().addMovement(Movements.LEFT);
                notifyAll();
                break;
            case KeyEvent.VK_RIGHT:
                AppM.getAppM().getController().addMovement(Movements.RIGHT);
                notifyAll();
                break;
            case KeyEvent.VK_UP:
                AppM.getAppM().getController().addMovement(Movements.ROTATE);
                notifyAll();
                break;
            }

            notifyAll();
        }
    }
}
