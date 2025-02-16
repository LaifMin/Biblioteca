import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {

    private HashMap<String, Libro> libri;
    private TreeMap<String, Socio> soci;
    private HashMap<String, String> prestiti;

    public Biblioteca() {
        libri = new HashMap<>();
        soci = new TreeMap<>();
        prestiti = new HashMap<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.put(libro.getIsbn(), libro);
    }

    public void aggiungiSocio(Socio socio) {
        soci.put(socio.getCodiceFiscale(), socio);
    }

    public void registraPrestito(String isbn, String cf) {
        if (libri.containsKey(isbn) && soci.containsKey(cf) && !prestiti.containsKey(isbn)) {
            prestiti.put(isbn, cf);
            System.out.println("Prestito registrato con successo!");
        } else {
            System.out.println("Errore: libro/socio non trovati o libro già prestato");
        }
    }


    public void restituisciLibro(String isbn) {
        if (prestiti.remove(isbn) != null) {
            System.out.println("Libro restituito.");
        } else {
            System.out.println("Prestito non trovato.");
        }
    }


     public Libro cercaLibro(String isbn) {
        return libri.get(isbn);
    }

    public Socio cercaSocio(String cf) {
        return soci.get(cf);
    }

    public void mostraPrestiti() {
        if (prestiti.isEmpty()) {
            System.out.println("Nessun prestito in corso.");
        } else {
            for (Map.Entry<String, String> entry : prestiti.entrySet()) {
                System.out.println("Prestito[Libro ISBN=" + entry.getKey() + ", Socio CF=" + entry.getValue() + "]");
            }
        }
    }


    public void salvaSuFile(String nameF){
        
    }


}
