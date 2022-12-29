package observer;

/**
 * ConcreteMember is used as an Observer.
 * She describes the client and receives updates to him.
 *
 */
public class ConcreteMember implements Member{


    private UndoableStringBuilder memberString;

    /**
     * Print the UndoableStringBuilder
     * @return the string from the UndoableStringBuilder
     */
    @Override
    public String toString() {
        return memberString.toString();
    }

    /**
     * The member's UndoableStringBuilder will point to the Admin's UndoableStringBuilder in order to receive updates
     * @param usb the Admin's UndoableStringBuilder
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        memberString = usb;
    }

}
