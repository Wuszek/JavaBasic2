package controller;

import model.User;

// UserControler - klasa kontrolera -> klasa obsługująca i dostarczająca logikę biznesową aplikacji
public class UserController  implements UserControllerTemplate{


    @Override
    public void registerUser(User user) {
        // 1. Zapisz użytkownika w liście users utworzonej w interfejsie
        users.add(user);
        System.out.println("Zarejestrowano nowego użytkownika: " + user.toString());
    }

    @Override
    public boolean loginUser(String email, String password) {
        return false;
    }

    @Override
    public void updatePasswordByUserId(int userId, String newPassword) {

    }

    @Override
    public void printAllUsers() {

    }

  public static void main(String[] args) {
    UserController uc = new UserController();
    uc.registerUser(new User("Test", "Test", "test@test.pl", "tEsT",'K'));
      uc.registerUser(new User("Test2", "Test2", "test2@test.pl", "tEsT2",'M'));
  }
}
