import java.util.*;
import java.io.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
        saveTasks();
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            saveTasks();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + "," + task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0]);
                if (parts[1].equals("true")) {
                    task.markCompleted();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            // first run: file not exist
        }
    }
}