import java.awt.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame
{
    private static final long serialVersionUID = 1L;

    public static ArrayList<GameTile> board;

    GUI()
    {
        super("Guessing Game");

        SetUpGUI();
    }

    private void SetUpGUI()
    {

        board = new ArrayList<GameTile>();

        int bck = 0;

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {

                if (i == 0)
                {
                    if (j == 0 || j == 7)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("wrook"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 1 || j == 6)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("wknight"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 2 || j == 5)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("wbishop"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 3)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("wqueen"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 4)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("wking"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                }
                else if (i == 1)
                {
                    GameTile temp = new GameTile(Game.allPieces.get("wpawn"), new int[] {j,i}, bck);
                    board.add(temp);
                }
                else if (i == 6)
                {
                    GameTile temp = new GameTile(Game.allPieces.get("bpawn"), new int[] {j,i}, bck);
                    board.add(temp);
                }
                else if (i == 7)
                {
                    if (j == 0 || j == 7)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("brook"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 1 || j == 6)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("bknight"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 2 || j == 5)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("bbishop"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 3)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("bqueen"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                    else if (j == 4)
                    {
                        GameTile temp = new GameTile(Game.allPieces.get("bking"), new int[] {j,i}, bck);
                        board.add(temp);
                    }
                }
                else
                {
                    GameTile temp = new GameTile(new int[] {j,i}, bck);
                    board.add(temp);
                }
                bck++;
            }
            bck++;
        }

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(8,8));

        JPanel k = new JPanel();

        for (GameTile t : board)
        {
            j.add(t);
        }

        setLayout(new BorderLayout());

        add(j, BorderLayout.WEST);
        add(k, BorderLayout.EAST);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(150, 150);
        setSize(800, 520);

    }

    public void Refresh()
    {
        repaint();
        revalidate();
    }

}