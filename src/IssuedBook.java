import java.time.LocalDate;

public class IssuedBook {
    private Book book;
    private Member member;
    private LocalDate issueDate;

    public IssuedBook(Book book, Member member, LocalDate issueDate) {
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        return "Book: " + book.getTitle() + " | Issued to: " + member.getName() + " | Date: " + issueDate;
    }
}

