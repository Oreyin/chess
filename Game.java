import java.util.ArrayList;
import java.util.HashMap;

public class Game
{

    public static GameTile selected = null;

    public static HashMap<String, GamePiece> allPieces = new HashMap<String, GamePiece>();
    public static int turn = 0;

    public static ArrayList<ArrayList<GamePiece>> boardstate = new ArrayList<ArrayList<GamePiece>>();
    public static ArrayList<ArrayList<GamePiece>> nextboardstate = new ArrayList<ArrayList<GamePiece>>();

    public static void AddTurn()
    {
        turn++;
    }

    public static void CheckForCheck()
    {
        
    }

    public static void CreatePieces()
    {
        String c = "w";

        for (int i = 0; i < 2; i++)
        {
            if (i == 1)
            {
                c = "b";
            }

            allPieces.put(c + "rook", new GamePiece("rook", c));
            allPieces.put(c + "knight", new Knight("knight", c));
            allPieces.put(c + "bishop", new GamePiece("bishop", c));
            allPieces.put(c + "queen", new GamePiece("queen", c));
            allPieces.put(c + "king", new GamePiece("king", c));
            allPieces.put(c + "pawn", new Pawn("pawn", c));
        }

    }

    public static String GetTurn()
    {
        if (turn % 2 == 0)
        {
            return "w";
        }
        else
        {
            return "b";
        }
    }

}