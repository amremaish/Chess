package chessgame;

import Character.BlackPawn;
import ChessAlgorithm.ComputerStep;
import Character.WhitePawn;
import Character.bishop;
import Character.king;
import Character.knight;
import Character.queen;
import Character.rook;
import static chessgame.ChessGame.Hieght;
import static chessgame.ChessGame.Width;
import static chessgame.ChessGame.cell;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Pane {

    static int lastX, lastY;
    //
    private static Color ColorMapOdd = Color.WHITE;
    static Color ColorMapEven = Color.web("#084B8A");
    static Color SelectedCellColor = Color.web("#04B4AE");
    public static Color KillColor = Color.PINK;
    public static Color AvailableMovingColor = Color.web("#04B4AE");
    static int Background = -1;
    public static boolean AvailableMoving[][] = new boolean[8][8];
    public static boolean AvailableKilling[][] = new boolean[8][8];
    static boolean isSelected;
    public static boolean playerTurn;       // player 1 (black) =  true   player 2 (white)= false
    static boolean click;
    //-------------------------------    
    private String CharacterIndex;
    private String CharacterName = "NULL";
    private Image image;
    private Color colorCell;
    private Rectangle rect;
    private int x;
    private int y;

    public void Cell(boolean StartCharacterName) {
        // Draw Rectangle
        rect = new Rectangle(Width / 7.88889, Width / 7.88889);
        rect.setStrokeWidth(5);
        rect.setStroke(Color.BLACK);
        colorCell = setBackgroundColor();
        rect.setFill(colorCell);
        // Draw Image
        try {
            image = new Image("sprite_sheet/" + this.CharacterIndex + ".png");
            ImageView imageView = new ImageView(image);
            imageView.setX(10);
            imageView.setY(10);
            getChildren().addAll(rect, imageView);
            if (StartCharacterName) {
                // set character name ; 
                setCharacterName();
            }
        } catch (Exception e) {
            getChildren().add(rect);
        }
        // Start Mouse Handler 
        MouseHandler();

    }

    private Color setBackgroundColor() {
        Background++;
        if ((Background / 8) % 2 == 0) {
            if (Background % 2 == 1) {
                return ColorMapEven;
            } else {
                return ColorMapOdd;
            }
        } else if (Background % 2 == 0) {
            return ColorMapEven;
        } else {
            return ColorMapOdd;
        }
    }

    private boolean MoveCharacterFromCellToAnotherCell() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((AvailableMoving[i][j] || AvailableKilling[i][j]) && x == i && y == j) {    // if Find clicked
                    // this Pane (x and y) will equal  Pane (prevoius X and prevoius Y ) the information
                    cell[i][j].CharacterName = cell[lastX][lastY].CharacterName;
                    cell[i][j].CharacterIndex = cell[lastX][lastY].CharacterIndex;
                    cell[i][j].Background = (cell[i][j].x * 8) + (cell[i][j].y) - 1;
                    cell[i][j].Cell(false);

                    // Clear Data for previous Data      
                    cell[lastX][lastY].CharacterIndex = null;
                    cell[lastX][lastY].CharacterName = "NULL";
                    cell[lastX][lastY].Background = (cell[lastX][lastY].x * 8) + (cell[lastX][lastY].y) - 1;  // To  set Color Cell
                    cell[lastX][lastY].Cell(false);       // set Again Character name ? (no) beacuse it sets before 

                    ClearAvailableMoving();
                    return true;
                }
            }
        }
        ClearAvailableMoving();
        if (cell[lastX][lastY].CharacterName.equals(cell[x][y].CharacterName)) {
            return false;
        }

        return false;
    }

    private void ClearAvailableMoving() {
        // clear All Selected color  
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (cell[i][j].colorCell != ColorMapOdd || cell[i][j].colorCell != ColorMapEven) {
                    ChessGame.cell[i][j].rect.setFill(cell[i][j].colorCell);
                    AvailableMoving[i][j] = false;
                }
            }
        }

    }

    public void MouseHandler() {
        //MouseAction
        this.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.PRIMARY) {

                if (isSelected) {
                    System.out.println("OK... it moved ");
                    isSelected = false;
                    click = false;
                    if (!MoveCharacterFromCellToAnotherCell()) {
                        System.out.println("NO... far away click ");
                        // if the Character actually moved 
                        playerTurn = !playerTurn;

                    } else {
                        System.out.println("OK... it's computer step ");
                        new ComputerStep(cell);

                    }
                    return;
                }
                if (click) {
                    rect.setFill(colorCell);
                    ClearAvailableMoving();
                    click = false;
                    isSelected = false;
                    System.out.println("OK... UnSelected");
                    return;
                }
                if (cell[x][y].CharacterName.equals("NULL")) {
                    click = false;
                    return;
                }

                /*
                *  if you clicked to Character  
                *
                 */
                isSelected = true;
                rect.setFill(SelectedCellColor);
                CopyIndex(x, y);
                if (cell[x][y].CharacterName.equals("blackPawn")) {         //   this Class
                    AvailableMoving = new BlackPawn(true).setDirections(x, y);
                    AvailableKilling = new BlackPawn(true).setKillOrNokill(x, y);
                    System.out.println("OK..it's blackPawn");
                } else if (cell[x][y].CharacterName.equals("whitePawn")) {
                    AvailableMoving = new WhitePawn(true).setDirections(x, y);
                    AvailableKilling = new WhitePawn(true).setKillOrNokill(x, y);
                    System.out.println("OK..it's WhitePawn");
                } else if (cell[x][y].CharacterName.contains("Rook")) {
                    rook rook = new rook(true);
                    AvailableMoving = rook.setDirections(x, y);
                    AvailableKilling = rook.setKillOrNokill(x, y);
                    System.out.println("OK..it's Rook");
                } else if (cell[x][y].CharacterName.contains("Bishop")) {
                    bishop bishop = new bishop(true);
                    AvailableMoving = bishop.setDirections(x, y);
                    AvailableKilling = bishop.setKillOrNokill(x, y);
                    System.out.println("OK..it's bishop");
                } else if (cell[x][y].CharacterName.contains("Knight")) {
                    if (playerTurn == true && cell[x][y].CharacterName.charAt(0) == 'b') {
                        knight knight = new knight(true);
                        AvailableMoving = knight.setDirections(x, y);
                        AvailableKilling = knight.setKillOrNokill(x, y);
                    } else {
                        knight knight = new knight(true);
                        AvailableMoving = knight.setDirections(x, y);
                        AvailableKilling = knight.setKillOrNokill(x, y);
                    }
                    System.out.println("OK..it's Knight");
                } else if (cell[x][y].CharacterName.contains("King")) {
                    king king = new king(true);
                    AvailableMoving = king.setDirections(x, y);
                    AvailableKilling = king.setKillOrNokill(x, y);
                    System.out.println("OK..it's King");

                } else if (cell[x][y].CharacterName.contains("Queen")) {
                    queen queen = new queen(true);
                    AvailableMoving = queen.setDirections(x, y);
                    AvailableKilling = queen.setKillOrNokill(x, y);
                    System.out.println("OK..it's Queen");
                }
                click = true;
            }

        });
    }

    public void setCharacterIndex() {
        if (x == 1 && y <= 7) {
            this.CharacterIndex = "10";
        } else if (x == 6 && y <= 7) {
            this.CharacterIndex = "60";
        } else {
            this.CharacterIndex = (x + "" + y);
        }
    }

    private void setCharacterName() {
        if (CharacterIndex.equals("77") || CharacterIndex.equals("70")) {
            //blackRook  

            CharacterName = NamesMap.blackRook.toString();
        } else if (CharacterIndex.equals("07") || CharacterIndex.equals("00")) {
            //whiteRook  
            CharacterName = NamesMap.whiteRook.toString();
        } else if (CharacterIndex.equals("76") || CharacterIndex.equals("71")) {
            // blackKnight 
            CharacterName = NamesMap.blackKnight.toString();
        } else if (CharacterIndex.equals("06") || CharacterIndex.equals("01")) {
            // whiteKnight
            CharacterName = NamesMap.whiteKnight.toString();
        } else if (CharacterIndex.equals("75") || CharacterIndex.equals("72")) {
            // blackBishop 
            CharacterName = NamesMap.blackBishop.toString();
        } else if (CharacterIndex.equals("05") || CharacterIndex.equals("02")) {
            // whiteBishop 
            CharacterName = NamesMap.whiteBishop.toString();
        } else if (CharacterIndex.equals("74")) {
            // blackKing 
            CharacterName = NamesMap.blackKing.toString();
        } else if (CharacterIndex.equals("04")) {
            // WhiteKing 
            CharacterName = NamesMap.whiteKing.toString();
        } else if (CharacterIndex.equals("73")) {
            // blackQueen
            CharacterName = NamesMap.blackQueen.toString();
        } else if (CharacterIndex.equals("03")) {
            // WhiteQueen
            CharacterName = NamesMap.whiteQueen.toString();
        } else if ((x == 6 && y <= 7)) {
            //blackPawn 
            CharacterName = NamesMap.blackPawn.toString();
        } else if ((x == 1 && y <= 7)) {
            //whitePawn 
            CharacterName = NamesMap.whitePawn.toString();
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRectFillColor(Color color) {
        rect.setFill(color);
    }

    public static void CopyIndex(int x, int y) {
        lastX = x;
        lastY = y;
    }

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String CharacterName) {
        this.CharacterName = CharacterName;
    }

}
