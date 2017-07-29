/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessAlgorithm;

import ChessAlgorithm.util.CharProperties;
import ChessAlgorithm.util.PosModel;
import chessgame.Cell;
import chessgame.NamesMap;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Amr
 */
public class ComputerStep {

    /*
    Note : computer is white  and player is Black   
     */
    private Cell[][] map;
    private PosModel posObject;
    private CharProperties dir;

    public ComputerStep(Cell[][] map) {
        this.dir = new CharProperties();
        this.map = map;
        this.posObject = new PosModel(map);
        int x = posObject.getPlayerQueen().getX();
        int y = posObject.getPlayerQueen().getY();
        print(dir.getQueenMoving(x, y));

    }

    private void print(boolean x[][]) {

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }

    }

}
