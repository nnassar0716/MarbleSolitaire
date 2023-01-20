import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Empty;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Invalid;
import static cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState.SlotState.Marble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * The tests for the EnglishSolitaireModel class.
 */
public class EnglishSolitaireModelTest {
  private MarbleSolitaireModel model1;
  private MarbleSolitaireModel model2;
  private MarbleSolitaireModel model3;
  private MarbleSolitaireModel model4;


  @Before
  public void init() {
    model1 = new EnglishSolitaireModel();
    model2 = new EnglishSolitaireModel(0, 2);
    model3 = new EnglishSolitaireModel(5);
    model4 = new EnglishSolitaireModel(3, 4, 5);
  }

  @Test
  public void testConstructorException() {
    // tries to make a model with an invalid empty position
    try {
      EnglishSolitaireModel invalidEmptyPos = new EnglishSolitaireModel(0, 0);
      fail("The position (0, 0) is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (0, 0)");
    }
    // tries to make a model with a negative, even arm thickness
    try {
      EnglishSolitaireModel invalidArmThick = new EnglishSolitaireModel(-2);
      fail("The arm thickness cannot be negative.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The arm thickness must be a positive number.");
    }
    // tries to make a model that takes in an even arm thickness and an invalid empty position
    try {
      EnglishSolitaireModel invalidArmThick = new EnglishSolitaireModel(4, 3, 3);
      fail("The arm thickness cannot be even.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "The arm thickness cannot be even.");
    }
    // tries to make a model that takes in a valid arm thickness and an invalid empty position
    try {
      EnglishSolitaireModel invalidEmptyPos = new EnglishSolitaireModel(3, 5, 0);
      fail("The position (5, 0) is invalid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Invalid empty cell position (5, 0)");
    }
  }

  @Test
  public void testValidConstructor() {
    MarbleSolitaireModel testModel = new EnglishSolitaireModel();
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if ((i < 2 && j < 2)
                || (i < 2 && j >= (3 + 2))
                || (i >= (3 + 2) && j < 2)
                || (i >= (3 + 2) && j >= (3 + 2))) {
          assertEquals(Invalid, testModel.getSlotAt(i, j));
        } else if (i == 3 && j == 3) {
          assertEquals(Empty, testModel.getSlotAt(i, j));
        } else {
          assertEquals(Marble, testModel.getSlotAt(i, j));
        }
      }
    }

    MarbleSolitaireModel testModel2 = new EnglishSolitaireModel(0, 2);
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if ((i < 2 && j < 2)
                || (i < 2 && j >= (3 + 2))
                || (i >= (3 + 2) && j < 2)
                || (i >= (3 + 2) && j >= (3 + 2))) {
          assertEquals(Invalid, testModel2.getSlotAt(i, j));
        } else if (i == 0 && j == 2) {
          assertEquals(Empty, testModel2.getSlotAt(i, j));
        } else {
          assertEquals(Marble, testModel2.getSlotAt(i, j));
        }
      }
    }

    MarbleSolitaireModel testModel3 = new EnglishSolitaireModel(5);
    for (int i = 0; i < 13; i++) {
      for (int j = 0; j < 13; j++) {
        if ((i < 4 && j < 4)
                || (i < 4 && j >= (5 + 4))
                || (i >= (5 + 4) && j < 4)
                || (i >= (5 + 4) && j >= (5 + 4))) {
          assertEquals(Invalid, testModel3.getSlotAt(i, j));
        } else if (i == 6 && j == 6) {
          assertEquals(Empty, testModel3.getSlotAt(i, j));
        } else {
          assertEquals(Marble, testModel3.getSlotAt(i, j));
        }
      }
    }

    MarbleSolitaireModel testModel4 = new EnglishSolitaireModel(5, 4, 3);
    for (int i = 0; i < 13; i++) {
      for (int j = 0; j < 13; j++) {
        if ((i < 4 && j < 4)
                || (i < 4 && j >= (5 + 4))
                || (i >= (5 + 4) && j < 4)
                || (i >= (5 + 4) && j >= (5 + 4))) {
          assertEquals(Invalid, testModel4.getSlotAt(i, j));
        } else if (i == 4 && j == 3) {
          assertEquals(Empty, testModel4.getSlotAt(i, j));
        } else {
          assertEquals(Marble, testModel4.getSlotAt(i, j));
        }
      }
    }
  }

  @Test
  public void move() {
    assertEquals(Marble, model1.getSlotAt(5, 3));
    assertEquals(Marble, model1.getSlotAt(4, 3));
    assertEquals(Empty, model1.getSlotAt(3, 3));

    model1.move(5, 3, 3, 3);

    assertEquals(Empty, model1.getSlotAt(5, 3));
    assertEquals(Empty, model1.getSlotAt(4, 3));
    assertEquals(Marble, model1.getSlotAt(3, 3));

    model1 = new EnglishSolitaireModel();

    assertEquals(Marble, model1.getSlotAt(1, 3));
    assertEquals(Marble, model1.getSlotAt(2, 3));
    assertEquals(Empty, model1.getSlotAt(3, 3));

    model1.move(1, 3, 3, 3);

    assertEquals(Empty, model1.getSlotAt(1, 3));
    assertEquals(Empty, model1.getSlotAt(2, 3));
    assertEquals(Marble, model1.getSlotAt(3, 3));

    model1 = new EnglishSolitaireModel();

    assertEquals(Marble, model1.getSlotAt(3, 1));
    assertEquals(Marble, model1.getSlotAt(3, 2));
    assertEquals(Empty, model1.getSlotAt(3, 3));

    model1.move(3, 1, 3, 3);

    assertEquals(Empty, model1.getSlotAt(3, 1));
    assertEquals(Empty, model1.getSlotAt(3, 2));
    assertEquals(Marble, model1.getSlotAt(3, 3));

    model1 = new EnglishSolitaireModel();

    assertEquals(Marble, model1.getSlotAt(3, 5));
    assertEquals(Marble, model1.getSlotAt(3, 4));
    assertEquals(Empty, model1.getSlotAt(3, 3));

    model1.move(3, 5, 3, 3);

    assertEquals(Empty, model1.getSlotAt(3, 5));
    assertEquals(Empty, model1.getSlotAt(3, 4));
    assertEquals(Marble, model1.getSlotAt(3, 3));

    try {
      model1.move(5, 3, 2, 3);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 3, 4, 5);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(7, 3, 4, 5);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 3, 4, 8);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(0, 0, 1, 0);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(6, 3, 4, 3);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 3, 4, 3);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }

    try {
      model1.move(2, 3, 5, 3);
      fail("This move is not valid.");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "This is not a valid move.");
    }
  }

  @Test
  public void isGameOver() {
    assertFalse(model1.isGameOver());

    model1.move(3, 1, 3, 3);
    model1.move(3, 4, 3, 2);
    model1.move(3, 6, 3, 4);
    model1.move(1, 3, 3, 3);
    model1.move(4, 3, 2, 3);
    model1.move(6, 3, 4, 3);

    assertTrue(model1.isGameOver());
  }

  @Test
  public void getBoardSize() {
    assertEquals(7, model1.getBoardSize());
    assertEquals(7, model2.getBoardSize());
    assertEquals(13, model3.getBoardSize());
    assertEquals(7, model4.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    assertEquals(Marble, model1.getSlotAt(3, 1));
    assertEquals(Empty, model1.getSlotAt(3, 3));
    assertEquals(Invalid, model1.getSlotAt(0, 0));

    assertEquals(Marble, model3.getSlotAt(0, 5));
    assertEquals(Empty, model3.getSlotAt(6, 6));
    assertEquals(Invalid, model3.getSlotAt(3, 2));

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
    assertEquals(32, model1.getScore());
    model1.move(5, 3, 3, 3);
    assertEquals(31, model1.getScore());
    model1.move(2, 3, 4, 3);
    assertEquals(30, model1.getScore());
  }

}