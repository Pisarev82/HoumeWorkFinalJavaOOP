package org.example;

import org.example.controller.App;

public class Main {

    // Фильмотека / прокат фильмов
// Добавлять фильмы, Покупать (продумать отслеживани колл-ва)
// 2 типа пользователей, Администраторы и пользователи
// Добавлять фильм, редактировать описание или удалять. Так же он провереряет заявки на аренду фильма
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}