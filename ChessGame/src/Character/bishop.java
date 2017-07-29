/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import static chessgame.Cell.AvailableMovingColor;
import static chessgame.Cell.KillColor;
import chessgame.ChessGame;
import static chessgame.ChessGame.cell;

/**
 *
 * @author Amr
 */
public class bishop implements Character {

    private int AvailableX;
    private int AvailableY;
    private boolean AvailableKilling[][];
    private boolean AvailableMoving[][];
    private boolean setOngraphic;

    public bishop(boolean setOngraphic) {
        this.setOngraphic = setOngraphic;
        AvailableKilling = new boolean[8][8];
        AvailableMoving = new boolean[8][8];
    }

    @Override
    public boolean[][] setDirections(int x, int y) {

        bishopMoving(x, y);
        return AvailableMoving;
    }

    @Override
    public boolean[][] setKillOrNokill(int x, int y) {
        return AvailableKilling;
    }

    public void bishopMoving(int x, int y) {
        TopRightMove(x, y);
        TopLeftMove(x, y);
        DownRightMove(x, y);
        DownLeftMove(x, y);
    }

    public void TopRightMove(int x, int y) {
        this.AvailableX = x;
        this.AvailableY = y;
        AvailableX--;
        AvailableY++;
        // move to Top-Right 
        while (AvailableX >= 0 && AvailableY <= 7) {
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
            AvailableY++;
        }
    }

    public void TopLeftMove(int x, int y) {
        this.AvailableX = x;
        this.AvailableY = y;

        AvailableX--;
        AvailableY--;
        // move to Top-Left 
        while (AvailableX >= 0 && AvailableY >= 0) {
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
            AvailableY--;
        }

    }

    public void DownRightMove(int x, int y) {
        // move to Down-Right 
        this.AvailableX = x;
        this.AvailableY = y;
        AvailableY++;
        AvailableX++;
        while (AvailableX <= 7 && AvailableY <= 7) {
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
            AvailableX++;
        }

    }

    public void DownLeftMove(int x, int y) {

        this.AvailableX = x;
        this.AvailableY = y;
        AvailableX++;
        AvailableY--;
        // move to Down-Left  
        while (AvailableX <= 7 && AvailableY >= 0) {
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
            AvailableX++;
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
