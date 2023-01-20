package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.ASolitaireModel;

/**
 * This class represents a model of an English Solitaire Marble game. It implements the
 * MarbleSolitaireModel interface.
 */
public class EnglishSolitaireModel extends ASolitaireModel {


  /**
   * Constructs an EnglishSolitaireModel object with a default arm thickness of 3.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs an EnglishSolitaireModel object with a default arm thickness of 3 and with an
   * empty space set at a given row and column.
   *
   * @param sRow the given row where the empty space is
   * @param sCol the given column where an empty space is
   * @throws IllegalArgumentException the exception thrown if the given row and column is an
   *                                  invalid space
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructs an EnglishSolitaireModel object with a given arm thickness.
   *
   * @param armThick the arm thickness of the game board
   * @throws IllegalArgumentException the exception thrown if the given arm thickness is even,
   *                                  negative, or both
   */

  public EnglishSolitaireModel(int armThick) throws IllegalArgumentException {
    this(armThick, Math.abs((armThick * 3 - 2)) / 2, Math.abs((armThick * 3 - 2) / 2));
    if (this.armThick % 2 == 0) {
      throw new IllegalArgumentException("The arm thickness cannot be even.");
    }
  }

  /**
   * Constructs an EnglishSolitaireModel with a given arm thickness and an empty space at a given
   * row and column.
   *
   * @param armThick the arm thickness of the board
   * @param sRow     the row of the empty space
   * @param sCol     the column of the empty space
   * @throws IllegalArgumentException the exception thrown if the arm thickness is even or
   *                                  negative, or if the given empty space is invalid
   */
  public EnglishSolitaireModel(int armThick, int sRow, int sCol) throws IllegalArgumentException {
    super(armThick, sRow, sCol);
    if (this.armThick % 2 == 0) {
      throw new IllegalArgumentException("The arm thickness cannot be even.");
    }
  }

  /**
   * Initializes the game board and assigns the correct SlotState to each position.
   */
  protected void initGameBoard() {
    int invalidSize = this.armThick - 1;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if ((i < invalidSize && j < invalidSize)
                || (i < invalidSize && j >= (armThick + invalidSize))
                || (i >= (armThick + invalidSize) && j < invalidSize)
                || (i >= (armThick + invalidSize) && j >= (armThick + invalidSize))) {
          board[i][j] = SlotState.Invalid;
        } else {
          board[i][j] = SlotState.Marble;
        }
      }
    }
  }


}
