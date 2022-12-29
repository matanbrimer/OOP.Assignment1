package observer;

/**
 * An interface describing the UndoableStringBuilder.
 */
public interface INStringBuilder {
    public StringBuilder append(String str);
    public StringBuilder delete(int start, int end);
    public StringBuilder insert(int offset, String str);
    public StringBuilder replace(int start, int end, String str);
    public StringBuilder reverse();
    public String toString();
    public StringBuilder undo();
}
