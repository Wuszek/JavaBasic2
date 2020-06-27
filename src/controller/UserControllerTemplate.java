package controller;

import model.User;

import java.util.ArrayList;
import java.util.List;

// Czym jest interfejs?
// 1. Nie jest to klasa i nie możemy tworzyć obiektu interfejs!
// 2. Szablon wymagań dlaklasy go imprementującej i udostępnia pola publiczne i statyczne
// 3. Może posiadać
// 3.1 Metody abstrakcyjne
// 3.2 Wszysktie składowe są publiczne
// 3.3 Pola i metody statyczne
public interface UserControllerTemplate {

    List<User> users = new ArrayList<>();
    // Rejestracja użytkownika
    void registerUser(User user);
    // Logowanie użytkownika
    boolean loginUser(String email, String password);
    // Zmiana hasła użytkownika
    void updatePasswordByUserId(int userId, String newPassword);
    // Wypisanie wszystkich użytkowników
    void printAllUsers();
}
