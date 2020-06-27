package controller;

import model.User;

import java.util.function.Consumer;

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
        // 1. W pęti wypisz wszystkie elementy
//        for(int i=0; i<users.size(); i++){          // WYTYCZNE: stosujemy gdy znana jest liczba iteracji
//            System.out.println(users.get(i));
//        }
//        int i = 0;
//        while(i < users.size()){                    // WYTYCZNE: stosujemy gdy nieznana jest liczba iteracji
//            System.out.println(users.get(i));
//            i++;
//        }
//        for(User user : users){                     //for(typElementuKolekcji nazwaTymczasowegoObiektu : kolekcja)
//            System.out.println(user);               // WYTYCZNE: stosujemy do kolekcji, ale tylko do odczytu
//        }

        //CTRL _ Spacja -> utwórz predykat-> przekształcenie
        users.forEach(user -> System.out.println(user));

    }

  public static void main(String[] args) {
    UserController uc = new UserController();
    uc.registerUser(new User("Test", "Test", "test@test.pl", "tEsT",'K'));
      uc.registerUser(new User("Test2", "Test2", "test2@test.pl", "tEsT2",'M'));
    System.out.println("Wypisanie wszystkich użytkowników: ");
      uc.printAllUsers();
  }
}
