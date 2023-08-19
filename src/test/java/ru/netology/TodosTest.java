package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void testSimpleTaskGetTitle() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить торт");


        String expected = "Купить торт";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicGetSutasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epik = new Epic(1, subtasks);


        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epik.getSutasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTaskGetId() {

        Task task = new Task(1);


        int expected = 1;
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingGetTopic() {

        Meeting topic = new Meeting(1, "Проверка ДЗ", "Netology.ru", "2023.12.21");


        String expected = "Проверка ДЗ";
        String actual = topic.getTopic();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingGetProject() {

        Meeting topic = new Meeting(1, "Проверка ДЗ", "Netology.ru", "2023.12.21");


        String expected = "Netology.ru";
        String actual = topic.getProject();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingGetStart() {

        Meeting topic = new Meeting(1, "Проверка ДЗ", "Netology.ru", "2023.12.21");


        String expected = "2023.12.21";
        String actual = topic.getStart();

        Assertions.assertEquals(expected, actual);
    }

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

    public void testSearchTasks0() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

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


        Task[] expected = {};
        Task[] actual = todos.search("Встретится");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testSearchTasks1() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

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


        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testSearchTasks2() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Молоко");

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


        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Молоко");


        Assertions.assertArrayEquals(expected, actual);
    }
}
