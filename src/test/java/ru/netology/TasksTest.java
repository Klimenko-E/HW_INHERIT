package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void testTaskMatches() {
        Task Task = new Task(135);

        //boolean expected = true;
        boolean actual = Task.matches("135");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testSimpleTaskMatchesTrue() {
        Task simpleTask = new SimpleTask(1, "Сделать ДЗ");

        //boolean expected = true;
        boolean actual = simpleTask.matches("Сделать");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskMatchesFalse() {
        Task simpleTask = new SimpleTask(2, "Сделать ДЗ");

        //boolean expected = false;
        boolean actual = simpleTask.matches("картошка");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatchesTrue() {
        String[] subtasks = {"Поставить будильник", "Сделать ДЗ", "Позвонить в МоcГорБрызг"};
        Task epic = new Epic(3, subtasks);

        //boolean expected = true;
        boolean actual = epic.matches("МоcГорБрызг");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicMatchesFalse() {
        String[] subtasks = {"Поставить будильник", "Сделать ДЗ", "Позвонить в МоcГорБрызг"};
        Task epic = new Epic(3, subtasks);

        //boolean expected = false;
        boolean actual = epic.matches("Тест");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingMatchesTopicTrue() {
        Task meeting = new Meeting(4, "Проверка ДЗ", "Инженер по тестированию: с нуля до middle. netology.ru", "2023.08.17:15.00");

        //boolean expected = true;
        boolean actual = meeting.matches("Проверка ДЗ");

        Assertions.assertTrue(actual);

    }

    @Test
    public void testMeetingMatchesProjectTrue() {
        Task meeting = new Meeting(4, "Проверка ДЗ", "Инженер по тестированию: с нуля до middle. netology.ru", "2023.08.17:15.00");

        //boolean expected = true;
        boolean actual = meeting.matches("Инженер");

        Assertions.assertTrue(actual);

    }

    @Test
    public void testMeetingMatchesFalse() {
        Task meeting = new Meeting(4, "Проверка ДЗ", "Инженер по тестированию: с нуля до middle. netology.ru", "2023.08.17:15.00");

        //boolean expected = false;
        boolean actual = meeting.matches("134");

        Assertions.assertFalse(actual);

    }
}

