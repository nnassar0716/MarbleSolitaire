package cs3500.marblesolitaire.view;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents the view for a triangle solitaire board. It displays the game in the
 * shape of a triangle.
 */
public class TriangleSolitaireTextView extends ASolitaireView {

  /**
   * Constructs a TriangleSolitaireTextView object that represents the view of a given
   * MarbleSolitaireModelState model.
   *
   * @param model the model that is given a view
   * @throws IllegalArgumentException the exception thrown if the given model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model)
          throws IllegalArgumentException {
    super(model, System.out);
  }

  /**
   * Constructs a TriangleSolitaireTextView object that represents the view of a given
   * MarbleSolitaireModelState model and an Appendable destination.
   *
   * @param model       the mode that is given a view
   * @param destination the Appendable that is the destination for output
   * @throws IllegalArgumentException the exception thrown if either of the above parameters are
   *                                  null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable destination)
          throws IllegalArgumentException {
    super(model, destination);
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot. Additionally,
   * there is a certain number of spaces placed before the first column of every row, giving the
   * view a triangular shape.
   *
   * @return the game state as a string
   */
  @Override
  public String toString() {
    StringBuilder modelView = new StringBuilder();
    for (int i = 0; i < model.getBoardSize(); i++) {
      for (int j = 0; j < model.getBoardSize(); j++) {
        if (j == 0) {
          addSpace(model.getBoardSize() - i - 1, modelView);
        }
        if (j < this.model.getBoardSize() - 1
                && this.model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble
                && this.model.getSlotAt(i, j + 1)
                == MarbleSolitaireModelState.SlotState.Invalid) {
          modelView.append("O");
          break;
        }
        if (j < this.model.getBoardSize() - 1
                && this.model.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty
                && this.model.getSlotAt(i, j + 1)
                == MarbleSolitaireModelState.SlotState.Invalid) {
          modelView.append("_");
          break;
        }
        switch (this.model.getSlotAt(i, j)) {
          case Empty:
            modelView.append("_");
            break;
          case Marble:
            modelView.append("O");
            break;
          case Invalid:
            modelView.append(" ");
            break;
          default:
            /* no default case */
        }
        if (j < this.model.getBoardSize() - 1) {
          modelView.append(" ");
        }
      }
      if (i < this.model.getBoardSize() - 1) {
        modelView.append("\n");
      }
    }
    return modelView.toString();
  }

  /**
   * Adds a certain number of spaces before the first column of each row of a model.
   */
  private void addSpace(int numSpace, StringBuilder space) {
    space.append(" ".repeat(Math.max(0, numSpace)));
  }

}
