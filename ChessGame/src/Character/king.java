package Character;

import chessgame.Cell;
import static chessgame.Cell.AvailableMovingColor;
import chessgame.ChessGame;
import static chessgame.ChessGame.cell;

public class king implements Character {

    private boolean AvailableKilling[][] = new boolean[8][8];
    boolean AvailableMoving[][] = new boolean[8][8];
    private boolean setOngraphic;
    
    public king(boolean setOngraphic) {
        this.setOngraphic = setOngraphic;
    }

    @Override
    public boolean[][] setDirections(int x, int y) {
        this.setOngraphic = setOngraphic;
        setDirectionForCell(x, y, x - 1, y - 1);
        setDirectionForCell(x, y, x - 1, y);
        setDirectionForCell(x, y, x - 1, y + 1);
        setDirectionForCell(x, y, x, y + 1);
        setDirectionForCell(x, y, x + 1, y + 1);
        setDirectionForCell(x, y, x + 1, y);
        setDirectionForCell(x, y, x + 1, y - 1);
        setDirectionForCell(x, y, x, y - 1);

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
                    AvailableKilling[x][y] = true;
                    if (setOngraphic) {
                        ChessGame.cell[x][y].setRectFillColor(Cell.KillColor);
                    }
                }
            }

        } catch (Exception e) {

        }

        return AvailableMoving;
    }

}
