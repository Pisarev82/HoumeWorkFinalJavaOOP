package org.example.views;

import java.util.Scanner;

public class MainMenu {

    public String authorize(){
        System.out.println("Введите имя:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
        }

    public int newUserRegistration(String name){
        System.out.printf("Пользователь %s не найден \n" +
                "1 - Попробовать ввести пользователя еще раз\n" +
                "2 - Для регистрации нового пользователя с Именем %s и вам будет начисленно 100 бонусов на баланс \n" +
                "3 - Завершение программы\n", name, name );
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
