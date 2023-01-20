import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.CorruptAppendable;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * The tests for the MarbleSolitaireTextView class.
 */
public class MarbleSolitaireTextViewTest {

  private MarbleSolitaireView view1;
  private MarbleSolitaireView view2;
  private MarbleSolitaireView view3;
  private MarbleSolitaireView view4;
  private MarbleSolitaireView view5;
  private MarbleSolitaireView newView1;
  private MarbleSolitaireModel model;
  private MarbleSolitaireModel euroModel;
  private MarbleSolitaireView euroView;
  private MarbleSolitaireView euroView2;
  private MarbleSolitaireView euroView3;
  private MarbleSolitaireView euroView4;
  private MarbleSolitaireView newEuroView;

  @Before
  public void init() {
    Appendable corruptDest = new CorruptAppendable();
    model = new EnglishSolitaireModel();
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(0, 2);
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(6, 4);
    MarbleSolitaireModel model4 = new EnglishSolitaireModel(5);
    MarbleSolitaireModel model5 = new EnglishSolitaireModel(5, 4, 5);
    view1 = new MarbleSolitaireTextView(model);
    view2 = new MarbleSolitaireTextView(model2);
    view3 = new MarbleSolitaireTextView(model3);
    view4 = new MarbleSolitaireTextView(model4);
    view5 = new MarbleSolitaireTextView(model5);
    newView1 = new MarbleSolitaireTextView(model, corruptDest);

    euroModel = new EuropeanSolitaireModel();
    MarbleSolitaireModel euroModel2 = new EuropeanSolitaireModel(0, 2);
    MarbleSolitaireModel euroModel3 = new EuropeanSolitaireModel(5);
    MarbleSolitaireModel euroModel4 = new EuropeanSolitaireModel(5, 4, 5);
    euroView = new MarbleSolitaireTextView(euroModel);
    euroView2 = new MarbleSolitaireTextView(euroModel2);
    euroView3 = new MarbleSolitaireTextView(euroModel3);
    euroView4 = new MarbleSolitaireTextView(euroModel4);
    newEuroView = new MarbleSolitaireTextView(euroModel, corruptDest);
  }


  @Test
  public void invalidView() {
    try {
      MarbleSolitaireView invalidView = new MarbleSolitaireTextView(null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());

    model.move(1, 3, 3, 3);

    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());

    assertEquals("    _ O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view2.toString());

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O _", view3.toString());

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", view4.toString());

    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", view5.toString());

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView.toString());

    euroModel.move(1, 3, 3, 3);

    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView.toString());

    assertEquals("    _ O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euroView2.toString());

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroView3.toString());

    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", euroView4.toString());
  }

  @Test
  public void testNullAppendableView() {
    try {
      MarbleSolitaireView nullAp = new MarbleSolitaireTextView(model, null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }

    try {
      MarbleSolitaireView nullAp = new MarbleSolitaireTextView(euroModel, null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testAllNullView() {
    try {
      MarbleSolitaireView allNull = new MarbleSolitaireTextView(null, null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testRenderBoard() {
    MarbleSolitaireModel testModel = new EnglishSolitaireModel();
    Appendable dest = new StringBuilder();
    MarbleSolitaireView newView = new MarbleSolitaireTextView(testModel, dest);
    try {
      newView.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n", dest.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    testModel.move(5, 3, 3, 3);
    Appendable dest2 = new StringBuilder();
    MarbleSolitaireView newView2 = new MarbleSolitaireTextView(testModel, dest2);
    try {
      newView2.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "    O _ O\n" +
              "    O O O\n", dest2.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    MarbleSolitaireModel euroTest = new EuropeanSolitaireModel();
    Appendable euroDest = new StringBuilder();
    MarbleSolitaireView euroView = new MarbleSolitaireTextView(euroTest, euroDest);
    try {
      euroView.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O\n", euroDest.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    euroTest.move(5, 3, 3, 3);
    Appendable euroDest2 = new StringBuilder();
    MarbleSolitaireView euroView2 = new MarbleSolitaireTextView(euroTest, euroDest2);
    try {
      euroView2.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "  O O _ O O\n" +
              "    O O O\n", euroDest2.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }
  }

  @Test
  public void testRenderMessage() {
    MarbleSolitaireModel testModel = new EnglishSolitaireModel();
    Appendable dest = new StringBuilder();
    MarbleSolitaireView newView = new MarbleSolitaireTextView(testModel, dest);
    String testMessage = "test";
    try {
      newView.renderMessage(testMessage);
      assertEquals("test", dest.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    Appendable dest2 = new StringBuilder();
    MarbleSolitaireView newView2 = new MarbleSolitaireTextView(testModel, dest2);
    String testMessage2 = "12345";
    try {
      newView2.renderMessage(testMessage2);
      assertEquals("12345", dest2.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    MarbleSolitaireModel euroTest = new EuropeanSolitaireModel();
    Appendable euroDest = new StringBuilder();
    MarbleSolitaireView euroView = new MarbleSolitaireTextView(euroTest, euroDest);
    String euroTestMessage = "test";
    try {
      euroView.renderMessage(euroTestMessage);
      assertEquals("test", euroDest.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    Appendable euroDest2 = new StringBuilder();
    MarbleSolitaireView euroView2 = new MarbleSolitaireTextView(euroTest, euroDest2);
    String euroTestMessage2 = "12345";
    try {
      euroView2.renderMessage(euroTestMessage2);
      assertEquals("12345", euroDest2.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }
  }

  @Test
  public void testRenderBoardIOException() {
    try {
      newView1.renderBoard();
      fail("Should throw an IOException.");
    } catch (IOException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }

    try {
      newEuroView.renderBoard();
      fail("Should throw an IOException.");
    } catch (IOException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }
  }

  @Test
  public void testRenderMessageIOException() {
    String message = "";
    try {
      newView1.renderMessage(message);
      fail("Should throw an IOException.");
    } catch (IOException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }

    String message2 = "";
    try {
      newEuroView.renderMessage(message2);
      fail("Should throw an IOException.");
    } catch (IOException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }
  }
}