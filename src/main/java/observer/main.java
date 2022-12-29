package observer;

public class main {
    public static void main(String[] args) {
        GroupAdmin admin = new GroupAdmin();

        ConcreteMember user1 = new ConcreteMember();
        ConcreteMember user2 = new ConcreteMember();
        ConcreteMember user3 = new ConcreteMember();

        admin.register(user1);
        admin.register(user2);
        admin.register(user3);





        admin.append("I am your admin");

        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());

        admin.append("fsgsfgfsgfs");
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());

    }
}
