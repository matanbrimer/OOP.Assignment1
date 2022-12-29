package observer;

import java.util.Stack;
/**
 * StringBuilder with undo support
 */
public class UndoableStringBuilder implements INStringBuilder {
    /**
     *
     * string - Our sentence.
     * un - A stack that saves all the operations performed
     */
    public StringBuilder string;
    Stack<String> un;

    public UndoableStringBuilder() {
        string = new StringBuilder();
        un = new Stack<>();
    }

    /**
     * Appends the specified string to this character sequence
     *
     * @param str - new sentence/word/letter
     * @return string - new sentence after the adding
     */
    public StringBuilder append(String str) {
        string.append(str);
        un.add(string.toString());
        return string;

    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index end - 1 or to
     * the end of the sequence if no such character exists. If start is equal to
     * end, no changes are made.
     * @param start = From which location to delete
     * @param end   = Up to which location to delete
     * @return string after the delete
     */
    public StringBuilder delete(int start, int end) {
        try {
            string.delete(start, end);
            un.add(string.toString());
        } catch (Exception e) {
            System.out.println("The start and end you entered are incorrect " + e);
        }
        return string;

    }

    /**
     * Inserts the string into this character sequence.
     * @param offset = from which location
     * @param str    = a new sentence/word/letter
     * @return string = new sentence
     */
    public StringBuilder insert(int offset, String str) {
        try {
            string.insert(offset, str);
            un.add(string.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return string;

    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and extends
     * to the character at index end - 1 or to the end of the sequence if no such
     * character exists. First the characters in the substring are removed and then
     * the specified String is inserted at start.
     *
     * @param start From which location to delete
     * @param end   Up to which location to delete
     * @param str   = The new sentence/word/letter
     * @return string = new sentence
     */
    public StringBuilder replace(int start, int end, String str) {
        try {
            string.replace(start, end, str);
            un.add(string.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return string;

    }

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence.
     *
     * @return string = sentence after the reverses
     */
    public StringBuilder reverse() {
        string.reverse();
        un.add(string.toString());
        return string;
    }

    public String toString() {
        return string.toString();
    }

    /**
     * Returns one action back in the statement
     *
     * @return string = Returns the statement after one operation back in the
     *         statement
     */
    public StringBuilder undo() {

        try {
            un.pop();
            string.replace(0,string.length(),un.peek());
        } catch (Exception e) {
            string.replace(0,string.length(),"");
            System.out.println("No more undo");
        }
        return string;

    }

}
