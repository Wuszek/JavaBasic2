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
        // 1. W pętli szukamy użytkownika z hasłem i emailem jak w argumentach
        for(User user : users){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
             //   System.out.println("Zalogowany");
                return true;
            }
        }
        return false;
    }

    @Override
    public void updatePasswordByUserId(int userId, String newPassword) {
        try{        // zawiera linijki kodu gdzie może wystąpić wyjątek
        User user = findUserById(userId);
        user.setPassword(newPassword);
        } catch (NullPointerException e){      // argumentem w blocku catch jest klasa wyjątku
            System.out.println("Brak użytkownika o ID " + userId);
            System.out.println();
            // e.printStackTrace();         // metoda drukująca na konsoli systemowy komunikat błędu
        }
        catch(Exception e){
            System.out.println("Wystąpił inny błąd");
        }

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

    // metoda nieznajdująca się w interfejsie
    public User findUserById(int userId){
        for (User user  : users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null; // gdy nie znaleziono użytkownika zwróć null
    }

  public static void main(String[] args) {
    UserController uc = new UserController();
    uc.registerUser(new User("Test", "Test", "test@test.pl", "tEsT",'K'));
    uc.registerUser(new User("Test2", "Test2", "test2@test.pl", "tEsT2",'M'));
    System.out.println("Wypisanie wszystkich użytkowników: ");
      uc.printAllUsers();
      // Wyrażenie 3-argumentowe: warunek ? wartość jeśli true : wartość jeśli false
      String login = "test@test.pl";
      String password = "tEsT2";
    System.out.println(uc.loginUser(login, password) ? "Zalogowany "+login:"Niezalogowany");

    System.out.println(uc.findUserById(1).getPassword());
    uc.updatePasswordByUserId(3, "TEEEEEEEEEEEEST1");
    System.out.println(uc.findUserById(1).getPassword());

    System.out.println(uc.loginUser(login, "TEEEEEEEEEEEEST1"));
  }
}
