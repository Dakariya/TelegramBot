package com.javatest.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "javaprepare_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "7149349741:AAGh0MREHUmfpBnjhhLmMwkWXmhqvfVjyfI"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
       if(getMessageText().equals("/start")) {
            sendTextMessageAsync("Привет! Давай подготовимся к собеседованию. Выбери тему:", java.util.
                    Map.of("ООП", "oop",
                            "Java Core","core",
                            "Java Collections Framework", "collections",
                            "Java Concurrency", "concurrency",
                            "Java IO", "io",
                            "Java 8 API", "java8",
                            "Spring Framework","spring",
                            "Hibernate", "hibernate",
                            "Spring Boot", "springboot"));
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}