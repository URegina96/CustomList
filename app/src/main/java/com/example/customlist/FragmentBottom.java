package com.example.customlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentBottom extends Fragment {

    TextView textViewName; // Объявляем переменную для текстового поля имени
    TextView textViewId; // Объявляем переменную для текстового поля ID
    TextView textViewDescription; // Объявляем переменную для текстового поля описания

    private static final String ARG_PARAM1 = "param1"; // Константа для передачи первого параметра
    private static final String ARG_PARAM2 = "param2"; // Константа для передачи второго параметра

    private String mParam1; // Переменная для хранения первого параметра
    private String mParam2; // Переменная для хранения второго параметра

    @Override
    public void onCreate(Bundle savedInstanceState) { // Переопределяем метод onCreate для инициализации фрагмента
        super.onCreate(savedInstanceState); // Вызываем родительский метод
        if (getArguments() != null) { // Проверяем, были ли переданы аргументы
            mParam1 = getArguments().getString(ARG_PARAM1); // Получаем значение первого параметра
            mParam2 = getArguments().getString(ARG_PARAM2); // Получаем значение второго параметра
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { // Переопределяем метод для создания пользовательского интерфейса
        View view = inflater.inflate(R.layout.fragment_bottom, container, false); // Инфляция макета фрагмента
        textViewId = view.findViewById(R.id.id_text_view); // Находим элемент TextView для ID по его идентификатору
        textViewName = view.findViewById(R.id.name_text_view); // Находим элемент TextView для имени по его идентификатору
        textViewDescription = view.findViewById(R.id.description_text_view); // Находим элемент TextView для описания по его идентификатору

        textViewId.setText("-"); // Устанавливаем начальное значение для TextView ID
        textViewName.setText("Выберите объект"); // Устанавливаем начальное значение для TextView имени
        textViewDescription.setText("-"); // Устанавливаем начальное значение для TextView описания
        return view; // Возвращаем созданное представление
    }

    public void setObject(int id) { // Метод для установки объекта по его ID
        ItemList item = DetailListInfo.getItemById(id); // Получаем объект по ID с помощью DataService
        textViewId.setText(String.valueOf(item.getId())); // Устанавливаем ID в соответствующее TextView
        textViewName.setText(item.getName()); // Устанавливаем имя объекта в соответствующее TextView
        textViewDescription.setText(item.getShortDescription()); // Устанавливаем короткое описание в соответствующее TextView
    }
}
