package cs3500.marblesolitaire.controller;

/**
 * Represents the interface for a MarbleSolitaireController. This interface holds the important
 * methods that the controller will use.
 */
public interface MarbleSolitaireController {

  /**
   * The method that "plays the game" which essentially is the controller for user to play the
   * English Solitaire game with.
   *
   * @throws IllegalStateException the exception thrown if there is no next input
   */
  void playGame() throws IllegalStateException;
}
