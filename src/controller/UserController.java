package controller;

import exception.MyException;
import model.User;

import java.util.Scanner;
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
        if (user == null){
            throw new MyException();            // rzucanie wyjątku -> utworzenie obiektu klasy wyjątku
        }
            user.setPassword(newPassword);
        }
        catch(MyException e){
            System.out.println("Obsługa mojego wyjątku.");
            e.printStackTrace();
        }
//        catch (NullPointerException e){      // argumentem w blocku catch jest klasa wyjątku
//            System.out.println("Brak użytkownika o ID " + userId);
//            System.out.println();
//            // e.printStackTrace();         // metoda drukująca na konsoli systemowy komunikat błędu
//        }
//        catch(Exception e){
//            System.out.println("Wystąpił inny błąd");
//        }

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

    boolean isRun = true;
    while (isRun) {
      // CLI - command line interface
      System.out.println("APLIKACJA X");
      System.out.println(
          "1. Rejestracja \n2. Logowanie \n3. Zmiana hasła \n4. Pokaż wszystkich \n0. Wyjście");
      Scanner scan = new Scanner(System.in);

      int choice = scan.nextInt();
      scan.nextLine();          // instrukcja konsumująca \n po wprowadzonej liczbie, tak aby nie przesuwać kursora
      switch (choice) {
        case 1:
            System.out.println("Podaj imię: ");
            String name = scan.nextLine();
            System.out.println("Podaj nazwisko: ");
            String lastname = scan.nextLine();
            System.out.println("Podaj email: ");
            String login = scan.nextLine();
            System.out.println("Podaj hasło: ");
            String password = scan.nextLine();
            System.out.println("Podaj płeć: ");
            char gender = scan.nextLine().toUpperCase().charAt(0);
            if (gender == 'M' || gender == 'K') {
                uc.registerUser(new User(name, lastname, login, password, gender));
            }else{
                System.out.println("Błędna płeć. Podaj M lub K");
            }
          break;
        case 2:
          System.out.println("Podaj email: ");
          String logEmail = scan.nextLine();
          System.out.println("Podaj hasło: ");
          String logPassword = scan.nextLine();
          System.out.println(uc.loginUser(logEmail, logPassword) ? "Zalogowany "+logEmail:"Błędne dane");
          break;
        case 3:
          System.out.println("Podaj Id użytkownika: ");
          int id = scan.nextInt();
          scan.nextLine();
          System.out.println("Podaj nowe hasło: ");
          String newPassword = scan.nextLine();
          uc.updatePasswordByUserId(id, newPassword);
          break;
        case 4:
          uc.printAllUsers();
          break;
        case 0:
          System.out.print("Wychodzę z programu.");
          isRun = false;
          scan.close();
          break;
        default:
          System.out.println("Brak takiej opcji.");
          break;
      }
}


//    System.out.println("Wypisanie wszystkich użytkowników: ");
//      uc.printAllUsers();
//      // Wyrażenie 3-argumentowe: warunek ? wartość jeśli true : wartość jeśli false
//      String login = "test@test.pl";
//      String password = "tEsT2";
//    System.out.println(uc.loginUser(login, password) ? "Zalogowany "+login:"Niezalogowany");
//
//    System.out.println(uc.findUserById(1).getPassword());
//    uc.updatePasswordByUserId(3, "TEEEEEEEEEEEEST1");
//    System.out.println(uc.findUserById(1).getPassword());
//
//    System.out.println(uc.loginUser(login, "TEEEEEEEEEEEEST1"));
  }
}
