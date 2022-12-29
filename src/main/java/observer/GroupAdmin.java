package observer;

import java.util.ArrayList;

/**
 * GroupAdmin is used as an Observable. It contains the status database and
 * the customer database, which will be updated with any changes made to the database.
 */
public class GroupAdmin implements Sender{
    /**
     * observer - The customer database.
     * s - the database.
     */
    private ArrayList<Member> observers;
   public UndoableStringBuilder s;

    public GroupAdmin(){
        observers = new ArrayList<>();
        s = new UndoableStringBuilder();

    }

    /**
     *Adding a new customer to the customer database
     *
     * @param obj new customer
     */
    public void register(Member obj){
        if(obj == null) throw new NullPointerException("Null Observer");

        else if(!observers.contains(obj)){
            observers.add(obj);
            obj.update(this.s);
        }

    }

    /**
     * Deleting a customer from the customer database
     * @param obj The deleted customer
     */
    public void unregister(Member obj){
        if(obj == null) throw new NullPointerException("Null Observer");

        else if(observers.contains(obj)) observers.remove(obj);

    }

    /**
     * Inserts the string into this character sequence.
     * @param offset From which location in the database will we add the new sentence.
     * @param obj The new sentence to be added to the database
     */
    public void insert(int offset, String obj){
        s.insert(offset, obj);
    }

    /**
     * Appends the specified string to this character sequence.
     */
    public void append(String obj){
        s.append(obj);

    }

    /**
     * Removes the characters in a substring of this sequence.
     * @param start From which location will delete start
     * @param end Up to which location will be deleted
     */
    public void delete(int start, int end){
        s.delete(start, end);
    }

    /**
     * Erases the last change done to the document, reverting it to an older state.
     */
    public void undo(){
        s.undo();
    }

    /**
     * Returns the customer database
     */
    public ArrayList<Member> getObservers(){
        return observers;
    }


}
