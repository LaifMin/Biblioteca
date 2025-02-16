import java.io.Serializable;

public class Prestito implements Serializable {
    private String isbnLibro;
    private String codiceFiscaleSocio;

    public Prestito(String isbnLibro, String codiceFiscaleSocio) {
        this.isbnLibro = isbnLibro;
        this.codiceFiscaleSocio = codiceFiscaleSocio;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public String getCodiceFiscaleSocio() {
        return codiceFiscaleSocio;
    }

    @Override
    public String toString() {
        return "Prestito[Libro ISBN=" + isbnLibro + ", Socio CF=" + codiceFiscaleSocio + "]";
    }
}
