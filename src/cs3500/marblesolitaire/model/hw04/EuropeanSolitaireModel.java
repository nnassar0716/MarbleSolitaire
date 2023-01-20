package cs3500.marblesolitaire.model.hw04;

/**
 * This class represents a model of a European Solitaire game. It extends the ASolitaireModel
 * class and inherits its methods.
 */
public class EuropeanSolitaireModel extends ASolitaireModel {

  /**
   * Constructs an EuropeanSolitaireModel object with a default arm thickness of 3.
   */
  public EuropeanSolitaireModel() {
    this(3, 3, 3);
  }

  /**
   * Constructs an EuropeanSolitaireModel object with a default arm thickness of 3 and with an
   * empty space set at a given row and column.
   *
   * @param sRow the given row where the empty space is
   * @param sCol the given column where an empty space is
   * @throws IllegalArgumentException the exception thrown if the given row and column is an
   *                                  invalid space
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
  }

  /**
   * Constructs an EuropeanSolitaireModel object with a given arm thickness.
   *
   * @param sideLength the arm thickness of the game board
   * @throws IllegalArgumentException the exception thrown if the given arm thickness is even,
   *                                  negative, or both
   */
  public EuropeanSolitaireModel(int sideLength) throws IllegalArgumentException {
    this(sideLength, Math.abs((sideLength * 3 - 2)) / 2, Math.abs((sideLength * 3 - 2) / 2));
    if (this.armThick % 2 == 0) {
      throw new IllegalArgumentException("The side length cannot be even.");
    }
  }

  /**
   * Constructs an EuropeanSolitaireModel with a given arm thickness and an empty space at a given
   * row and column.
   *
   * @param sideLength the arm thickness of the board
   * @param sRow       the row of the empty space
   * @param sCol       the column of the empty space
   * @throws IllegalArgumentException the exception thrown if the arm thickness is even or
   *                                  negative, or if the given empty space is invalid
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sCol)
          throws IllegalArgumentException {
    super(sideLength, sRow, sCol);

    if (this.armThick % 2 == 0) {
      throw new IllegalArgumentException("The side length cannot be even.");
    }
  }

  /**
   * Initializes a European Solitaire game board and sets all the positions to the correct
   * SlotState.
   */
  @Override
  protected void initGameBoard() {
    int invalidSize = this.armThick - 1;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if ((i < invalidSize && j < invalidSize - i)
                || (i < invalidSize && j >= (armThick + invalidSize) + i)
                || (i >= (armThick + invalidSize) && j < i - (armThick + invalidSize) + 1)
                || (i >= (armThick + invalidSize) &&
                j >= (getBoardSize() - 1) - (i - (getBoardSize() - invalidSize)))) {
          board[i][j] = SlotState.Invalid;
        } else {
          board[i][j] = SlotState.Marble;
        }
      }
    }
  }

}
