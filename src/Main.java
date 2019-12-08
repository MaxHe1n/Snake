import ai.Simulator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Board;
import model.GameLoop;

public class Main extends Application {

    private final boolean simMode = true;
    private final String title = "Snake";
    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private Canvas canvas;
    private GraphicsContext context;
    private GameLoop gameLoop;
    Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        canvas = new Canvas(WIDTH, HEIGHT);
        context = canvas.getGraphicsContext2D();
        setUpGameLogic();

        root.getChildren().add(canvas);

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
        board = new Board(WIDTH, HEIGHT);
        if (simMode) {
            Simulator sim = new Simulator(board);
            gameLoop = new GameLoop(board, sim, context);
        } else {
            canvas.setFocusTraversable(true);
            canvas.setOnKeyPressed(new KeyHandler(this));
            gameLoop = new GameLoop(board, null, context);
        }
    }
}
