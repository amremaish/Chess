package Character;

import chessgame.Cell;
import static chessgame.Cell.AvailableMovingColor;
import static chessgame.Cell.KillColor;
import chessgame.ChessGame;
import static chessgame.ChessGame.cell;

public class rook implements Character {

    private int AvailableX;
    private int AvailableY;
    private boolean AvailableKilling[][];
    boolean AvailableMoving[][];
    private boolean setOngraphic;

    public rook(boolean setOngraphic) {
        this.setOngraphic = setOngraphic;
        AvailableKilling = new boolean[8][8];
        AvailableMoving = new boolean[8][8];
    }

    @Override
    public boolean[][] setDirections(int x, int y) {
        RookMoving(x, y);
        return AvailableMoving;
    }

    @Override
    public boolean[][] setKillOrNokill(int x, int y) {
        return AvailableKilling;
    }

    public void RookMoving(int x, int y) {
        moveToUp(x, y);
        moveToDown(x, y);
        moveToRight(x, y);
        moveToLeft(x, y);
    }

    public void moveToUp(int x, int y) {
        this.AvailableX = x;
        this.AvailableY = y;
        AvailableX--;
        // move to up 
        while (AvailableX >= 0) {
            if (cell[x][y].getCharacterName().charAt(0) == cell[AvailableX][AvailableY].getCharacterName().charAt(0)) {
                break;
            }
            if (!cell[AvailableX][AvailableY].getCharacterName().equals("NULL")) {
                if (setOngraphic) {
                    ChessGame.cell[AvailableX][AvailableY].setRectFillColor(KillColor);
                }
                AvailableKilling[AvailableX][AvailableY] = true;
                break;
            }
            if (setOngraphic) {
                ChessGame.cell[AvailableX][AvailableY].setRectFillColor(AvailableMovingColor);
            }
            AvailableMoving[AvailableX][AvailableY] = true;
            AvailableX--;

        }

    }

    public void moveToDown(int x, int y) {
        this.AvailableX = x;
        this.AvailableY = y;
        AvailableX++;
        // move to Down 
        while (AvailableX <= 7) {
            if (cell[x][y].getCharacterName().charAt(0) == cell[AvailableX][AvailableY].getCharacterName().charAt(0)) {
                break;
            }
            if (!cell[AvailableX][AvailableY].getCharacterName().equals("NULL")) {
                if (setOngraphic) {
                    ChessGame.cell[AvailableX][AvailableY].setRectFillColor(KillColor);
                }
                AvailableKilling[AvailableX][AvailableY] = true;
                break;
            }
            if (setOngraphic) {
                ChessGame.cell[AvailableX][AvailableY].setRectFillColor(AvailableMovingColor);
            }
            AvailableMoving[AvailableX][AvailableY] = true;
            AvailableX++;
        }
    }

    public void moveToRight(int x, int y) {
        this.AvailableX = x;
        this.AvailableY = y;
        AvailableY--;
        // move to Left 
        while (AvailableY >= 0) {
            if (cell[x][y].getCharacterName().charAt(0) == cell[AvailableX][AvailableY].getCharacterName().charAt(0)) {
                break;
            }
            if (!cell[AvailableX][AvailableY].getCharacterName().equals("NULL")) {
                if (setOngraphic) {
                    ChessGame.cell[AvailableX][AvailableY].setRectFillColor(KillColor);
                }
                AvailableKilling[AvailableX][AvailableY] = true;
                break;
            }
            if (setOngraphic) {
                ChessGame.cell[AvailableX][AvailableY].setRectFillColor(AvailableMovingColor);
            }
            AvailableMoving[AvailableX][AvailableY] = true;
            AvailableY--;
        }
    }

    public void moveToLeft(int x, int y) {
        this.AvailableX = x;
        this.AvailableY = y;
        AvailableY++;
        // move to right 
        while (AvailableY <= 7) {
            if (cell[x][y].getCharacterName().charAt(0) == cell[AvailableX][AvailableY].getCharacterName().charAt(0)) {
                break;
            }
            if (!cell[AvailableX][AvailableY].getCharacterName().equals("NULL")) {
                if (setOngraphic) {
                    ChessGame.cell[AvailableX][AvailableY].setRectFillColor(KillColor);
                }
                AvailableKilling[AvailableX][AvailableY] = true;
                break;
            }
            if (setOngraphic) {
                ChessGame.cell[AvailableX][AvailableY].setRectFillColor(AvailableMovingColor);
            }
            AvailableMoving[AvailableX][AvailableY] = true;
            AvailableY++;
        }
    }

    public boolean[][] getAvailableKilling() {
        return AvailableKilling;
    }

    public void setAvailableKilling(boolean[][] AvailableKilling) {
        this.AvailableKilling = AvailableKilling;
    }

    public boolean[][] getAvailableMoving() {
        return AvailableMoving;
    }

    public void setAvailableMoving(boolean[][] AvailableMoving) {
        this.AvailableMoving = AvailableMoving;
    }
}
