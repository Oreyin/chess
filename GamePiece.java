import java.util.ArrayList;

public class GamePiece
{
    public ArrayList<int[]> moves;
    public ArrayList<int[]> attacks;
    public String pieceName;
    public String pieceColour;
    public GameTile position;

    public int[] pawnSpecial;

    public GamePiece(String name, String color)
    {
        moves = new ArrayList<int[]>();
        attacks = new ArrayList<int[]>();
        pieceName = name;
        pieceColour = color;

        if (name == "pawn")
        {
            if (color == "w")
            {
                pawnSpecial = new int[] {0,2};
                moves.add(new int[] {0,1});
                attacks.add(new int[] {-1,1});
                attacks.add(new int[] {1,1});
            }
            else
            {
                pawnSpecial = new int[] {0,-2};
                moves.add(new int[] {0,-1});
                attacks.add(new int[] {-1,-1});
                attacks.add(new int[] {1,-1});
            }
        }
        else if (name == "knight")
        {
            moves.add(new int[] {2,1});
            moves.add(new int[] {2,-1});
            moves.add(new int[] {-2,1});
            moves.add(new int[] {-2,-1});
            moves.add(new int[] {1,-2});
            moves.add(new int[] {-1,-2});
            moves.add(new int[] {1,2});
            moves.add(new int[] {-1,2});
        }
        else if (name == "king")
        {
            moves.add(new int[] {1,1});
            moves.add(new int[] {1,-1});
            moves.add(new int[] {1,0});
            moves.add(new int[] {-1,1});
            moves.add(new int[] {-1,-1});
            moves.add(new int[] {-1,0});
            moves.add(new int[] {0,1});
            moves.add(new int[] {0,-1});
        }
        else if (name == "rook")
        {
            moves.add(new int[] {1,0});
            moves.add(new int[] {2,0});
            moves.add(new int[] {3,0});
            moves.add(new int[] {4,0});
            moves.add(new int[] {5,0});
            moves.add(new int[] {6,0});
            moves.add(new int[] {7,0});

            moves.add(new int[] {-1,0});
            moves.add(new int[] {-2,0});
            moves.add(new int[] {-3,0});
            moves.add(new int[] {-4,0});
            moves.add(new int[] {-5,0});
            moves.add(new int[] {-6,0});
            moves.add(new int[] {-7,0});

            moves.add(new int[] {0,1});
            moves.add(new int[] {0,2});
            moves.add(new int[] {0,3});
            moves.add(new int[] {0,4});
            moves.add(new int[] {0,5});
            moves.add(new int[] {0,6});
            moves.add(new int[] {0,7});

            moves.add(new int[] {0,-1});
            moves.add(new int[] {0,-2});
            moves.add(new int[] {0,-3});
            moves.add(new int[] {0,-4});
            moves.add(new int[] {0,-5});
            moves.add(new int[] {0,-6});
            moves.add(new int[] {0,-7});
        }
        else if (name == "bishop")
        {
            moves.add(new int[] {1,1});
            moves.add(new int[] {2,2});
            moves.add(new int[] {3,3});
            moves.add(new int[] {4,4});
            moves.add(new int[] {5,5});
            moves.add(new int[] {6,6});
            moves.add(new int[] {7,7});
            
            moves.add(new int[] {1,-1});
            moves.add(new int[] {2,-2});
            moves.add(new int[] {3,-3});
            moves.add(new int[] {4,-4});
            moves.add(new int[] {5,-5});
            moves.add(new int[] {6,-6});
            moves.add(new int[] {7,-7});

            moves.add(new int[] {-1,1});
            moves.add(new int[] {-2,2});
            moves.add(new int[] {-3,3});
            moves.add(new int[] {-4,4});
            moves.add(new int[] {-5,5});
            moves.add(new int[] {-6,6});
            moves.add(new int[] {-7,7});

            moves.add(new int[] {-1,-1});
            moves.add(new int[] {-2,-2});
            moves.add(new int[] {-3,-3});
            moves.add(new int[] {-4,-4});
            moves.add(new int[] {-5,-5});
            moves.add(new int[] {-6,-6});
            moves.add(new int[] {-7,-7});
        }
        else if (name == "queen")
        {
            //straight moves
            moves.add(new int[] {1,0});
            moves.add(new int[] {2,0});
            moves.add(new int[] {3,0});
            moves.add(new int[] {4,0});
            moves.add(new int[] {5,0});
            moves.add(new int[] {6,0});
            moves.add(new int[] {7,0});

            moves.add(new int[] {-1,0});
            moves.add(new int[] {-2,0});
            moves.add(new int[] {-3,0});
            moves.add(new int[] {-4,0});
            moves.add(new int[] {-5,0});
            moves.add(new int[] {-6,0});
            moves.add(new int[] {-7,0});

            moves.add(new int[] {0,1});
            moves.add(new int[] {0,2});
            moves.add(new int[] {0,3});
            moves.add(new int[] {0,4});
            moves.add(new int[] {0,5});
            moves.add(new int[] {0,6});
            moves.add(new int[] {0,7});

            moves.add(new int[] {0,-1});
            moves.add(new int[] {0,-2});
            moves.add(new int[] {0,-3});
            moves.add(new int[] {0,-4});
            moves.add(new int[] {0,-5});
            moves.add(new int[] {0,-6});
            moves.add(new int[] {0,-7});

            //diagonal moves
            moves.add(new int[] {1,1});
            moves.add(new int[] {2,2});
            moves.add(new int[] {3,3});
            moves.add(new int[] {4,4});
            moves.add(new int[] {5,5});
            moves.add(new int[] {6,6});
            moves.add(new int[] {7,7});
            
            moves.add(new int[] {1,-1});
            moves.add(new int[] {2,-2});
            moves.add(new int[] {3,-3});
            moves.add(new int[] {4,-4});
            moves.add(new int[] {5,-5});
            moves.add(new int[] {6,-6});
            moves.add(new int[] {7,-7});

            moves.add(new int[] {-1,1});
            moves.add(new int[] {-2,2});
            moves.add(new int[] {-3,3});
            moves.add(new int[] {-4,4});
            moves.add(new int[] {-5,5});
            moves.add(new int[] {-6,6});
            moves.add(new int[] {-7,7});

            moves.add(new int[] {-1,-1});
            moves.add(new int[] {-2,-2});
            moves.add(new int[] {-3,-3});
            moves.add(new int[] {-4,-4});
            moves.add(new int[] {-5,-5});
            moves.add(new int[] {-6,-6});
            moves.add(new int[] {-7,-7});

        }

    }

    public void Move()
    {
        
    }

}