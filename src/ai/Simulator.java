package ai;

import model.Board;
import model.Point;

import java.util.List;
import java.util.Set;

public class Simulator {

    private Board board;
    private Graph graph;
    private int index;
    private List<Point> path;

    public Simulator(Board board) {
        this.board = board;
        this.graph = generateGraph();
        this.index = -1;
    }

    public void getMoveGreedy() {
        Point food = board.getFood().getPosition();
        Point snake = board.getSnake().getHead();

        if (snake.getXCord() < food.getXCord()) {
            board.getSnake().moveRight();
        } else if (snake.getXCord() > food.getXCord()) {
            board.getSnake().moveRight();
        } else if (snake.getYCord() < food.getYCord()) {
            board.getSnake().moveDown();
        } else if (snake.getYCord() > food.getYCord()) {
            board.getSnake().moveDown();
        }
    }

    public void getMoveSearch() {

        if (index == -2) {
            return;
        }

        if (index == -1) {
            BFS bfs = new BFS();
            path = bfs.search(graph, board.getSnake().getHead(), board.getFood().getPosition());
            index = path.size()-2;
            resetGraph();
        }

        if(path.get(index).isRightOf(board, board.getSnake().getHead())) {
            board.getSnake().moveRight();
        } else if (path.get(index).isLeftOf(board, board.getSnake().getHead())) {
            board.getSnake().moveLeft();
        } else if(path.get(index).isBelowOf(board, board.getSnake().getHead())) {
            board.getSnake().moveDown();
        } else {
            board.getSnake().moveUp();
        }

        index--;
    }

    private Graph generateGraph() {
        Point p[][] = new Point[board.getWidth()][board.getHeight()];
        Graph<Point> g = new Graph<>();
        for (int x = 0; x < board.getWidth(); ++x) {
            for (int y = 0; y < board.getWidth(); ++y) {
                p[x][y] = new Point(x,y,false);
            }
        }
        for (int x = 0; x < board.getWidth(); ++x) {
            for (int y = 0; y < board.getWidth(); ++y) {
                g.addEdge(p[x][y], p[(x + board.getWidth()) % board.getWidth()][(y - 1 + board.getHeight()) % board.getHeight()], false);
                g.addEdge(p[x][y], p[(x + 1 + board.getWidth()) % board.getWidth()][(y + board.getHeight()) % board.getHeight()], false);
                g.addEdge(p[x][y], p[(x + board.getWidth()) % board.getWidth()][(y + 1 + board.getHeight()) % board.getHeight()], false);
                g.addEdge(p[x][y], p[(x - 1 + board.getWidth()) % board.getWidth()][(y + board.getHeight()) % board.getHeight()], false);
            }
        }
        return g;
    }

    private void resetGraph() {
        for(Point p : (Set<Point>) graph.map.keySet()) {
            p.setDiscovered(false);
            p.setParent(null);
        }
    }

}
