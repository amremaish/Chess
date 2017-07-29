package Character;

public class queen implements Character {

    private boolean AvailableKilling[][] = new boolean[8][8];
    boolean AvailableMoving[][] = new boolean[8][8];
    
    private boolean setOngraphic;

    public queen(boolean setOngraphic) {
        this.setOngraphic = setOngraphic;

    }
    @Override
    public boolean[][] setDirections(int x, int y ) {
        // queen = rook + bishop Moving
        
        // Get Rook Available Moving
        boolean AvailableRookMoving[][] = new boolean[8][8];
        boolean AvailableRookKilling[][] = new boolean[8][8];
        rook rook = new rook(setOngraphic);
        rook.RookMoving(x, y);
        AvailableRookMoving = rook.getAvailableMoving();
        AvailableRookKilling = rook.getAvailableKilling();
        
        // Get bishop Available Moving
        bishop bishop = new bishop(setOngraphic);
        boolean AvailableBishopMoving[][] = new boolean[8][8];
        boolean AvailableBishopKilling[][] = new boolean[8][8];
        bishop.bishopMoving(x, y);
        AvailableBishopMoving = bishop.getAvailableMoving();
        AvailableBishopKilling = bishop.getAvailableKilling();
        
        // Get Union betwwen of them 
        AvailableMoving = Union(AvailableRookMoving, AvailableBishopMoving);
        AvailableKilling = Union(AvailableRookKilling, AvailableBishopKilling);
        return AvailableMoving;
    }

    @Override
    public boolean[][] setKillOrNokill(int x, int y) {
        return AvailableKilling;
    }

    public boolean[][] Union(boolean[][] a, boolean b[][]) {
        boolean Union[][] = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Union[i][j] = a[i][j] | b[i][j];
            }
        }
        return Union;

    }

}
