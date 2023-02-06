package org.example.views;

import java.util.Scanner;

public class AdminMenu {

    public int showAdminMenu(){
        System.out.println("1 - Добавить фильм в список фильмов\n" +
                "2 - Редактировать фильм в списоке фильмов\n" +
                "3 - Удалить фильм из списока фильмов\n" +
                "9 - Завершить работу\n");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public String[] addMovie() {
        String[] result = new String[2];
        System.out.println("Введите название фильма");
        Scanner sc = new Scanner(System.in);
        result[0] = sc.nextLine();
        System.out.println("Введите стоимость фильма");
        result[1] = sc.nextLine();
        return result;
    }

}
