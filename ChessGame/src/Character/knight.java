/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Character;

import chessgame.Cell;
import static chessgame.Cell.AvailableMovingColor;
import chessgame.ChessGame;
import static chessgame.ChessGame.cell;

/**
 *
 * @author Amr
 */
public class knight implements Character {

    private boolean AvailableKilling[][] = new boolean[8][8];
    boolean AvailableMoving[][] = new boolean[8][8];
    private boolean setOngraphic;

    public knight(boolean setOngraphic) {
        this.setOngraphic = setOngraphic;

    }
    @Override
    public boolean[][] setDirections(int x, int y) {
        this.setOngraphic = setOngraphic;
        setDirectionForCell(x, y, x - 2, y - 1);
        setDirectionForCell(x, y, x - 1, y - 2);
        setDirectionForCell(x, y, x + 1, y - 2);
        setDirectionForCell(x, y, x + 2, y - 1);
        setDirectionForCell(x, y, x + 2, y + 1);
        setDirectionForCell(x, y, x + 1, y + 2);
        setDirectionForCell(x, y, x - 1, y + 2);
        setDirectionForCell(x, y, x - 2, y + 1);
        return AvailableMoving;
    }

    @Override
    public boolean[][] setKillOrNokill(int x, int y) {
        return AvailableKilling;
    }

    private boolean[][] setDirectionForCell(int OriginalyX, int OriginalyY, int x, int y) {

        try {
            if (cell[OriginalyX][OriginalyY].getCharacterName().charAt(0) != cell[x][y].getCharacterName().charAt(0)) {
                if (cell[x][y].getCharacterName().equals("NULL")) {
                    AvailableMoving[x][y] = true;
                    if (setOngraphic) {
                        ChessGame.cell[x][y].setRectFillColor(AvailableMovingColor);
                    }
                } else {
                    if (setOngraphic) {
                        AvailableKilling[x][y] = true;
                    }
                    ChessGame.cell[x][y].setRectFillColor(Cell.KillColor);
                }
            }

        } catch (Exception e) {

        }

        return AvailableMoving;
    }
}
