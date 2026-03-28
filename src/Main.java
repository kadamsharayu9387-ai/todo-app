import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n--- TO-DO APP ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    manager.addTask(sc.nextLine());
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    manager.viewTasks();
                    System.out.print("Enter number: ");
                    manager.deleteTask(sc.nextInt() - 1);
                    break;

                case 4:
                    manager.viewTasks();
                    System.out.print("Enter number: ");
                    manager.markTaskCompleted(sc.nextInt() - 1);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}