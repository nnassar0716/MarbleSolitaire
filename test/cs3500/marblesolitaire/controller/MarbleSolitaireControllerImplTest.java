package cs3500.marblesolitaire.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.model.hw02.CorruptAppendable;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Contains the tests for the MarbleSolitaireController.
 */
public class MarbleSolitaireControllerImplTest {
  private MarbleSolitaireModel model;
  private MarbleSolitaireModel euroModel;
  private MarbleSolitaireModel triModel;
  private Appendable ap;
  private MarbleSolitaireView view;
  private MarbleSolitaireView euroView;
  private MarbleSolitaireView triView;


  @Before
  public void init() {
    model = new EnglishSolitaireModel();
    euroModel = new EuropeanSolitaireModel();
    triModel = new TriangleSolitaireModel();
    ap = new StringBuilder();
    view = new MarbleSolitaireTextView(model, ap);
    euroView = new MarbleSolitaireTextView(euroModel, ap);
    triView = new TriangleSolitaireTextView(triModel, ap);
  }


  @Test
  public void testQuitAfterValidMove() {
    Reader in = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[16]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[17]);
    assertEquals("    O O O", ap.toString().split("\n")[18]);
    assertEquals("    O _ O", ap.toString().split("\n")[19]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[20]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[21]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[22]);
    assertEquals("    O O O", ap.toString().split("\n")[23]);
    assertEquals("    O O O", ap.toString().split("\n")[24]);
    assertEquals("Score: 31", ap.toString().split("\n")[25]);
  }

  @Test
  public void euroTestQuitAfterValidMove() {
    Reader in = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel,
            euroView, in);
    controller.playGame();
    assertEquals("Game quit!", ap.toString().split("\n")[16]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[17]);
    assertEquals("    O O O", ap.toString().split("\n")[18]);
    assertEquals("  O O _ O O", ap.toString().split("\n")[19]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[20]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[21]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[22]);
    assertEquals("  O O O O O", ap.toString().split("\n")[23]);
    assertEquals("    O O O", ap.toString().split("\n")[24]);
    assertEquals("Score: 35", ap.toString().split("\n")[25]);
  }

  @Test
  public void triTestQuitAfterValidMove() {
    Reader in = new StringReader("3 1 1 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel,
            triView, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[12]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[13]);
    assertEquals("    O", ap.toString().split("\n")[14]);
    assertEquals("   _ O", ap.toString().split("\n")[15]);
    assertEquals("  _ O O", ap.toString().split("\n")[16]);
    assertEquals(" O O O O", ap.toString().split("\n")[17]);
    assertEquals("O O O O O", ap.toString().split("\n")[18]);
    assertEquals("Score: 13", ap.toString().split("\n")[19]);
  }

  @Test
  public void testQuitAfterTwoValidMove() {
    Reader in = new StringReader("2 4 4 4 5 4 3 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();


    assertEquals("Game quit!", ap.toString().split("\n")[24]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[25]);
    assertEquals("    O O O", ap.toString().split("\n")[26]);
    assertEquals("    O _ O", ap.toString().split("\n")[27]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[28]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[29]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[30]);
    assertEquals("    O O O", ap.toString().split("\n")[31]);
    assertEquals("    O O O", ap.toString().split("\n")[32]);
    assertEquals("Score: 30", ap.toString().split("\n")[33]);
  }

  @Test
  public void euroTestQuitAfterTwoValidMove() {
    Reader in = new StringReader("2 4 4 4 5 4 3 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();


    assertEquals("Game quit!", ap.toString().split("\n")[24]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[25]);
    assertEquals("    O O O", ap.toString().split("\n")[26]);
    assertEquals("  O O _ O O", ap.toString().split("\n")[27]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[28]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[29]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[30]);
    assertEquals("  O O O O O", ap.toString().split("\n")[31]);
    assertEquals("    O O O", ap.toString().split("\n")[32]);
    assertEquals("Score: 34", ap.toString().split("\n")[33]);
  }

  @Test
  public void triTestQuitAfterTwoValidMove() {
    Reader in = new StringReader("3 1 1 1 3 3 3 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[18]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[19]);
    assertEquals("    O", ap.toString().split("\n")[20]);
    assertEquals("   _ O", ap.toString().split("\n")[21]);
    assertEquals("  O _ _", ap.toString().split("\n")[22]);
    assertEquals(" O O O O", ap.toString().split("\n")[23]);
    assertEquals("O O O O O", ap.toString().split("\n")[24]);
    assertEquals("Score: 12", ap.toString().split("\n")[25]);
  }

  @Test
  public void testFirstQuit() {
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[8]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("    O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[13]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("    O O O", ap.toString().split("\n")[16]);
    assertEquals("Score: 32", ap.toString().split("\n")[17]);
  }

  @Test
  public void euroTestFirstQuit() {
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[8]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("  O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[13]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[14]);
    assertEquals("  O O O O O", ap.toString().split("\n")[15]);
    assertEquals("    O O O", ap.toString().split("\n")[16]);
    assertEquals("Score: 36", ap.toString().split("\n")[17]);
  }

  @Test
  public void triTestFirstQuit() {
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[6]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[7]);
    assertEquals("    _", ap.toString().split("\n")[8]);
    assertEquals("   O O", ap.toString().split("\n")[9]);
    assertEquals("  O O O", ap.toString().split("\n")[10]);
    assertEquals(" O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O", ap.toString().split("\n")[12]);
    assertEquals("Score: 14", ap.toString().split("\n")[13]);
  }

  @Test
  public void testFirstQuitCapital() {
    Reader in = new StringReader("Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[8]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("    O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[13]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("    O O O", ap.toString().split("\n")[16]);
    assertEquals("Score: 32", ap.toString().split("\n")[17]);
  }

  @Test
  public void euroTestFirstQuitCapital() {
    Reader in = new StringReader("Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[8]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("  O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[13]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[14]);
    assertEquals("  O O O O O", ap.toString().split("\n")[15]);
    assertEquals("    O O O", ap.toString().split("\n")[16]);
    assertEquals("Score: 36", ap.toString().split("\n")[17]);
  }

  @Test
  public void triTestFirstQuitCapital() {
    Reader in = new StringReader("Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView, in);
    controller.playGame();

    assertEquals("Game quit!", ap.toString().split("\n")[6]);
    assertEquals("State of game when quit:", ap.toString().split("\n")[7]);
    assertEquals("    _", ap.toString().split("\n")[8]);
    assertEquals("   O O", ap.toString().split("\n")[9]);
    assertEquals("  O O O", ap.toString().split("\n")[10]);
    assertEquals(" O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O", ap.toString().split("\n")[12]);
    assertEquals("Score: 14", ap.toString().split("\n")[13]);
  }

  @Test
  public void testGameOver() {
    Reader in = new StringReader("2 4 4 4 5 4 3 4 7 4 5 4 4 2 4 4 4 5 4 3 4 7 4 5");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("Game over!", ap.toString().split("\n")[56]);
    assertEquals("    O O O", ap.toString().split("\n")[57]);
    assertEquals("    O _ O", ap.toString().split("\n")[58]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[59]);
    assertEquals("O _ O _ O _ _", ap.toString().split("\n")[60]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[61]);
    assertEquals("    O _ O", ap.toString().split("\n")[62]);
    assertEquals("    O _ O", ap.toString().split("\n")[63]);
    assertEquals("Score: 26", ap.toString().split("\n")[64]);
  }

  @Test
  public void euroTestGameOver() {
    Reader in = new StringReader("3 2 3 4 1 3 3 3 5 2 3 2 5 4 5 2 3 4 5 4 2 5 2 3 " +
            "3 2 3 4 " +
            "1 5 1 3 5 5 5 3 4 5 2 5 7 4 5 4 2 2 2 4 5 7 5 5 6 2 4 2 3 7 3 5 2 5 2 3 " +
            "1 3 3 3 4 7 4 5 5 4 5 2 7 3 5 3 3 4 3 2 5 2 5 4 6 6 6 4 3 1 3 3 3 3 5 3 " +
            "4 5 6 5 5 4 5 2 4 1 4 3 7 5 5 5 5 1 5 3 4 3 6 3 6 3 6 5 6 5 4 5 4 5 2 5 " +
            "2 6 2 4");
    MarbleSolitaireModel test = new EuropeanSolitaireModel(2, 3);
    MarbleSolitaireView testView = new MarbleSolitaireTextView(test, ap);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(test, testView, in);
    controller.playGame();

    assertEquals("Game over!", ap.toString().split("\n")[288]);
    assertEquals("    _ _ _", ap.toString().split("\n")[289]);
    assertEquals("  _ _ O _ _", ap.toString().split("\n")[290]);
    assertEquals("_ _ _ _ _ _ _", ap.toString().split("\n")[291]);
    assertEquals("_ _ _ _ _ _ _", ap.toString().split("\n")[292]);
    assertEquals("_ _ _ _ _ _ _", ap.toString().split("\n")[293]);
    assertEquals("  _ _ _ _ _", ap.toString().split("\n")[294]);
    assertEquals("    _ _ _", ap.toString().split("\n")[295]);
    assertEquals("Score: 1", ap.toString().split("\n")[296]);
  }

  @Test
  public void triTestGameOver() {
    Reader in = new StringReader("3 1 1 1 3 3 3 1 5 5 3 3 2 2 4 4 5 3 3 3 5 1 5 3 " +
            "5 4 5 2 5 2 3 2" +
            " 4 4 2 2 4 1 2 1 1 1 3 1 3 1 3 3 3 3 1 1");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView, in);
    controller.playGame();

    assertEquals("Game over!", ap.toString().split("\n")[84]);
    assertEquals("    O", ap.toString().split("\n")[85]);
    assertEquals("   _ _", ap.toString().split("\n")[86]);
    assertEquals("  _ _ _", ap.toString().split("\n")[87]);
    assertEquals(" _ _ _ _", ap.toString().split("\n")[88]);
    assertEquals("_ _ _ _ _", ap.toString().split("\n")[89]);
    assertEquals("Score: 1", ap.toString().split("\n")[90]);
  }

  @Test
  public void testInvalidMove() {
    Reader in = new StringReader("1 4 3 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("    O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("    O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 32", ap.toString().split("\n")[7]);
    assertEquals("Invalid move. Play again.", ap.toString().split("\n")[8]);
  }

  @Test
  public void euroTestInvalidMove() {
    Reader in = new StringReader("1 4 3 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("  O O O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("  O O O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 36", ap.toString().split("\n")[7]);
    assertEquals("Invalid move. Play again.", ap.toString().split("\n")[8]);
  }

  @Test
  public void triTestInvalidMove() {
    Reader in = new StringReader("4 1 2 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("    _", ap.toString().split("\n")[0]);
    assertEquals("   O O", ap.toString().split("\n")[1]);
    assertEquals("  O O O", ap.toString().split("\n")[2]);
    assertEquals(" O O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O", ap.toString().split("\n")[4]);
    assertEquals("Score: 14", ap.toString().split("\n")[5]);
    assertEquals("Invalid move. Play again.", ap.toString().split("\n")[6]);
  }

  @Test
  public void testInvalidInputLetter() {
    Reader in = new StringReader("1 r q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("    O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("    O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 32", ap.toString().split("\n")[7]);
    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
  }

  @Test
  public void euroTestInvalidInputLetter() {
    Reader in = new StringReader("1 e q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("  O O O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("  O O O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 36", ap.toString().split("\n")[7]);
    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
  }

  @Test
  public void triTestInvalidInputLetter() {
    Reader in = new StringReader("3 t q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("    _", ap.toString().split("\n")[0]);
    assertEquals("   O O", ap.toString().split("\n")[1]);
    assertEquals("  O O O", ap.toString().split("\n")[2]);
    assertEquals(" O O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O", ap.toString().split("\n")[4]);
    assertEquals("Score: 14", ap.toString().split("\n")[5]);
    assertEquals("The input given is invalid. Try again.",
            ap.toString().split("\n")[6]);
  }

  @Test
  public void testInvalidInputSymbol() {
    Reader in = new StringReader("2 4 @ q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("    O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("    O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 32", ap.toString().split("\n")[7]);
    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
  }

  @Test
  public void euroTestInvalidInputSymbol() {
    Reader in = new StringReader("2 4 % q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("  O O O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("  O O O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 36", ap.toString().split("\n")[7]);
    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
  }

  @Test
  public void triTestInvalidInputSymbol() {
    Reader in = new StringReader("3 1 # q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("    _", ap.toString().split("\n")[0]);
    assertEquals("   O O", ap.toString().split("\n")[1]);
    assertEquals("  O O O", ap.toString().split("\n")[2]);
    assertEquals(" O O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O", ap.toString().split("\n")[4]);
    assertEquals("Score: 14", ap.toString().split("\n")[5]);
    assertEquals("The input given is invalid. Try again.",
            ap.toString().split("\n")[6]);
  }

  @Test
  public void testInvalidNegativeNumberInput() {
    Reader in = new StringReader("2 4 4 -1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("    O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("    O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 32", ap.toString().split("\n")[7]);
    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
  }

  @Test
  public void euroTestInvalidNegativeNumberInput() {
    Reader in = new StringReader("2 4 4 -4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("    O O O", ap.toString().split("\n")[0]);
    assertEquals("  O O O O O", ap.toString().split("\n")[1]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[4]);
    assertEquals("  O O O O O", ap.toString().split("\n")[5]);
    assertEquals("    O O O", ap.toString().split("\n")[6]);
    assertEquals("Score: 36", ap.toString().split("\n")[7]);
    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
  }

  @Test
  public void triTestInvalidNegativeNumberInput() {
    Reader in = new StringReader("3 1 1 -1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("    _", ap.toString().split("\n")[0]);
    assertEquals("   O O", ap.toString().split("\n")[1]);
    assertEquals("  O O O", ap.toString().split("\n")[2]);
    assertEquals(" O O O O", ap.toString().split("\n")[3]);
    assertEquals("O O O O O", ap.toString().split("\n")[4]);
    assertEquals("Score: 14", ap.toString().split("\n")[5]);
    assertEquals("The input given is invalid. Try again.",
            ap.toString().split("\n")[6]);
  }

  @Test
  public void testInvalidFromRowThenValid() {
    Reader in = new StringReader("k 2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("    O _ O", ap.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[13]);
    assertEquals("    O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 31", ap.toString().split("\n")[16]);
  }

  @Test
  public void euroTestInvalidFromRowThenValid() {
    Reader in = new StringReader("e 2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("  O O _ O O", ap.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[13]);
    assertEquals("  O O O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 35", ap.toString().split("\n")[16]);
  }

  @Test
  public void triTestInvalidFromRowThenValid() {
    Reader in = new StringReader("t 3 1 1 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [6]);
    assertEquals("    O", ap.toString().split("\n")[7]);
    assertEquals("   _ O", ap.toString().split("\n")[8]);
    assertEquals("  _ O O", ap.toString().split("\n")[9]);
    assertEquals(" O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O", ap.toString().split("\n")[11]);
    assertEquals("Score: 13", ap.toString().split("\n")[12]);
  }

  @Test
  public void testInvalidFromColThenValid() {
    Reader in = new StringReader("6 # 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[13]);
    assertEquals("    O _ O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 31", ap.toString().split("\n")[16]);
  }

  @Test
  public void euroTestInvalidFromColThenValid() {
    Reader in = new StringReader("6 ^ 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("  O O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", ap.toString().split("\n")[13]);
    assertEquals("  O O _ O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 35", ap.toString().split("\n")[16]);
  }

  @Test
  public void triTestInvalidFromColThenValid() {
    Reader in = new StringReader("3 $ 1 1 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [6]);
    assertEquals("    O", ap.toString().split("\n")[7]);
    assertEquals("   _ O", ap.toString().split("\n")[8]);
    assertEquals("  _ O O", ap.toString().split("\n")[9]);
    assertEquals(" O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O", ap.toString().split("\n")[11]);
    assertEquals("Score: 13", ap.toString().split("\n")[12]);
  }

  @Test
  public void testInvalidToRowThenValid() {
    Reader in = new StringReader("4 6 R 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O _ _ O", ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[13]);
    assertEquals("    O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 31", ap.toString().split("\n")[16]);
  }

  @Test
  public void euroTestInvalidToRowThenValid() {
    Reader in = new StringReader("4 6 E 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("  O O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O O O O _ _ O", ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[13]);
    assertEquals("  O O O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 35", ap.toString().split("\n")[16]);
  }

  @Test
  public void triTestInvalidToRowThenValid() {
    Reader in = new StringReader("3 3 T 1 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [6]);
    assertEquals("    O", ap.toString().split("\n")[7]);
    assertEquals("   O _", ap.toString().split("\n")[8]);
    assertEquals("  O O _", ap.toString().split("\n")[9]);
    assertEquals(" O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O", ap.toString().split("\n")[11]);
    assertEquals("Score: 13", ap.toString().split("\n")[12]);
  }

  @Test
  public void testInvalidToColThenValid() {
    Reader in = new StringReader("4 2 4 -8 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("    O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O _ _ O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[13]);
    assertEquals("    O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 31", ap.toString().split("\n")[16]);
  }

  @Test
  public void euroTestInvalidToColThenValid() {
    Reader in = new StringReader("4 2 4 -2 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(euroModel, euroView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [8]);
    assertEquals("    O O O", ap.toString().split("\n")[9]);
    assertEquals("  O O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[11]);
    assertEquals("O _ _ O O O O", ap.toString().split("\n")[12]);
    assertEquals("O O O O O O O", ap.toString().split("\n")[13]);
    assertEquals("  O O O O O", ap.toString().split("\n")[14]);
    assertEquals("    O O O", ap.toString().split("\n")[15]);
    assertEquals("Score: 35", ap.toString().split("\n")[16]);
  }

  @Test
  public void triTestInvalidToColThenValid() {
    Reader in = new StringReader("3 3 1 -3 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(triModel, triView,
            in);
    controller.playGame();

    assertEquals("The input given is invalid. Try again.", ap.toString().split("\n")
            [6]);
    assertEquals("    O", ap.toString().split("\n")[7]);
    assertEquals("   O _", ap.toString().split("\n")[8]);
    assertEquals("  O O _", ap.toString().split("\n")[9]);
    assertEquals(" O O O O", ap.toString().split("\n")[10]);
    assertEquals("O O O O O", ap.toString().split("\n")[11]);
    assertEquals("Score: 13", ap.toString().split("\n")[12]);
  }

  @Test
  public void testIllegalStateExceptionReader() {
    Reader in = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    MarbleSolitaireController euroController = new MarbleSolitaireControllerImpl(euroModel,
            euroView, in);
    MarbleSolitaireController triController = new MarbleSolitaireControllerImpl(triModel, triView
            , in);

    try {
      controller.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "There is no input.");
    }

    try {
      euroController.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "There is no input.");
    }

    try {
      triController.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "There is no input.");
    }
  }

  @Test
  public void testIllegalStateExceptionNoHasNext() {
    Reader in = new StringReader("2 4 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, in);
    MarbleSolitaireController euroController = new MarbleSolitaireControllerImpl(euroModel,
            euroView, in);
    MarbleSolitaireController triController = new MarbleSolitaireControllerImpl(triModel, triView
            , in);

    try {
      controller.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "There is no input.");
    }

    try {
      euroController.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "There is no input.");
    }

    try {
      triController.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "There is no input.");
    }
  }

  @Test
  public void testIllegalStateExceptionAppendable() {
    Reader in = new StringReader("2 4 4 4 q");
    Appendable corrupt = new CorruptAppendable();
    MarbleSolitaireView corruptView = new MarbleSolitaireTextView(model, corrupt);
    MarbleSolitaireView triCorruptView = new MarbleSolitaireTextView(triModel, corrupt);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, corruptView,
            in);
    MarbleSolitaireController euroController = new MarbleSolitaireControllerImpl(euroModel,
            corruptView, in);
    MarbleSolitaireController triController = new MarbleSolitaireControllerImpl(triModel,
            triCorruptView, in);

    try {
      controller.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }

    try {
      euroController.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }

    try {
      triController.playGame();
      fail("Should throw an IllegalStateException.");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }
  }

  @Test
  public void testNullModelController() {
    Reader in = new StringReader("q");
    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(null, view,
              in);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(null,
              euroView, in);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(null, triView,
              in);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testNullReadableController() {
    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(model, view,
              null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(euroModel, euroView,
              null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(triModel, triView,
              null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testNullViewController() {
    Reader in = new StringReader("q");
    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(model, null,
              in);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(euroModel, null,
              in);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(triModel, null,
              in);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testAllNullController() {
    try {
      MarbleSolitaireController invalidCon = new MarbleSolitaireControllerImpl(null, null,
              null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testValidControllerInput() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockModel(log);
    Reader in = new StringReader("2 4 4 4 q");
    MarbleSolitaireView mockView = new MarbleSolitaireTextView(mockModel, ap);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel, mockView,
            in);
    controller.playGame();

    assertEquals("fromRow = 1, fromCol = 3, toRow = 3, toCol = 3\n", log.toString());
  }

  @Test
  public void testInvalidControllerInput() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockModel(log);
    Reader in = new StringReader("2 k 4 4 q");
    MarbleSolitaireView mockView = new MarbleSolitaireTextView(mockModel, ap);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel, mockView,
            in);
    controller.playGame();

    assertEquals("", log.toString());
  }

  @Test
  public void testInvalidMoveInput() {
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockModel(log);
    Reader in = new StringReader("11 4 4 10 q");
    MarbleSolitaireView mockView = new MarbleSolitaireTextView(mockModel, ap);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mockModel, mockView,
            in);
    controller.playGame();

    assertEquals("fromRow = 10, fromCol = 3, toRow = 3, toCol = 9\n", log.toString());
  }
}