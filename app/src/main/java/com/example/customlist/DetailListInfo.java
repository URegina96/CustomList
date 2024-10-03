package com.example.customlist;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailListInfo {
    // Метод для получения списка объектов в виде ArrayList, состоящего из HashMap
    public static ArrayList<HashMap<String, String>> getItemList() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>(); // Создает новый список для хранения объектов

        // Цикл для создания 30 объектов
        for(int i = 0; i < 30; i++) {
            HashMap<String, String> map = new HashMap<>(); // Создает новый HashMap для каждого объекта
            map.put("ID", String.valueOf(i)); // Добавляет ID объекта в HashMap
            map.put("NAME", "Объект номер " + i); // Добавляет имя объекта в HashMap
            list.add(map); // Добавляет HashMap в список
        }
        return list; // Возвращает завершенный список объектов
    }

    // Метод для получения объекта по его ID
    public static ItemList getItemById(int id) {
        ArrayList<ItemList> l = new ArrayList<>(); // Создает новый список для хранения объектов типа ObjectItem

        // Цикл для создания 30 объектов типа ObjectItem
        for(int i = 0; i < 30; i++) {
            ItemList item = new ItemList(); // Создает новый объект ObjectItem
            item.setId(i); // Устанавливает ID объекта
            item.setName("Объект " + i); // Устанавливает имя объекта
            item.setShortDescription("Короткое описание объекта " + i); // Устанавливает короткое описание объекта
            item.setLongDescription("Какое-то очень длинное описание объекта " + i + "\n" + // Устанавливает длинное описание объекта
                    "Мы все знаем, что этот объект имеет очень длинное описание");
            item.setImgName("image_" + i); // Устанавливает название изображения объекта
            l.add(item); // Добавляет созданный объект в список
        }
        return l.get(id); // Возвращает объект по его ID из списка
    }
}
