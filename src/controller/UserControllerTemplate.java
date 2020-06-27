package controller;

import model.User;

// Czym jest interfejs?
// 1. Nie jest to klasa i nie możemy tworzyć obiektu interfejs!
// 2. Szablon wymagań dlaklasy go imprementującej
// 3. Może posiadać
// 3.1 Metody abstrakcyjne
// 3.2 Wszysktie składowe są publiczne
// 3.3 Pola i metody statyczne
public interface UserControllerTemplate {

    // Rejestracja użytkownika
    void registerUser(User user);
    // Logowanie użytkownika
    boolean loginUser(String email, String password);
    // Zmiana hasła użytkownika
    void updatePasswordByUserId(int userId, String newPassword);
    // Wypisanie wszystkich użytkowników
    void printAllUsers();
}
