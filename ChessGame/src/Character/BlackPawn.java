package Character;

import chessgame.*;
import static chessgame.Cell.AvailableMovingColor;

public class BlackPawn implements Character {

    private boolean setOngraphic;

    public BlackPawn(boolean setOngraphic) {
        this.setOngraphic = setOngraphic;

    }

    @Override
    public boolean[][] setDirections(int x, int y) {
        boolean AvailableMoving[][] = new boolean[8][8];
        if (!ChessGame.cell[x - 1][y].getCharacterName().equals("NULL")) {
            return AvailableMoving;
        }
        if (x == 6 && (ChessGame.cell[x - 2][y].getCharacterName().equals("NULL"))) {
            AvailableMoving[x - 1][y] = true;
            AvailableMoving[x - 2][y] = true;
            if (setOngraphic) {
                ChessGame.cell[x - 1][y].setRectFillColor(AvailableMovingColor);
                ChessGame.cell[x - 2][y].setRectFillColor(AvailableMovingColor);
            }
        } else {
            AvailableMoving[x - 1][y] = true;
            if (setOngraphic) {
                ChessGame.cell[x - 1][y].setRectFillColor(AvailableMovingColor);
            }
        }
        return AvailableMoving;
    }

    @Override
    public boolean[][] setKillOrNokill(int x, int y) {
        boolean AvailableKilling[][] = new boolean[8][8];
        try {
            // check if enemy in Left
            if ((x >= 1 && y >= 1) && !ChessGame.cell[x - 1][y - 1].getCharacterName().equals("NULL")
                    && ((ChessGame.cell[x][y].getCharacterName().charAt(0) != ChessGame.cell[x - 1][y - 1].getCharacterName().charAt(0)))) {
                AvailableKilling[x - 1][y - 1] = true;
                if (setOngraphic) {
                    ChessGame.cell[x - 1][y - 1].setRectFillColor(Cell.KillColor);
                }
            }
            // check if enemy in Right
            if ((x >= 1 && y <= 7) && !ChessGame.cell[x - 1][y + 1].getCharacterName().equals("NULL")
                    && ((ChessGame.cell[x][y].getCharacterName().charAt(0) != ChessGame.cell[x - 1][y + 1].getCharacterName().charAt(0)))) {
                AvailableKilling[x - 1][y + 1] = true;
                if (setOngraphic) {
                    ChessGame.cell[x - 1][y + 1].setRectFillColor(Cell.KillColor);
                }
            }
        } catch (Exception e) {

        }
        return AvailableKilling;
    }

}
