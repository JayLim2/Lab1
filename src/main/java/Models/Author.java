package Models;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.ValidationException;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlSeeAlso(Book.class)
public class Author {
    private String name;
    private List<Book> books;

    private static List<Integer> busyId;
    private int id = 0;


    private static final int TITLE_LIMIT = 75;
    private static final int BRIEF_LIMIT = 1500;
    private static final int PUBLISHER_LIMIT = 75;
    
    static{
        busyId = new LinkedList<>();
    }
    
    {
        int cid = 0;
        while (busyId.contains(cid)) cid++;
        id = cid;
        busyId.add(id);
    }

    public Author() {
        books = new LinkedList<>();
    }

    public Author(String name) {
        this.name = name.trim();
        books = new LinkedList<>();
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public int getId() {
        return id;
    }
    
    public void setId(int val) throws ValidationException {
        busyId.remove(new Integer(id));
        if (busyId.contains(val)) {
            busyId.add(id);
            throw new ValidationException("busy id");
        }
        
        id = val;
        busyId.add(id);
    }
    
    public static void resetId(){
        busyId = new LinkedList<>();
    }
     
    public void setName(String name) {
        this.name = name.trim();
    }

    @XmlElement(name = "booksList")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (!isExists(book, books) && isValid(book)) {
            book.setTitle(book.getTitle().trim());
            book.setPublisher(book.getPublisher().trim());
            book.setBrief(book.getBrief().trim());

            books.add(book);
            books.sort(new BooksComparator());
        }
    }

    private boolean isExists(Book book, List<Book> bookList) {
        for (Book currentBook : bookList) {
            if (book.equals(currentBook))
                return true;
        }
        return false;
    }

    private boolean isValid(Book book) {
        return !book.getTitle().isEmpty() &&
                book.getTitle().length() <= TITLE_LIMIT &&
                book.getBrief().length() <= BRIEF_LIMIT &&
                book.getPublisher().length() <= PUBLISHER_LIMIT;
    }

    //Author equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj instanceof Author) {
            Author author = (Author) obj;
            return name.equals(author.name.trim()) &&
                    books.equals(author.books);
        }

        return false;
    }
}
