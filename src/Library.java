import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<IssuedBook> issuedBooks = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    // MEMBER METHODS
    public void addMember(Member m) {
        members.add(m);
        System.out.println("Member added!");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member m : members) {
                System.out.println(m);
            }
        }
    }

    // ISSUE BOOK
    public void issueBook(int bookId, int memberId) {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == bookId) { book = b; break; }
        }
        if (book == null) { System.out.println("Book not found!"); return; }
        if (book.getQty() <= 0) { System.out.println("Book not available!"); return; }

        Member member = null;
        for (Member m : members) {
            if (m.getId() == memberId) { member = m; break; }
        }
        if (member == null) { System.out.println("Member not found!"); return; }

        // Issue book
        issuedBooks.add(new IssuedBook(book, member, LocalDate.now()));
        book.setQty(book.getQty() - 1);
        System.out.println("Book issued successfully!");
    }

    // RETURN BOOK
    public void returnBook(int bookId, int memberId) {
        IssuedBook issued = null;
        for (IssuedBook ib : issuedBooks) {
            if (ib.getBook().getId() == bookId && ib.getMember().getId() == memberId) {
                issued = ib; break;
            }
        }
        if (issued == null) { System.out.println("No record found for this book and member!"); return; }

        issuedBooks.remove(issued);
        issued.getBook().setQty(issued.getBook().getQty() + 1);
        System.out.println("Book returned successfully!");
    }

    // VIEW ISSUED BOOKS
    public void viewIssuedBooks() {
        if (issuedBooks.isEmpty()) System.out.println("No books issued.");
        else for (IssuedBook ib : issuedBooks) System.out.println(ib);
    }
}

