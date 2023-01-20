package cs3500.marblesolitaire.model.hw04;

/**
 * This class represents a model of a Triangular Solitaire game. It extends the ASolitaireModel
 * class and inherits its methods.
 */
public class TriangleSolitaireModel extends ASolitaireModel {

  /**
   * Constructs an TriangleSolitaireModel object with a default arm thickness of 5.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Constructs an EnglishSolitaireModel object with a given arm thickness.
   *
   * @param dim the arm thickness of the game board
   * @throws IllegalArgumentException the exception thrown if the given arm thickness is even,
   *                                  negative, or both
   */
  public TriangleSolitaireModel(int dim) throws IllegalArgumentException {
    this(dim, 0, 0);
  }

  /**
   * Constructs an TriangleSolitaireModel object with a default arm thickness of 5 and with an
   * empty space set at a given row and column.
   *
   * @param sRow the given row where the empty space is
   * @param sCol the given column where an empty space is
   * @throws IllegalArgumentException the exception thrown if the given row and column is an
   *                                  invalid space
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(5, sRow, sCol);
  }

  /**
   * Constructs an TriangleSolitaireModel with a given arm thickness and an empty space at a given
   * row and column.
   *
   * @param dim  the arm thickness of the board
   * @param sRow the row of the empty space
   * @param sCol the column of the empty space
   * @throws IllegalArgumentException the exception thrown if the arm thickness is
   *                                  negative, or if the given empty space is invalid
   */
  public TriangleSolitaireModel(int dim, int sRow, int sCol) throws IllegalArgumentException {
    super(dim, sRow, sCol);
  }

  /**
   * Initializes a Triangular Solitaire game board and sets all the positions to the correct
   * SlotState.
   */
  protected void initGameBoard() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (j <= i) {
          board[i][j] = SlotState.Marble;
        } else {
          board[i][j] = SlotState.Invalid;
        }
      }
    }
  }


  /**
   * Return the size of the game board. The size of the board is the same as the number of rows
   * the model has (dimension of the board).
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return this.armThick;
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException the exception thrown if the
   *                                  to space has a marble in it, the from space has no marble,
   *                                  the space between the to and from
   *                                  has no marble, or if the from and to places are more or
   *                                  less than two spaces apart
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow >= 0 && fromCol >= 0 && toRow >= 0 && toCol >= 0 && fromRow < this.getBoardSize()
            && fromCol < this.getBoardSize() && toRow < this.getBoardSize()
            && toCol < this.getBoardSize()
            && board[fromRow][fromCol] == SlotState.Marble
            && board[toRow][toCol] == SlotState.Empty
            && ((Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2)
            || (fromRow == toRow && Math.abs(fromCol - toCol) == 2)
            || (Math.abs(fromRow - toRow) == 2 && fromCol == toCol))) {
      if (fromCol < toCol && fromRow < toRow
              && board[toRow - 1][toCol - 1] == SlotState.Marble) {
        board[fromRow][fromCol] = SlotState.Empty;
        board[toRow - 1][toCol - 1] = SlotState.Empty;
        board[toRow][toCol] = SlotState.Marble;
      } else if (fromCol > toCol && fromRow > toRow
              && board[toRow + 1][toCol + 1] == SlotState.Marble) {
        board[fromRow][fromCol] = SlotState.Empty;
        board[toRow + 1][toCol + 1] = SlotState.Empty;
        board[toRow][toCol] = SlotState.Marble;
      } else {
        super.move(fromRow, fromCol, toRow, toCol);
      }
    } else {
      throw new IllegalArgumentException("This is not a valid move.");
    }
  }

  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (board[i][j] == SlotState.Marble) {
          if (i > 1 && j > 1) {
            if (board[i - 1][j - 1] == SlotState.Marble && board[i - 2][j - 2] == SlotState.Empty) {
              return false;
            }
          }
          if (i < this.getBoardSize() - 2 && j < this.getBoardSize()) {
            if (board[i + 1][j + 1] == SlotState.Marble && board[i + 2][j + 2] == SlotState.Empty) {
              return false;
            }
          }
        }
      }
    }
    return super.isGameOver();
  }
}
