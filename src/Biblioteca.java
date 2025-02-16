import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        } // sout per debug
    }

    public void restituisciLibro(String isbn) {
        if (prestiti.remove(isbn) != null) {
            System.out.println("Libro restituito.");
        } else {
            System.out.println("Prestito non trovato.");
        } // sout per debug
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
            } // sout per debug
        }
    }

    public void caricaLibriDaFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("libri.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String isbn = parts[0];
                    String titolo = parts[1];
                    libri.put(isbn, new Libro(isbn, titolo));
                } else {
                    System.out.println("Formato non valido per libro: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[INFO] File libri.txt non trovato. Verrà creato al primo salvataggio.");
        } catch (IOException e) {
            e.printStackTrace(); // sout per debug
        }
    }

    public void caricaSociDaFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("soci.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String cf = parts[0];
                    String nome = parts[1];
                    soci.put(cf, new Socio(cf, nome));
                } else {
                    System.out.println("Formato non valido per socio: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[INFO] File soci.txt non trovato. Verrà creato al primo salvataggio.");
        } catch (IOException e) {
            e.printStackTrace(); // sout per debug
        }
    }

    public void caricaPrestitiDaFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("prestiti.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String isbn = parts[0];
                    String cf = parts[1];

                    if (libri.containsKey(isbn) && soci.containsKey(cf)) {
                        prestiti.put(isbn, cf);
                    } else {
                        System.out.println("[WARN] Prestito non valido: " + line + " (libro/socio non trovato)");
                    }
                } else {
                    System.out.println("Formato non valido per prestito: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[INFO] File prestiti.txt non trovato. Verrà creato al primo salvataggio.");
        } catch (IOException e) {
            e.printStackTrace(); // sout per debug
        }
    }

    public void salvaLibriSuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("libri.txt"))) {
            for (Libro libro : libri.values()) {
                writer.write(libro.getIsbn() + "," + libro.getTitolo());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvaSociSuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("soci.txt"))) {
            for (Socio socio : soci.values()) {
                writer.write(socio.getCodiceFiscale() + "," + socio.getNome());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvaPrestitiSuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prestiti.txt"))) {
            for (Map.Entry<String, String> entry : prestiti.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaDati() {
        caricaLibriDaFile();
        caricaSociDaFile();
        caricaPrestitiDaFile();
    }


    private void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("[SUCCESS] File " + fileName + " eliminato.");
            } else {
                System.out.println("[ERROR] Impossibile eliminare " + fileName);
            }
        } else {
            System.out.println("[INFO] " + fileName + " non esiste.");
        }
    }// sout per debug

    public void deleteAllFileData() {
        deleteFile("libri.txt");
        deleteFile("soci.txt");
        deleteFile("prestiti.txt");
        // System.out.println("Tutti i file dei dati sono stati eliminati.");
    }

}

    

