package com.example.customlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class FragmentUp extends Fragment {

    public interface OnSelectedItemListener { // Интерфейс для передачи информации о выбранном элементе
        void onItemSelected(int index); // Метод, который будет вызван при выборе элемента
    }

    ListView listView; // Объявляем переменную для ListView (списка)

    private static final String ARG_PARAM1 = "param1"; // Константы для передачи параметров
    private static final String ARG_PARAM2 = "param2"; // Константы для передачи параметров

    private String mParam1; // Переменная для хранения первого параметра
    private String mParam2; // Переменная для хранения второго параметра

    @Override
    public void onCreate(Bundle savedInstanceState) { // Метод, вызываемый при создании фрагмента
        super.onCreate(savedInstanceState); // Вызываем метод родительского класса
        if (getArguments() != null) { // Проверяем, переданы ли аргументы
            mParam1 = getArguments().getString(ARG_PARAM1); // Извлекаем первый параметр из аргументов
            mParam2 = getArguments().getString(ARG_PARAM2); // Извлекаем второй параметр из аргументов
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { // Метод, который создаёт и возвращает представление фрагмента
        View view = inflater.inflate(R.layout.fragment_up, container, false); // Инфлейт (раздуваем) макет фрагмента

        listView = view.findViewById(R.id.up_list_view); // Находим ListView по его идентификатору

        SimpleAdapter adapter = new SimpleAdapter(this.getContext(), // Создаем новый адаптер SimpleAdapter
                DetailListInfo.getItemList(), // Получаем список данных из DataService
                android.R.layout.simple_list_item_2, // Указываем макет для каждого элемента списка
                new String[] {"ID", "NAME"}, // Указываем ключи для данных
                new int[]{android.R.id.text1, android.R.id.text2} // Указываем идентификаторы текстовых полей в макете
        );

        listView.setAdapter(adapter); // Устанавливаем адаптер для списка

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // Устанавливаем слушатель для кликов по элементам списка
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // Переопределяем метод для обработки клика
                System.out.println(i); // Выводим индекс выбранного элемента в консоль
                OnSelectedItemListener listener = (OnSelectedItemListener) getActivity(); // Получаем слушателя из активности
                listener.onItemSelected(i); // Передаем индекс выбранного элемента слушателю
            }
        });
        return view; // Возвращаем созданное представление фрагмента
    }
}
