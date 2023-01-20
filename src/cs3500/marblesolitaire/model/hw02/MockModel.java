package cs3500.marblesolitaire.model.hw02;

import java.util.Objects;

/**
 * A mock class for the MarbleSolitaireModel interface. Its purpose is to test valid inputs for
 * the controller.
 */
public class MockModel implements MarbleSolitaireModel {

  final StringBuilder log;

  /**
   * Constructs a MockModel object which takes in a given StringBuilder to log proper inputs.
   *
   * @param log the StringBuilder which logs proper inputs
   */
  public MockModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Mock version of move method which checks that the given positions are proper inputs.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 1)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 1)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 1)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 1)
   * @throws IllegalArgumentException no exception is thrown here
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(String.format("fromRow = %d, fromCol = %d, toRow = %d, toCol = %d\n", fromRow,
            fromCol, toRow, toCol));
  }

  /**
   * Mock version of isGameOver which always returns false.
   *
   * @return always false
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Mock version of getBoardSize which always returns 0.
   *
   * @return the value 0
   */
  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * Mock version of getSlotAt which does nothing.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return null
   * @throws IllegalArgumentException no exception thrown
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  /**
   * Mock version of getScore which always returns 0.
   *
   * @return the value 0
   */
  @Override
  public int getScore() {
    return 0;
  }
}
