package engine.main;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import engine.base.BasicControllerM;
import engine.base.DrawerM;
import engine.base.ListenerM;
import engine.base.WindowM;

public class AppM<C extends BasicControllerM, L extends ListenerM, W extends WindowM, D extends DrawerM> {
    private Thread[] threads;
    
    private C controller;
    public C getController() {
        return controller;
    }

    private L listener;
    private W window;
    private D drawer;

    private static AppM app;

    private AppM(C controller, L listener, W window, D drawer) {
        this.controller = controller;
        this.listener = listener;
        this.window = window;
        this.drawer = drawer;

        window.setListeners(listener);

        threads = new Thread[2];
    }

    public static AppM getAppM() {
        return app;
    }

    public static synchronized <C extends BasicControllerM, L extends ListenerM, W extends WindowM, D extends DrawerM> AppM<C, L, W, D> buildAppM(C controller, L listener, W window, D drawer) {
        if (app == null) {
            app = new AppM<C, L, W, D>(controller, listener, window, drawer);
        }

        return app;
    }

    public synchronized void start() {
        window.start();

        threads[0] = controller.start();
        threads[1] = drawer.start();
    }

    public synchronized void stop() {
        controller.stop();
        drawer.stop();

        window.dispose();
    }
}
