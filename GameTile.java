import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.*;

public class GameTile extends JButton
{

    private static final long serialVersionUID = 1L;

    public int[] position;

    public GamePiece piece = null;

    private Color normal;
    private Color highlight = Color.YELLOW;

    public GameTile thisTile;

    public GameTile(int[] pos, int tileCol)
    {
        super();
        position = pos;
        thisTile = this;

        if (tileCol % 2 == 0)
        {
            normal = Color.GRAY;
            setBackground(Color.GRAY);
        }
        else
        {
            normal = Color.WHITE;
            setBackground(Color.WHITE);
        }

        CreateAL();
    }

    public GameTile(GamePiece temp, int[] pos, int tileCol)
    {
        super(temp.pieceColour + " " + temp.pieceName);

        position = pos;
        thisTile = this;
        piece = temp;
        piece.position = this;

        if (tileCol % 2 == 0)
        {
            normal = Color.GRAY;
            setBackground(Color.GRAY);
        }
        else
        {
            normal = Color.WHITE;
            setBackground(Color.WHITE);
        }

        CreateAL();
            
    }

    public void CreateAL()
    {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (Game.selected == null)
                {
                    if (thisTile.piece == null)
                    {
                        return;
                    }

                    if (Game.GetTurn() != thisTile.piece.pieceColour)
                    {
                        return;
                    }

                    Game.selected = thisTile;
                    setBackground(highlight);
                    repaint();
                    revalidate();
                    System.out.println("Selected tile " + thisTile.position[0] + "-" + thisTile.position[1]);
                }
                else
                {
                    if (Game.selected == thisTile)
                    {
                        Game.selected = null;
                        setBackground(normal);
                        repaint();
                        revalidate();
                        System.out.println("Clicked on the same tile, removed selection");
                    }
                    else
                    {
                        System.out.println("Clicked on tile " + thisTile.position[0] + "-" + thisTile.position[1]);

                        if (Game.selected.piece.pieceName == "pawn")
                        {
                            //Special pawn start
                            {
                            int[] newLocation = {Game.selected.position[0] + Game.selected.piece.pawnSpecial[0], Game.selected.position[1] + Game.selected.piece.pawnSpecial[1]};

                            if (newLocation[0] == thisTile.position[0] && newLocation[1] == thisTile.position[1])
                            {
                                if (thisTile.piece != null)
                                {
                                    System.out.println("Pawn can not move into piece.");
                                    return;
                                }

                                if (Game.selected.position[1] != 6 && Game.selected.position[1] != 1)
                                {
                                    System.out.println("Pawn can only move two as first move.");
                                    return;
                                }

                                System.out.println("Piece moved from " + Game.selected.position[0] + "-" + Game.selected.position[1]);
                                System.out.println("Piece moved to " + thisTile.position[0] + "-" + thisTile.position[1]);
                                thisTile.setText(Game.selected.getText());
                                Game.selected.setText("");
                                piece = Game.selected.piece;
                                piece.position = Game.selected;
                                Game.selected.piece = null;
                                Game.selected.setBackground(Game.selected.normal);
                                Game.selected = null;
                                setBackground(normal);
                                repaint();
                                revalidate();
                                Game.AddTurn();
                                return;
                            }
                            }

                            for (int[] attack : Game.selected.piece.attacks)
                            {
                                int[] newLocation = {Game.selected.position[0] + attack[0], Game.selected.position[1] + attack[1]};

                                if (newLocation[0] == thisTile.position[0] && newLocation[1] == thisTile.position[1] && thisTile.piece != null)
                                {
                                    if (thisTile.piece != null && thisTile.piece.pieceColour == Game.selected.piece.pieceColour)
                                    {
                                        System.out.println("Cannot attack a space with the same color piece.");
                                        return;
                                    }

                                    System.out.println("Piece attacked from " + Game.selected.position[0] + "-" + Game.selected.position[1]);
                                    System.out.println("Piece attacked at" + thisTile.position[0] + "-" + thisTile.position[1]);
                                    thisTile.setText(Game.selected.getText());
                                    Game.selected.setText("");
                                    piece = Game.selected.piece;
                                    piece.position = Game.selected;
                                    Game.selected.piece = null;
                                    Game.selected.setBackground(Game.selected.normal);
                                    Game.selected = null;
                                    setBackground(normal);
                                    repaint();
                                    revalidate();
                                    Game.AddTurn();
                                    return;
                                }

                            }
                            
                        }

                        for (int[] move : Game.selected.piece.moves)
                        {
                            int[] newLocation = {Game.selected.position[0] + move[0], Game.selected.position[1] + move[1]};
                            //System.out.println("move: " + newLocation[0] + "-" + newLocation[1]);
                            //System.out.println("ThisTile.position = " + thisTile.position[0] + "-" + thisTile.position[1]);
                            if (newLocation[0] == thisTile.position[0] && newLocation[1] == thisTile.position[1])
                            {
                                //Prevents pawns from moving into other pieces.
                                if (thisTile.piece != null && Game.selected.piece.pieceName == "pawn")
                                {
                                    System.out.println("Pawn can not move into piece.");
                                    return;
                                }

                                //Prevent moving a piece into a square that already contains one of your pieces.
                                if (thisTile.piece != null && thisTile.piece.pieceColour == Game.selected.piece.pieceColour)
                                {
                                    System.out.println("Cannot move into a space with the same color piece.");
                                    return;
                                }

                                //Prevents everything but knights from moving THROUGH other pieces.
                                if (Game.selected.piece.pieceName == "rook" || Game.selected.piece.pieceName == "bishop" || Game.selected.piece.pieceName == "queen")
                                {

                                    int tarX = Game.selected.position[0];
                                    int tarY = Game.selected.position[1];

                                    int x = newLocation[0];
                                    int y = newLocation[1];
                                    
                                    while(x != tarX && y != tarY)
                                    {

                                        if (x > tarX)
                                        {
                                            x -= 1;
                                        }
                                        else if (x < tarX)
                                        {
                                            x += 1;
                                        }
                                        if (y > tarY)
                                        {
                                            y -= 1;
                                        }
                                        else if (y < tarY)
                                        {
                                            y += 1;
                                        }

                                        if (tarX == x && tarY == y)
                                        {
                                            break;
                                        }

                                        System.out.println("checking tile: " + x + "-" + y);
                                        if (GUI.board.get((8 * y) + x).piece != null)
                                        {
                                            System.out.println(":Invalid Move::Piece in the way:");
                                            return;
                                        }
                                        
                                    }
                                }

                                System.out.println("Piece moved from " + Game.selected.position[0] + "-" + Game.selected.position[1]);
                                System.out.println("Piece moved to " + thisTile.position[0] + "-" + thisTile.position[1]);
                                thisTile.setText(Game.selected.getText());
                                Game.selected.setText("");
                                piece = Game.selected.piece;
                                piece.position = Game.selected;
                                Game.selected.piece = null;
                                Game.selected.setBackground(Game.selected.normal);
                                Game.selected = null;
                                setBackground(normal);
                                repaint();
                                revalidate();
                                Game.AddTurn();
                                return;
                            }
                        }
                        System.out.println(":Invalid Move:");
                    }
                }
                
            }});
    }    

}