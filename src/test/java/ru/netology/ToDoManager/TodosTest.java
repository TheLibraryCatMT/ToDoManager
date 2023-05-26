package ru.netology.ToDoManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchWithSeveralTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Расческа для кота");

        String[] subtasks = {"Создание", "Тестирование", "продажи"};
        Epic epic = new Epic(1, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Стратегия вычесывания кота",
                "Создание расчески для кота",
                "После дождичка в четверг"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("кот");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchWithSeveralTasksButOneAnswer() {
        SimpleTask simpleTask = new SimpleTask(1, "Расческа для кота");

        String[] subtasks = {"Создание", "Тестирование", "продажи"};
        Epic epic = new Epic(1, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Стратегия вычесывания кота",
                "Создание расчески для кота",
                "После дождичка в четверг"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Тест");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchWithSeveralTasksButNoSearch() {
        SimpleTask simpleTask = new SimpleTask(1, "Расческа для кота");

        String[] subtasks = {"Создание", "Тестирование", "продажи"};
        Epic epic = new Epic(1, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Стратегия вычесывания кота",
                "Создание расчески для кота",
                "После дождичка в четверг"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("собака");
        Assertions.assertArrayEquals(expected, actual);
    }

}
