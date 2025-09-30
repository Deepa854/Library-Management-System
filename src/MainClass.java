import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Issued Books");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // to skip extra newline
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Book b = new Book(id, title, author, qty);
                    lib.addBook(b);
                    break;

                case 2:
                    lib.viewBooks();
                    break;

                case 3: // Add Member
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();

                    Member m = new Member(mid, name, contact);
                    lib.addMember(m);
                    break;

                case 4: // View Members
                    lib.viewMembers();
                    break;

                case 5: // Issue Book
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    lib.issueBook(bookId, memberId);
                    break;

                case 6: // Return Book
                    System.out.print("Enter Book ID: ");
                    int retBookId = sc.nextInt();
                    System.out.print("Enter Member ID: ");
                    int retMemberId = sc.nextInt();
                    lib.returnBook(retBookId, retMemberId);
                    break;

                case 7: // View Issued Books
                    lib.viewIssuedBooks();
                    break;


                case 8: // Exit
                    System.out.println("Exit...");
                    sc.close();
                    return;

                    default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
