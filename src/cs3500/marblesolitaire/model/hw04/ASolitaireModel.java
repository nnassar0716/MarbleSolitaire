package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This class represents an abstract class for the model classes implemented in this assignment.
 * All the methods which share duplicate code are kept here.
 */
public abstract class ASolitaireModel implements MarbleSolitaireModel {

  protected int armThick;

  protected SlotState[][] board;


  /**
   * Constructs an ASolitaireModel with a given arm thickness and an empty space at a given
   * row and column.
   *
   * @param armThick the arm thickness of the board
   * @param sRow     the row of the empty space
   * @param sCol     the column of the empty space
   * @throws IllegalArgumentException the exception thrown if the arm thickness is
   *                                  negative, or if the given empty space is invalid
   */
  public ASolitaireModel(int armThick, int sRow, int sCol) throws IllegalArgumentException {
    this.armThick = armThick;
    if (this.armThick < 0) {
      throw new IllegalArgumentException("The arm thickness must be a positive number.");
    }
    this.board = new SlotState[this.getBoardSize()][this.getBoardSize()];
    initGameBoard();
    if (this.getSlotAt(sRow, sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + ", " + sCol +
              ")");
    }
    setEmpty(sRow, sCol);
  }

  /**
   * Initializes the game board and assigns the correct SlotState to each position.
   */
  protected abstract void initGameBoard();

  /**
   * Sets the empty space on the game board to the position that matches the given row and column.
   *
   * @param sRow the row of the empty space
   * @param sCol the column of the empty space
   */
  protected void setEmpty(int sRow, int sCol) {
    board[sRow][sCol] = SlotState.Empty;
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
   * @throws IllegalArgumentException the exception thrown if a diagonal move is attempted, the
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
            && (Math.abs(fromRow - toRow) == 2 || Math.abs(fromCol - toCol) == 2)) {
      if (fromRow == toRow && fromCol > toCol
              && board[fromRow][fromCol - 1] == SlotState.Marble) {
        board[fromRow][fromCol] = SlotState.Empty;
        board[fromRow][fromCol - 1] = SlotState.Empty;
        board[toRow][toCol] = SlotState.Marble;
      } else if (fromRow == toRow && fromCol < toCol
              && board[fromRow][fromCol + 1] == SlotState.Marble) {
        board[fromRow][fromCol] = SlotState.Empty;
        board[fromRow][fromCol + 1] = SlotState.Empty;
        board[toRow][toCol] = SlotState.Marble;
      } else if (fromCol == toCol && fromRow > toRow
              && board[fromRow - 1][fromCol] == SlotState.Marble) {
        board[fromRow][fromCol] = SlotState.Empty;
        board[fromRow - 1][fromCol] = SlotState.Empty;
        board[toRow][toCol] = SlotState.Marble;
      } else if (fromCol == toCol && fromRow < toRow
              && board[fromRow + 1][fromCol] == SlotState.Marble) {
        board[fromRow][fromCol] = SlotState.Empty;
        board[fromRow + 1][fromCol] = SlotState.Empty;
        board[toRow][toCol] = SlotState.Marble;
      } else {
        throw new IllegalArgumentException("This is not a valid move.");
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
          if (i > 1) {
            if (board[i - 1][j] == SlotState.Marble && board[i - 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (i < this.getBoardSize() - 2) {
            if (board[i + 1][j] == SlotState.Marble && board[i + 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (j > 1) {
            if (board[i][j - 1] == SlotState.Marble && board[i][j - 2] == SlotState.Empty) {
              return false;
            }
          }
          if (j < this.getBoardSize() - 2) {
            if (board[i][j + 1] == SlotState.Marble && board[i][j + 2] == SlotState.Empty) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return Math.abs(this.armThick * 3 - 2);
  }

  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row >= this.getBoardSize() || col >= this.getBoardSize()
            || row < 0 || col < 0) {
      throw new IllegalArgumentException("This position is outside the dimensions of the board.");
    }
    return board[row][col];
  }

  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.getSlotAt(i, j) == SlotState.Marble) {
          score += 1;
        }
      }
    }
    return score;
  }
}
