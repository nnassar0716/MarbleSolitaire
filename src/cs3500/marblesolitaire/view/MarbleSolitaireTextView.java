package cs3500.marblesolitaire.view;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents the view for the solitaire game. It implements the MarbleSolitaireView
 * interface.
 */
public class MarbleSolitaireTextView extends ASolitaireView {

  /**
   * Constructs a MarbleSolitaireTextView object that represents the view of a given
   * MarbleSolitaireModelState model.
   *
   * @param model the model that is given a view
   * @throws IllegalArgumentException the exception thrown if the given model is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    super(model, System.out);
  }

  /**
   * Constructs a MarbleSolitaireTextView object that represents the view of a given
   * MarbleSolitaireModelState model and an Appendable destination.
   *
   * @param model       the mode that is given a view
   * @param destination the Appendable that is the destination for output
   * @throws IllegalArgumentException the exception thrown if either of the above parameters are
   *                                  null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable destination)
          throws IllegalArgumentException {
    super(model, destination);
  }

}
