package com.example.customlist;

public class ItemList {
    private String name; // Поле для хранения имени объекта
    private int id; // Поле для хранения идентификатора объекта
    private String shortDescription; // Поле для хранения краткого описания объекта
    private String longDescription; // Поле для хранения полного описания объекта
    private String imgName; // Поле для хранения имени изображения объекта

    public String getName() { // Метод для получения имени объекта
        return name; // Возвращает значение поля name
    }

    public void setName(String name) { // Метод для установки имени объекта
        this.name = name; // Устанавливает значение поля name
    }

    public int getId() { // Метод для получения идентификатора объекта
        return id; // Возвращает значение поля id
    }

    public void setId(int id) { // Метод для установки идентификатора объекта
        this.id = id; // Устанавливает значение поля id
    }

    public String getShortDescription() { // Метод для получения краткого описания объекта
        return shortDescription; // Возвращает значение поля shortDescription
    }

    public void setShortDescription(String shortDescription) { // Метод для установки краткого описания объекта
        this.shortDescription = shortDescription; // Устанавливает значение поля shortDescription
    }

    public void setLongDescription(String longDescription) { // Метод для установки полного описания объекта
        this.longDescription = longDescription; // Устанавливает значение поля longDescription
    }

    public void setImgName(String imgName) { // Метод для установки имени изображения объекта
        this.imgName = imgName; // Устанавливает значение поля imgName
    }
}
