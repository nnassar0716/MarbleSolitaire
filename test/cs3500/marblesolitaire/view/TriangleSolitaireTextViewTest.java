package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.CorruptAppendable;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * The tests for the TriangleSolitaireTextView class.
 */

public class TriangleSolitaireTextViewTest {

  private MarbleSolitaireModel triModel;
  private TriangleSolitaireTextView view;
  private TriangleSolitaireTextView view2;
  private TriangleSolitaireTextView view3;
  private TriangleSolitaireTextView view4;
  private TriangleSolitaireTextView newView;

  @Before
  public void init() {
    Appendable corruptDest = new CorruptAppendable();
    triModel = new TriangleSolitaireModel();
    MarbleSolitaireModel triModel2 = new TriangleSolitaireModel(6);
    MarbleSolitaireModel triModel3 = new TriangleSolitaireModel(2, 1);
    MarbleSolitaireModel triModel4 = new TriangleSolitaireModel(7, 4, 1);
    view = new TriangleSolitaireTextView(triModel);
    view2 = new TriangleSolitaireTextView(triModel2);
    view3 = new TriangleSolitaireTextView(triModel3);
    view4 = new TriangleSolitaireTextView(triModel4);
    newView = new TriangleSolitaireTextView(triModel, corruptDest);
  }

  @Test
  public void nullModel() {
    try {
      MarbleSolitaireView invalidView = new TriangleSolitaireTextView(null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void nullAppendable() {
    try {
      MarbleSolitaireView nullAp = new MarbleSolitaireTextView(triModel, null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void allNull() {
    try {
      MarbleSolitaireView allNull = new MarbleSolitaireTextView(null, null);
      fail("Should throw an IllegalArgumentException.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The given parameters cannot be null.");
    }
  }

  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", view.toString());

    triModel.move(2, 0, 0, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", view.toString());

    assertEquals("     _\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "O O O O O O", view2.toString());

    assertEquals("    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", view3.toString());

    assertEquals("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O _ O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", view4.toString());
  }

  @Test
  public void testRenderBoard() {
    MarbleSolitaireModel testModel = new TriangleSolitaireModel();
    Appendable dest = new StringBuilder();
    MarbleSolitaireView newView = new TriangleSolitaireTextView(testModel, dest);
    try {
      newView.renderBoard();
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O\n", dest.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    testModel.move(2, 2, 0, 0);
    Appendable dest2 = new StringBuilder();
    MarbleSolitaireView newView2 = new TriangleSolitaireTextView(testModel, dest2);
    try {
      newView2.renderBoard();
      assertEquals("    O\n" +
              "   O _\n" +
              "  O O _\n" +
              " O O O O\n" +
              "O O O O O\n", dest2.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }
  }

  @Test
  public void testRenderMessage() {
    MarbleSolitaireModel testModel = new TriangleSolitaireModel();
    Appendable dest = new StringBuilder();
    MarbleSolitaireView newView = new TriangleSolitaireTextView(testModel, dest);
    String testMessage = "test";
    try {
      newView.renderMessage(testMessage);
      assertEquals("test", dest.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }

    Appendable dest2 = new StringBuilder();
    MarbleSolitaireView newView2 = new TriangleSolitaireTextView(testModel, dest2);
    String testMessage2 = "12345";
    try {
      newView2.renderMessage(testMessage2);
      assertEquals("12345", dest2.toString());
    } catch (IOException e) {
      // should never happen since a valid appendable was given
    }
  }

  @Test
  public void testRenderBoardIOException() {
    try {
      newView.renderBoard();
      fail("Should throw an IOException.");
    } catch (IOException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }
  }

  @Test
  public void testRenderMessageIOException() {
    String message = "";
    try {
      newView.renderMessage(message);
      fail("Should throw an IOException.");
    } catch (IOException e) {
      assertEquals(e.getMessage(), "An IOException was thrown.");
    }
  }
}