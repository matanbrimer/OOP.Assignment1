import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    GroupAdmin admin = new GroupAdmin();

    ConcreteMember user1 = new ConcreteMember();
    ConcreteMember user2 = new ConcreteMember();
    ConcreteMember user3 = new ConcreteMember();
    @Test
    void update() {
        GroupAdmin admin2 = new GroupAdmin();

        ConcreteMember user4 = new ConcreteMember();
        ConcreteMember user5 = new ConcreteMember();
        ConcreteMember user6 = new ConcreteMember();




    }
    @Test
    void registerAndUpdate() {
        admin.register(user1);
        assertTrue(admin.getObservers().contains(user1));

        admin.register(user2);
        assertTrue(admin.getObservers().contains(user2));

        admin.register(user3);
        assertTrue(admin.getObservers().contains(user3));

        // now we check update
        admin.append("I am your ADMIN");
        assertEquals("I am your ADMIN", user1.toString(),"Test-failed");
        assertEquals("I am your ADMIN", user2.toString(),"Test-failed");
        assertEquals("I am your ADMIN", user3.toString(),"Test-failed");

        admin.append(", update");

        assertEquals("I am your ADMIN, update", user1.toString(),"Test-failed");
        assertEquals("I am your ADMIN, update", user2.toString(),"Test-failed");
        assertEquals("I am your ADMIN, update", user3.toString(),"Test-failed");
    }

    @Test
    void unregister() {
        admin.unregister(user1);
        assertFalse(admin.getObservers().contains(user1));

        admin.unregister(user2);
        assertFalse(admin.getObservers().contains(user2));

        admin.unregister(user3);
        assertFalse(admin.getObservers().contains(user3));
    }

    @Test
    void insert() {
        admin.append("hello friends");
        admin.insert(13," i will miss you");

        assertEquals("hello friends i will miss you", admin.s.toString(),"Test-failed");

        admin.insert(6,"I have many ");
        assertEquals("hello I have many friends i will miss you", admin.s.toString(),"Test-failed");
    }

    @Test
    void append() {
        admin.delete(0, admin.s.string.length());
        admin.append("Argentina");
        assertEquals("Argentina", admin.s.toString(),"Test-failed");

        admin.append(" is the world");
        assertEquals("Argentina is the world", admin.s.toString(),"Test-failed");

        admin.append(" champion");
        assertEquals("Argentina is the world champion", admin.s.toString(),"Test-failed");

    }

    @Test
    void delete() {
        admin.append("Argentina is the world champion");
        assertEquals("Argentina is the world champion", admin.s.toString(),"Test-failed");
        admin.delete(0,5);
        assertEquals("tina is the world champion", admin.s.toString(),"Test-failed");
        admin.delete(0,6);
        assertEquals("s the world champion", admin.s.toString(),"Test-failed");
        admin.delete(0, admin.s.string.length());
        assertEquals("", admin.s.toString(),"Test-failed");

        admin.append("Matan Brimer");
        admin.delete(7,5);
        assertEquals("Matan Brimer", admin.s.toString(),"Test-failed");

    }

    @Test
    void undo() {
        admin.delete(0, admin.s.string.length());
        admin.append("java");
        assertEquals("java", admin.s.toString(),"Test-failed");
        admin.append(" and");
        admin.append(" python");
        assertEquals("java and python", admin.s.toString(),"Test-failed");
        admin.undo();
        assertEquals("java and", admin.s.toString(),"Test-failed");
        admin.undo();
        assertEquals("java", admin.s.toString(),"Test-failed");
        admin.undo();
        assertEquals("", admin.s.toString(),"Test-failed");
        admin.undo();
        admin.undo();
        admin.undo();
        assertEquals("", admin.s.toString(),"Test-failed");
    }


    public void checkSize(){


        logger.info(()->JvmUtilities.objectFootprint(admin));

        logger.info(()->JvmUtilities.objectTotalSize(admin));

        ConcreteMember user1 = new ConcreteMember();
        admin.register(user1);

        logger.info(()->("size one more register")+JvmUtilities.objectFootprint(admin));
        ConcreteMember user2 = new ConcreteMember();
        admin.register(user2);
        logger.info(()->JvmUtilities.objectTotalSize(admin));

        logger.info(() -> JvmUtilities.jvmInfo());

        logger.info(() -> JvmUtilities.memoryStats(admin));


    }

}
