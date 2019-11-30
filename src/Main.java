import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Board;
import model.GameLoop;
import model.Snake;

public class Main extends Application {

    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    private Board board;
    private GameLoop gameLoop;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext context = canvas.getGraphicsContext2D();

        board = new Board(WIDTH, HEIGHT);
        gameLoop = new GameLoop(board, context);

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            Snake snake = board.getSnake();
            switch (e.getCode()) {
                case UP:
                    snake.moveUp();
                    break;
                case DOWN:
                    snake.moveDown();
                    break;
                case LEFT:
                    snake.moveLeft();
                    break;
                case RIGHT:
                    snake.moveRight();
                    break;
                case ENTER:
                    if (!(board.getSnake().isSafe())) {
                        board = new Board(WIDTH, HEIGHT);
                        gameLoop = new GameLoop(board, context);
                        (new Thread(gameLoop)).start();
                    }
            }
        });

        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        (new Thread(gameLoop)).start();
    }
}
