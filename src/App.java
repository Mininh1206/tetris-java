import components.TetrisController;
import components.TetrisDrawer;
import components.TetrisListener;
import engine.base.WindowM;
import engine.main.AppM;

public class App {
    public static void main(String[] args) throws Exception {
        WindowM window = new WindowM(500, 500);
        AppM.buildAppM(new TetrisController(), new TetrisListener(), window, new TetrisDrawer(window.getGraphics())).start();
    }
}
