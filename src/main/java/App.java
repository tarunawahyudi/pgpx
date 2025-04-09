import controller.AppController;
import model.KeyModel;
import view.AppView;

import javax.swing.*;

class App extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppView view = new AppView();
            KeyModel model = new KeyModel();
            new AppController(view, model);
            view.setVisible(true);
        });
    }
}
