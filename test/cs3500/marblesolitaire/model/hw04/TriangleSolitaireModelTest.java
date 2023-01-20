package cs3500.marblesolitaire.model.hw04;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * The tests for the TriangleSolitaireModel class.
 */
public class TriangleSolitaireModelTest {

  private MarbleSolitaireModel model1;
  private MarbleSolitaireModel model2;
  private MarbleSolitaireModel model3;
  private MarbleSolitaireModel model4;


  @Before
  public void init() {
    model1 = new TriangleSolitaireModel();
    model2 = new TriangleSolitaireModel(4, 2);
    model3 = new TriangleSolitaireModel(7);
    model4 = new TriangleSolitaireModel(6, 3, 1);
  }

  @Test
  public void testConstructorException() {
    // tries to make a model with an invalid empty position
    try {
      TriangleSolitaireModel invalidEmptyPos = new TriangleSolitaireModel(0, 1);
      fail("The position (0, 1) is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (0, 1)");
    }
    // tries to make a model with a negative dimension
    try {
      TriangleSolitaireModel invalidArmThick = new TriangleSolitaireModel(-2);
      fail("The dimension cannot be negative.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The arm thickness must be a positive number.");
    }
    // tries to make a model that takes in a valid arm thickness and an invalid empty position
    try {
      TriangleSolitaireModel invalidEmptyPos = new TriangleSolitaireModel(6, 1, 2);
      fail("The position (1, 2) is invalid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (1, 2)");
    }
  }

  @Test
  public void testValidConstructor() {
    MarbleSolitaireModel testModel = new TriangleSolitaireModel();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (j <= i && (i != 0 && j != 0)) {
          assertEquals(Marble, testModel.getSlotAt(i, j));
        } else if (i == 0 && j == 0) {
          assertEquals(Empty, testModel.getSlotAt(i, j));
        } else if (j > i) {
          assertEquals(Invalid, testModel.getSlotAt(i, j));
        }
      }
    }

    MarbleSolitaireModel testModel2 = new TriangleSolitaireModel(2, 1);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (j <= i && (i != 2 && j != 1)) {
          assertEquals(Marble, testModel2.getSlotAt(i, j));
        } else if (i == 2 && j == 1) {
          assertEquals(Empty, testModel2.getSlotAt(i, j));
        } else if (j > i) {
          assertEquals(Invalid, testModel2.getSlotAt(i, j));
        }
      }
    }

    MarbleSolitaireModel testModel3 = new TriangleSolitaireModel(6);
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        if (j <= i && (i != 0 && j != 0)) {
          assertEquals(Marble, testModel3.getSlotAt(i, j));
        } else if (i == 0 && j == 0) {
          assertEquals(Empty, testModel3.getSlotAt(i, j));
        } else if (j > i) {
          assertEquals(Invalid, testModel3.getSlotAt(i, j));
        }
      }
    }

    MarbleSolitaireModel testModel4 = new TriangleSolitaireModel(5, 4, 3);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (j <= i && (i != 4 && j != 3)) {
          assertEquals(Marble, testModel4.getSlotAt(i, j));
        } else if (i == 4 && j == 3) {
          assertEquals(Empty, testModel4.getSlotAt(i, j));
        } else if (j > i) {
          assertEquals(Invalid, testModel4.getSlotAt(i, j));
        }
      }
    }
  }

  @Test
  public void move() {
    assertEquals(Marble, model2.getSlotAt(2, 0));
    assertEquals(Marble, model2.getSlotAt(3, 1));
    assertEquals(Empty, model2.getSlotAt(4, 2));

    model2.move(2, 0, 4, 2);

    assertEquals(Empty, model2.getSlotAt(2, 0));
    assertEquals(Empty, model2.getSlotAt(3, 1));
    assertEquals(Marble, model2.getSlotAt(4, 2));

    model2 = new TriangleSolitaireModel(4, 2);

    assertEquals(Marble, model2.getSlotAt(2, 2));
    assertEquals(Marble, model2.getSlotAt(3, 2));
    assertEquals(Empty, model2.getSlotAt(4, 2));

    model2.move(2, 2, 4, 2);

    assertEquals(Empty, model2.getSlotAt(2, 2));
    assertEquals(Empty, model2.getSlotAt(3, 2));
    assertEquals(Marble, model2.getSlotAt(4, 2));

    model2 = new TriangleSolitaireModel(4, 2);

    assertEquals(Marble, model2.getSlotAt(4, 0));
    assertEquals(Marble, model2.getSlotAt(4, 1));
    assertEquals(Empty, model2.getSlotAt(4, 2));

    model2.move(4, 0, 4, 2);

    assertEquals(Empty, model2.getSlotAt(4, 0));
    assertEquals(Empty, model2.getSlotAt(4, 1));
    assertEquals(Marble, model2.getSlotAt(4, 2));

    model2 = new TriangleSolitaireModel(4, 2);

    assertEquals(Marble, model2.getSlotAt(4, 4));
    assertEquals(Marble, model2.getSlotAt(4, 3));
    assertEquals(Empty, model2.getSlotAt(4, 2));

    model2.move(4, 4, 4, 2);

    assertEquals(Empty, model2.getSlotAt(4, 4));
    assertEquals(Empty, model2.getSlotAt(4, 3));
    assertEquals(Marble, model2.getSlotAt(4, 2));

    model2 = new TriangleSolitaireModel(2, 1);

    assertEquals(Marble, model2.getSlotAt(4, 1));
    assertEquals(Marble, model2.getSlotAt(3, 1));
    assertEquals(Empty, model2.getSlotAt(2, 1));

    model2.move(4, 1, 2, 1);

    assertEquals(Empty, model2.getSlotAt(4, 1));
    assertEquals(Empty, model2.getSlotAt(3, 1));
    assertEquals(Marble, model2.getSlotAt(2, 1));

    model2 = new TriangleSolitaireModel(2, 1);

    assertEquals(Marble, model2.getSlotAt(4, 3));
    assertEquals(Marble, model2.getSlotAt(3, 2));
    assertEquals(Empty, model2.getSlotAt(2, 1));

    model2.move(4, 3, 2, 1);

    assertEquals(Empty, model2.getSlotAt(4, 3));
    assertEquals(Empty, model2.getSlotAt(3, 2));
    assertEquals(Marble, model2.getSlotAt(2, 1));

    try {
      model1.move(7, 0, 2, 2);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 2, 7, 0);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(0, 0, 2, 2);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 2, 4, 2);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(7, 0, 2, 2);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 0, 0, 0);
      model1.move(3, 0, 1, 0);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(3, 3, 0, 0);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }
  }

  @Test
  public void isGameOver() {
    assertFalse(model1.isGameOver());

    model1.move(2, 0, 0, 0);
    model1.move(2, 2, 2, 0);
    model1.move(4, 4, 2, 2);
    model1.move(1, 1, 3, 3);
    model1.move(4, 2, 2, 2);
    model1.move(4, 0, 4, 2);
    model1.move(4, 3, 4, 1);
    model1.move(4, 1, 2, 1);
    model1.move(3, 3, 1, 1);
    model1.move(3, 0, 1, 0);
    model1.move(0, 0, 2, 0);
    model1.move(2, 0, 2, 2);
    model1.move(2, 2, 0, 0);

    assertTrue(model1.isGameOver());
  }

  @Test
  public void getBoardSize() {
    assertEquals(5, model1.getBoardSize());
    assertEquals(5, model2.getBoardSize());
    assertEquals(7, model3.getBoardSize());
    assertEquals(6, model4.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    assertEquals(Marble, model1.getSlotAt(1, 0));
    assertEquals(Empty, model1.getSlotAt(0, 0));
    assertEquals(Invalid, model1.getSlotAt(0, 1));

    assertEquals(Marble, model2.getSlotAt(4, 4));
    assertEquals(Empty, model2.getSlotAt(4, 2));
    assertEquals(Invalid, model2.getSlotAt(3, 4));

    try {
      model1.getSlotAt(7, 3);
      fail("This position is outside the dimensions of the board.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This position is outside the dimensions of the board.");
    }
    try {
      model1.getSlotAt(3, 7);
      fail("This position is outside the dimensions of the board.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This position is outside the dimensions of the board.");
    }
    try {
      model1.getSlotAt(9, 10);
      fail("This position is outside the dimensions of the board.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This position is outside the dimensions of the board.");
    }
  }

  @Test
  public void getScore() {
    assertEquals(14, model1.getScore());
    model1.move(2, 0, 0, 0);
    assertEquals(13, model1.getScore());
    model1.move(4, 0, 2, 0);
    assertEquals(12, model1.getScore());
  }

}