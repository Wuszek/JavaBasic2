package model;
// Hints
// CTRL + D - duplikowanie lini kodu
// ALT + Ins - auto-generowanie fragmentów kodu

import java.time.LocalDateTime;

// Klasa user - to klasa modelu-> klasa determinująca strukturę danych
public class User extends Object{       // Każda klasa dziedziczy klasy nadrzędnej (zgodnie ze specyfikatorami dostępu)
    // pola klasowe -> pola o zasięgu widoczności w obrębie całej klasy
    int userId;                                   //domyślnie 0
    String name;                                  //domyślnie null
    String lastName;                              //domyślnie null
    String email;                                 //domyślnie null
    String password;                              //domyślnie null
    char gender;                                  //domyślnie ''
    LocalDateTime registrationDateTime;           //domyślnie null
    boolean status;                               //domyślnie false

    // public - widoczna w całym programie
    // String - typ zwracanej wartości w return
    // toString() - nazwa metody (nie przyjmuje argumentów)
    @Override   // Nadpisuje implementacjęmetody toString() z klasy Object
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", registrationDateTime=" + registrationDateTime +
                ", status=" + status +
                '}';
    }
}
