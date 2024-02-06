package com.managelist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;

class ToDoList {
    private List<String> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void markTaskAsDone(String task) {
        if (tasks.contains(task)) {
            System.out.println("Marking task as done: " + task);
            // Implement your logic for marking task as done, for example, updating a status
            // flag.
            task.toUpperCase();
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public void viewTodoList() {
        System.out.println("TODO List:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }
    }

    public void clearTodoList() {
        tasks.clear();
    }
}

public class ManageList {
    private ToDoList list = new ToDoList();

    // Scenario: Add a task to the TODO list
    @Given("the user has an empty TODO list")
    public void the_user_has_an_empty_todo_list() {
        list.clearTodoList();
    }

    @When("the user adds a task {string} to the TODO list")
    public void the_user_adds_a_task_to_the_todo_list(String string) {
        list.addTask(string);
    }

    @Then("the TODO list should contain the task {string}")
    public void the_todo_list_should_contain_the_task(String string) {
        Assertions.assertTrue(list.getTasks().contains(string));
    }

    // Scenario: Mark a task as done
    @Given("the user has a TODO list with a task {string}")
    public void the_user_has_a_todo_list_with_a_task(String string) {
        list.clearTodoList();
        list.addTask(string);
    }

    @When("the user marks the task {string} as done")
    public void the_user_marks_the_task_as_done(String string) {
        list.markTaskAsDone(string);
    }

    @Then("the TODO list should show the task {string} as done")
    public void the_todo_list_should_show_the_task_as_done(String string) {
        list.viewTodoList();
    }

    // Scenario: Remove a task from the TODO list
    @Given("the user has a TODO list with tasks:")
    public void the_user_has_a_todo_list_with_tasks(List<String> tasks) {
        list.clearTodoList();
        for (String task : tasks) {
            list.addTask(task);
        }
    }

    @When("the user removes the task {string} from the TODO list")
    public void the_user_removes_the_task_from_the_todo_list(String string) {
        list.removeTask(string);
    }

    @Then("the TODO list should not contain the task {string}")
    public void the_todo_list_should_not_contain_the_task(String string) {
        Assertions.assertFalse(list.getTasks().contains(string));
    }

    @Then("the TODO list should contain the tasks {string} and {string}")
    public void the_todo_list_should_contain_the_tasks_and(String string, String string2) {
        Assertions.assertTrue(list.getTasks().contains(string));
        Assertions.assertTrue(list.getTasks().contains(string2));
    }

    // Scenario: View the TODO list
    @Given("the user has a TODO list with tasks 2:")
    public void the_user_has_a_todo_list_with_tasks2(List<String> tasks) {
        list.clearTodoList();
        for (String task : tasks) {
            list.addTask(task);
        }
    }

    @When("the user views the TODO list")
    public void the_user_views_the_todo_list() {
        list.viewTodoList();
    }

    @Then("the user should see the tasks {string} and {string}")
    public void the_user_should_see_the_tasks_and(String string, String string2) {
        Assertions.assertTrue(list.getTasks().contains(string));
        Assertions.assertTrue(list.getTasks().contains(string2));
    }

    // // Scenario: Clear the entire TODO list
    @Given("the user has a TODO list with tasks 3:")
    public void the_user_has_a_todo_list_with_tasks3(List<String> tasks) {
        list.clearTodoList();
        for (String task : tasks) {
            list.addTask(task);
        }
    }

    @When("the user clears the TODO list")
    public void the_user_clears_the_todo_list() {
        list.clearTodoList();
    }

    @Then("the TODO list should be empty")
    public void the_todo_list_should_be_empty() {
        Assertions.assertTrue(list.getTasks().isEmpty());
    }
}
