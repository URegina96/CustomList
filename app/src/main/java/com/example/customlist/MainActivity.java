package com.example.customlist;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentUp.OnSelectedItemListener {

    // Определяем переменные для хранения ссылок на фрагменты
    Fragment infoButton;
    Fragment listUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Вызываем метод родительского класса для инициализации активности
        setContentView(R.layout.activity_main); // Устанавливаем разметку для этой активности

        // Начинаем транзакцию фрагментов для добавления фрагментов в активность
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // Создаем экземпляры верхнего и нижнего фрагментов
        infoButton = new FragmentBottom();
        listUp = new FragmentUp();

        // Добавляем верхний фрагмент в контейнер с идентификатором fragment_up
        fragmentTransaction.add(R.id.fragment_bottom, infoButton);
        // Добавляем нижний фрагмент в контейнер с идентификатором fragment_bottom
        fragmentTransaction.add(R.id.fragment_up, listUp);

        // Завершаем транзакцию фрагментов
        fragmentTransaction.commit();
    }

    // Реализуем метод, вызываемый, когда элемент в верхнем фрагменте выбран
    @Override
    public void onItemSelected(int index) {
        // Получаем менеджер фрагментов для управления фрагментами
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Находим нижний фрагмент по его идентификатору
        FragmentBottom f = (FragmentBottom) fragmentManager.findFragmentById(R.id.fragment_bottom);

        // Если фрагмент найден, вызываем метод установки объекта с переданным индексом
        if (f != null) {
            f.setObject(index);
        }
    }
}
