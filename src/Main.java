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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext context = canvas.getGraphicsContext2D();

        Board board = new Board(WIDTH, HEIGHT);
        GameLoop gameLoop = new GameLoop(board, context);

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            Snake snake = board.getSnake();
            switch (e.getCode()) {
                case UP:
                    snake.setHorizontalVelocity(0);
                    snake.setVerticalVelocity(-1);
                    break;
                case DOWN:
                    snake.setHorizontalVelocity(0);
                    snake.setVerticalVelocity(1);
                    break;
                case LEFT:
                    snake.setHorizontalVelocity(-1);
                    snake.setVerticalVelocity(0);
                    break;
                case RIGHT:
                    snake.setHorizontalVelocity(1);
                    snake.setVerticalVelocity(0);
                    break;
                case ENTER:

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
