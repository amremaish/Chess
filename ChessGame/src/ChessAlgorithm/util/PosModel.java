/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAlgorithm.util;

import chessgame.Cell;
import chessgame.NamesMap;
import java.util.ArrayList;

/**
 *
 * @author Amr
 */
public class PosModel {

    private Cell[][] map;
    // Player cells            ( black )
    private Cell PlayerKing, PlayerQueen;   // player King , Queen 
    private ArrayList<Cell> PlayerKnight;
    private ArrayList<Cell> PlayerBishop;
    private ArrayList<Cell> PlayerRook;
    private ArrayList<Cell> PlayerPawns;

    // computer cells          ( White )
    private Cell ComputerKing, ComputerQueen;  // computer Queen , king
    private ArrayList<Cell> ComputerBishop;
    private ArrayList<Cell> ComputerKnight;
    private ArrayList<Cell> ComputerRook;
    private ArrayList<Cell> ComputerPawns;

    public PosModel(Cell[][] map) {
        this.map = map;
        setCells();
    }

    private void setCells() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].getCharacterName().equals("NULL")) { // if empty
                    continue;
                }
                //-------------------------------- initialize player pbject  --------------------------------------------------
                if (map[i][j].getCharacterName().equals(NamesMap.blackKing.toString())) {
                    PlayerKing = map[i][j];
                } else if (map[i][j].getCharacterName().equals(NamesMap.blackQueen.toString())) {
                    PlayerQueen = map[i][j];
                } else if (map[i][j].getCharacterName().equals(NamesMap.blackKnight.toString())) {
                    PlayerKnight = initializeObject(PlayerKnight);
                    PlayerKnight.add(map[i][j]);
                } else if (map[i][j].getCharacterName().equals(NamesMap.blackBishop.toString())) {
                    PlayerBishop = initializeObject(PlayerBishop);
                    PlayerBishop.add(map[i][j]);
                } else if (map[i][j].getCharacterName().equals(NamesMap.blackRook.toString())) {
                    PlayerRook = initializeObject(PlayerRook);
                    PlayerRook.add(map[i][j]);
                } else if (map[i][j].getCharacterName().equals(NamesMap.blackPawn.toString())) {
                    PlayerPawns = initializeObject(PlayerPawns);
                    PlayerPawns.add(map[i][j]);
                }
                //-------------------------------- initialize Computer pbject  --------------------------------------------------

                if (map[i][j].getCharacterName().equals(NamesMap.whiteKing.toString())) {
                    ComputerKing = map[i][j];
                } else if (map[i][j].getCharacterName().equals(NamesMap.whiteQueen.toString())) {
                    ComputerQueen = map[i][j];
                } else if (map[i][j].getCharacterName().equals(NamesMap.whiteKnight.toString())) {
                    ComputerKnight = initializeObject(ComputerKnight);
                    ComputerKnight.add(map[i][j]);
                } else if (map[i][j].getCharacterName().equals(NamesMap.whiteRook.toString())) {
                    ComputerRook = initializeObject(ComputerRook);
                    ComputerRook.add(map[i][j]);
                } else if (map[i][j].getCharacterName().equals(NamesMap.whitePawn.toString())) {
                    ComputerPawns = initializeObject(ComputerPawns);
                    ComputerPawns.add(map[i][j]);
                }
            }
        }
    }

    private ArrayList<Cell> initializeObject(ArrayList<Cell> cell) {
        if (cell == null) {
            cell = new ArrayList<>();
        }
        return cell;
    }

    public Cell[][] getMap() {
        return map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }

    public Cell getPlayerKing() {
        return PlayerKing;
    }

    public void setPlayerKing(Cell PlayerKing) {
        this.PlayerKing = PlayerKing;
    }

    public Cell getPlayerQueen() {
        return PlayerQueen;
    }

    public void setPlayerQueen(Cell PlayerQueen) {
        this.PlayerQueen = PlayerQueen;
    }

    public ArrayList<Cell> getPlayerKnight() {
        return PlayerKnight;
    }

    public void setPlayerKnight(ArrayList<Cell> PlayerKnight) {
        this.PlayerKnight = PlayerKnight;
    }

    public ArrayList<Cell> getPlayerBishop() {
        return PlayerBishop;
    }

    public void setPlayerBishop(ArrayList<Cell> PlayerBishop) {
        this.PlayerBishop = PlayerBishop;
    }

    public ArrayList<Cell> getPlayerRook() {
        return PlayerRook;
    }

    public void setPlayerRook(ArrayList<Cell> PlayerRook) {
        this.PlayerRook = PlayerRook;
    }

    public ArrayList<Cell> getPlayerPawns() {
        return PlayerPawns;
    }

    public void setPlayerPawns(ArrayList<Cell> PlayerPawns) {
        this.PlayerPawns = PlayerPawns;
    }

    public Cell getComputerKing() {
        return ComputerKing;
    }

    public void setComputerKing(Cell ComputerKing) {
        this.ComputerKing = ComputerKing;
    }

    public Cell getComputerQueen() {
        return ComputerQueen;
    }

    public void setComputerQueen(Cell ComputerQueen) {
        this.ComputerQueen = ComputerQueen;
    }

    public ArrayList<Cell> getComputerBishop() {
        return ComputerBishop;
    }

    public void setComputerBishop(ArrayList<Cell> ComputerBishop) {
        this.ComputerBishop = ComputerBishop;
    }

    public ArrayList<Cell> getComputerKnight() {
        return ComputerKnight;
    }

    public void setComputerKnight(ArrayList<Cell> ComputerKnight) {
        this.ComputerKnight = ComputerKnight;
    }

    public ArrayList<Cell> getComputerRook() {
        return ComputerRook;
    }

    public void setComputerRook(ArrayList<Cell> ComputerRook) {
        this.ComputerRook = ComputerRook;
    }

    public ArrayList<Cell> getComputerPawns() {
        return ComputerPawns;
    }

    public void setComputerPawns(ArrayList<Cell> ComputerPawns) {
        this.ComputerPawns = ComputerPawns;
    }

}
