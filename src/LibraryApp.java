import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n Welcome to Library Menu ");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    dao.addBook(title, author);
                }

                case 2 -> dao.viewBooks();

                case 3 -> {
                    System.out.print("Enter Book ID to issue: ");
                    int id = sc.nextInt();
                    dao.issueBook(id);
                }

                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    int id = sc.nextInt();
                    dao.returnBook(id);
                }

                case 5 -> {
                    System.out.println("Exiting.. Bye for now ");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
