package Models;

import java.util.LinkedList;
import java.util.List;

public class AuthorsContainer {
    private List<Author> authors;

    public AuthorsContainer() {
        authors = new LinkedList<Author>();
    }
  
    public List<Author> getAuthors(){
        return authors;
    }

    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }

    public Author getAuthor(int id){
        return authors.get(id);
    }

}
