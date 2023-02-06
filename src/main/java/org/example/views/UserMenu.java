package org.example.views;

import java.util.Scanner;

public class UserMenu {

    public int showUserMenu(){
        System.out.println("1 - Список фильмов доступных для покупки\n" +
                "2 - Купить фильм\n" +
                "3 - Вернуть фильм\n" +
                "4 - Список моих фильмов\n" +
                "9 - Завершить работу\n");

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        return num;
    }

    public String showSubmitMenu(){
        System.out.println("Введите название фильма для покупки:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String showReturnMenu(){
        System.out.println("Введите название фильма для возврата:");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void showMovie(String movieName) {
        System.out.printf("Приятного просмотра фильма: %s\n", movieName);
    }

    public void showAllMovie(String movieName){
        System.out.println(movieName);
    }
}
