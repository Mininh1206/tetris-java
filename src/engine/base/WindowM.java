package engine.base;

import javax.swing.JFrame;

public class WindowM extends JFrame{
    public WindowM(int width, int height) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    public void setListeners(ListenerM listener) {
        addKeyListener(listener);
        addWindowListener(listener);
    }

    public void start() {
        setVisible(true);
    }
}
