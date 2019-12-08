import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Snake;

class KeyHandler implements EventHandler<KeyEvent> {

    private Main main;

    KeyHandler(Main main) {
        this.main = main;
    }

    @Override
    public void handle(KeyEvent event) {
        Snake snake = main.board.getSnake();
        switch (event.getCode()) {
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
                if (!(main.board.getSnake().isSafe())) {
                    main.reset();
                }
        }
    }
}
