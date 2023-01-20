package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * This class represents an implementation of the MarbleSolitaireController interface. It is
 * where the main controller for the game is held.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable readable;
  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;

  /**
   * Constructs a MarbleSolitaireControllerImpl object with a given model, view, and readable.
   *
   * @param model    the model being played
   * @param view     the view of the model
   * @param readable the input for the controller
   * @throws IllegalArgumentException the exception thrown if any of the above parameters are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable readable) throws IllegalArgumentException {
    if (model == null || view == null || readable == null) {
      throw new IllegalArgumentException("The given parameters cannot be null.");
    }
    this.model = model;
    this.view = view;
    this.readable = readable;
  }

  /**
   * The method that "plays the game" which essentially is the controller for user to play the
   * English Solitaire game with.
   *
   * @throws IllegalStateException the exception thrown if there is no next input
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner sc = new Scanner(readable);
    giveBoardStateAndScore();
    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;

    while (!model.isGameOver()) {
      if (sc.hasNext()) {
        String userIn = sc.next();

        if (validBoardNum(userIn)) {
          if (fromRow == 0) {
            fromRow = Integer.parseInt(userIn);
          } else if (fromCol == 0) {
            fromCol = Integer.parseInt(userIn);
          } else if (toRow == 0) {
            toRow = Integer.parseInt(userIn);
          } else {
            toCol = Integer.parseInt(userIn);

            try {
              tryMove(fromRow, fromCol, toRow, toCol);
              giveBoardStateAndScore();
              fromRow = 0;
              fromCol = 0;
              toRow = 0;
              toCol = 0;
            } catch (IllegalArgumentException e) {
              writeMessage("Invalid move. Play again.");
              fromRow = 0;
              fromCol = 0;
              toRow = 0;
              toCol = 0;
            }
          }
        } else if (userIn.equalsIgnoreCase("q")) {
          writeMessage("Game quit!");
          writeMessage("State of game when quit:");
          giveBoardStateAndScore();
          break;
        } else {
          writeMessage("The input given is invalid. Try again.");
        }
      } else {
        throw new IllegalStateException("There is no input.");
      }
    }
    if (model.isGameOver()) {
      writeMessage("Game over!");
      giveBoardStateAndScore();
    }
  }

  /**
   * Appends a string to the Appendable object given in the view.
   *
   * @param message the string to be appended
   * @throws IllegalStateException the exception thrown if the string is not properly transmitted
   *                               to the Appendable object
   */
  private void writeMessage(String message) throws IllegalStateException {
    try {
      view.renderMessage(message + System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * Provides the current state of the board as well as the current score of the game.
   */
  private void giveBoardStateAndScore() {
    try {
      view.renderBoard();
      writeMessage("Score: " + model.getScore());
    } catch (IOException e) {
      writeMessage("Error: " + e.getMessage() + System.lineSeparator());
    }
  }

  /**
   * Executes the move method when given the from row/column and the to row/column.
   *
   * @param fromRow the row of the from space
   * @param fromCol the column of the from space
   * @param toRow   the row of the to space
   * @param toCol   the column of the to space
   * @throws IllegalArgumentException the exception thrown if the move method attempts an invalid
   *                                  move
   */
  private void tryMove(int fromRow, int fromCol, int toRow,
                       int toCol) throws IllegalArgumentException {
    try {
      model.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  /**
   * Checks to see if a given String represents a valid number that can be entered into the
   * controller.
   *
   * @param userIn the given String to check
   * @return true if the String is positive integer, false if otherwise
   */
  private boolean validBoardNum(String userIn) {
    try {
      int input = Integer.parseInt(userIn);
      return input > 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
