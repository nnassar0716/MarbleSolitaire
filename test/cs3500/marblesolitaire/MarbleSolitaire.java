package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * This class houses the main method, which is the main way to run and play a game. This allows
 * users to enter commands for the type of board they want generated, and then play the game.
 */
public final class MarbleSolitaire {
  /**
   * The main method of the program which is where all the inputs from a user are taken in and
   * checked in order to execute the correct given command.
   *
   * @param args the array of Strings which houses the commands
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = null;
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    MarbleSolitaireController controller = null;
    MarbleSolitaireView view;
    String modelName = "";
    int modelSize = -10;
    int rowInput = -10;
    int colInput = -10;

    for (int i = 0; i < args.length; i++) {
      String s = args[i];
      switch (s.toLowerCase()) {
        case "english":
          modelName = "english";
          break;
        case "european":
          modelName = "european";
          break;
        case "triangular":
          modelName = "triangular";
          break;
        case "-size":
          try {
            modelSize = Integer.parseInt(args[i]);
          } catch (NumberFormatException e) {
            // not considered
          }
          break;
        case "-hole":
          try {
            rowInput = Integer.parseInt(args[i + 1]);
            colInput = Integer.parseInt(args[i + 2]);
          } catch (NumberFormatException e) {
            // not considered
          }
          break;
        default:
          // no default necessary
      }
    }

    switch (modelName) {
      case "english":
        if (modelSize != -10 && rowInput != -10) {
          model = new EnglishSolitaireModel(modelSize, rowInput, colInput);
        } else if (modelSize != -10 && rowInput == -10) {
          model = new EnglishSolitaireModel(modelSize);
        } else if (modelSize == -10 && rowInput != -10) {
          model = new EnglishSolitaireModel(rowInput, colInput);
        } else if (modelSize == -10 && rowInput == -10) {
          model = new EnglishSolitaireModel();
        }

        view = new MarbleSolitaireTextView(model);
        controller = new MarbleSolitaireControllerImpl(model, view, rd);
        break;

      case "european":
        if (modelSize != -10 && rowInput != -10) {
          model = new EuropeanSolitaireModel(modelSize, rowInput, colInput);
        } else if (modelSize != -10 && rowInput == -10) {
          model = new EuropeanSolitaireModel(modelSize);
        } else if (modelSize == -10 && rowInput != -10) {
          model = new EuropeanSolitaireModel(rowInput, colInput);
        } else if (modelSize == -10 && rowInput == -10) {
          model = new EuropeanSolitaireModel();
        }

        view = new MarbleSolitaireTextView(model);
        controller = new MarbleSolitaireControllerImpl(model, view, rd);
        break;

      case "triangular":
        if (modelSize != -10 && rowInput != -10) {
          model = new TriangleSolitaireModel(modelSize, rowInput, colInput);
        } else if (modelSize != -10 && rowInput == -10) {
          model = new TriangleSolitaireModel(modelSize);
        } else if (modelSize == -10 && rowInput != -10) {
          model = new TriangleSolitaireModel(rowInput, colInput);
        } else if (modelSize == -10 && rowInput == -10) {
          model = new TriangleSolitaireModel();
        }

        view = new TriangleSolitaireTextView(model);
        controller = new MarbleSolitaireControllerImpl(model, view, rd);
        break;
      default:
        // no default case needed
    }

    assert controller != null;
    controller.playGame();
  }
}
