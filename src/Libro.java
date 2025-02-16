import java.io.Serializable;

public class Libro implements Serializable {
    private String isbn;
    private String titolo;

    public Libro(String isbn, String titolo) {
        this.isbn = isbn;
        this.titolo = titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "Libro[ISBN=" + isbn + ", Titolo=" + titolo + "]";
    }
}
