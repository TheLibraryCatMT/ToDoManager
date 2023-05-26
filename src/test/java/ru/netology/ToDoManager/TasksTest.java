package ru.netology.ToDoManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TasksTest {

    @Test
    public void testForSimpleTaskIfTrue() {
        SimpleTask task = new SimpleTask(4, "Спортивный зал");
        boolean actual = task.matches("зал");
        boolean expacted = true;
        Assertions.assertEquals(expacted, actual);

    }

    @Test
    public void testForSimpleTaskIfFalse() {
        SimpleTask task = new SimpleTask(4, "Спортивный зал");
        boolean actual = task.matches("бал");
        boolean expacted = false;
        Assertions.assertEquals(expacted, actual);

    }

    @Test
    public void testForEpicIfTrue() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");
        String[] subtasks = {"Мама", "папа", "сестра"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("папа");
        boolean expacted = true;
        Assertions.assertEquals(expacted, actual);
    }

    @Test
    public void testForEpicIfFalse() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");
        String[] subtasks = {"Мама", "папа", "сестра"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("брат");
        boolean expacted = false;
        Assertions.assertEquals(expacted, actual);
    }

    @Test
    public void testForMeetingIfTrue() {
        Meeting meeting = new Meeting(
                321,
                "Как правильно гладить кота",
                "Разработка новой расчески для кота",
                "Через 10 минут"
        );
        boolean actual = meeting.matches("кот");
        boolean expacted = true;
        Assertions.assertEquals(expacted, actual);
    }

    @Test
    public void testForMeetingIfFalse() {
        Meeting meeting = new Meeting(
                321,
                "Как правильно гладить кота",
                "Разработка новой расчески для кота",
                "Через 10 минут"
        );
        boolean actual = meeting.matches("собака");
        boolean expacted = false;
        Assertions.assertEquals(expacted, actual);
    }
}
