package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents an abstract class which implements the MarbleSolitaireView interface. It
 * represents what a generic view would look like.
 */
public abstract class ASolitaireView implements MarbleSolitaireView {

  protected final MarbleSolitaireModelState model;
  protected final Appendable destination;

  /**
   * Constructs an ASolitaireView object that represents the view of a given
   * MarbleSolitaireModelState model and an Appendable destination.
   *
   * @param model       the model that is given a view
   * @param destination the Appendable that is the destination for output
   * @throws IllegalArgumentException the exception thrown if either of the above parameters are
   *                                  null
   */
  public ASolitaireView(MarbleSolitaireModelState model, Appendable destination) throws
          IllegalArgumentException {
    if (model == null || destination == null) {
      throw new IllegalArgumentException("The given parameters cannot be null.");
    }
    this.model = model;
    this.destination = destination;
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public String toString() {
    StringBuilder modelView = new StringBuilder();
    for (int i = 0; i < this.model.getBoardSize(); i++) {
      for (int j = 0; j < this.model.getBoardSize(); j++) {
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

  public void renderBoard() throws IOException {
    destination.append(this.toString()).append(System.lineSeparator());
  }

  public void renderMessage(String message) throws IOException {
    destination.append(message);
  }
}
