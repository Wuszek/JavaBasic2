import model.User;

public class Main {
  public static void main(String[] args) {
        // utworzenie obiektu User
        User u1 = new User();
        User u2 = new User();
        u1.name = "Michał";
        u2.name = "Anna";

        // na obiekcie u1 wywołanie metody toString
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println("User 1: " + u1.name);
        System.out.println("User 2: " + u2.name);
  }
}
