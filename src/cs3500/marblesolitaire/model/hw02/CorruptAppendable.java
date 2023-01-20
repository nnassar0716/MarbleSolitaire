package cs3500.marblesolitaire.model.hw02;

import java.io.IOException;

/**
 * This class represents a mock of an Appendable. It is used to test for IOExceptions.
 */
public class CorruptAppendable implements Appendable {

  /**
   * Constructs a MockAppendable object with no fields.
   */
  public CorruptAppendable() {
    // no fields need to be initialized for a CorruptAppendable object
  }

  /**
   * Mock version of the append(CharSequence) method.
   *
   * @param csq The character sequence to append.  If {@code csq} is
   *            {@code null}, then the four characters {@code "null"} are
   *            appended to this Appendable.
   * @return nothing
   * @throws IOException automatically throw an IOException
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("An IOException was thrown.");
  }

  /**
   * Mock version of the append(CharSequence, int, int) method.
   *
   * @param csq   The character sequence from which a subsequence will be
   *              appended.  If {@code csq} is {@code null}, then characters
   *              will be appended as if {@code csq} contained the four
   *              characters {@code "null"}.
   * @param start The index of the first character in the subsequence
   * @param end   The index of the character following the last character in the
   *              subsequence
   * @return nothing
   * @throws IOException automatically throw an IOException
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("An IOException was thrown.");
  }

  /**
   * Mock version of the append(char) method.
   *
   * @param c The character to append
   * @return nothing
   * @throws IOException automatically throw an IOException
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("An IOException was thrown.");
  }
}
