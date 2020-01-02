import view.View;
import ai.Simulator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Board;
import controler.GameLoop;

public class Main extends Application {

    private final boolean simMode = true;
    private final String title = "Snake";
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private View view;
    private GameLoop gameLoop;
    Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        view = new View(WIDTH, HEIGHT);
        setUpGameLogic();

        root.getChildren().add(view);

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle(title);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        (new Thread(gameLoop)).start();
    }

    void reset() {
        setUpGameLogic();
        (new Thread(gameLoop)).start();
    }

    private void setUpGameLogic() {
        board = new Board(WIDTH/10, HEIGHT/10);
        Simulator sim = null;
        if (simMode) {
            sim = new Simulator(board);
        } else {
            view.setFocusTraversable(true);
            view.setOnKeyPressed(new KeyHandler(this));
        }
        gameLoop = new GameLoop(board, sim, view);
    }
}
