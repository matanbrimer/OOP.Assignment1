# OOP.Assignment1

We have 5 classes:
We want the UndoableStringBuilder class to have an option to "update" a list of people with the changes they are going through, that is, every time something changes in the string, everyone who wants to know is registered to the update group and receives a notification of a change and the latest string as well.

ConcreteMember - represents an implementation of a "client" that is updated every time there is a change in the string.
member (=observer) - an interface with a declaration of the function of updating a user / "customer" 
GroupAdmin - the class that holds a list of customers and a string and executes an update message for any information when there is a change in the string.
 (observable=) Sender – the interface implemented by the GroupAdmin class where there are statements about the functions of the user update.

UndoableStringBuilder – the original class with the various operations for changing a string.

We have added additional tests through JvmUtilities that check the actual memory size and the memory address

