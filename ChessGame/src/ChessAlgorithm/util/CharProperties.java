/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAlgorithm.util;

import Character.BlackPawn;
import Character.WhitePawn;
import Character.bishop;
import Character.king;
import Character.knight;
import Character.queen;
import Character.rook;

/**
 *
 * @author Amr
 */
public class CharProperties {

    private rook rook;
    private bishop bishop;
    private knight knight;
    private king king;
    private queen queen;
    private BlackPawn BlackPawn;
    private WhitePawn WhitePawn;

    public CharProperties() {
        rook = new rook(false);
        bishop = new bishop(false);
        knight = new knight(false);
        king = new king(false);
        queen = new queen(false);
        BlackPawn = new BlackPawn(false);
        WhitePawn = new WhitePawn(false);
    }

    public boolean[][] getBlackPawnMoving(int x, int y) {
        return BlackPawn.setDirections(x, y);
    }

    public boolean[][] getBlackPawnkilling(int x, int y) {

        return BlackPawn.setKillOrNokill(x, y);
    }

    public boolean[][] getWhitePawnMoving(int x, int y) {

        return WhitePawn.setDirections(x, y);
    }

    public boolean[][] getWhitePawnkilling(int x, int y) {

        return WhitePawn.setKillOrNokill(x, y);
    }

    public boolean[][] getRookMoving(int x, int y) {
        return rook.setDirections(x, y);
    }

    public boolean[][] getRookkilling(int x, int y) {

        return rook.setKillOrNokill(x, y);
    }

    public boolean[][] getBishopMoving(int x, int y) {

        return bishop.setDirections(x, y);

    }

    public boolean[][] getBishopkilling(int x, int y) {

        return bishop.setKillOrNokill(x, y);
    }

    public boolean[][] getKnightMoving(int x, int y) {

        return knight.setDirections(x, y);

    }

    public boolean[][] getKnightkilling(int x, int y) {

        return knight.setKillOrNokill(x, y);
    }

    public boolean[][] getKingMoving(int x, int y) {

        return king.setDirections(x, y);

    }

    public boolean[][] getKingkilling(int x, int y) {

        return king.setKillOrNokill(x, y);
    }

    public boolean[][] getQueenMoving(int x, int y) {

        return queen.setDirections(x, y);

    }

    public boolean[][] getQueenkilling(int x, int y) {

        return queen.setKillOrNokill(x, y);
    }

}
