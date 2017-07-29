package chessgame;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChessGame extends Application {

    static int Width = 700  ;
    static int Hieght = 700;
    public static Cell cell[][];
 
    private Parent PiantGrid() {
        Pane root = new Pane();
        cell = new Cell[8][8];
        root.setPrefSize(Width, Hieght);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cell[i][j] = new Cell();
                cell[i][j].setX(i);
                cell[i][j].setY(j);
                cell[i][j].setCharacterIndex();
                cell[i][j].setTranslateX(j * (Width / 7.88889));
                cell[i][j].setTranslateY(i * (Hieght / 7.88889));
                cell[i][j].Cell(true);
                root.getChildren().add(cell[i][j]);
            }
        }
        return root;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(PiantGrid(), Width, Hieght));
        stage.setResizable(false);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}
