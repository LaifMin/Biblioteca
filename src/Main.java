public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.caricaDati(); 

        
        biblioteca.aggiungiLibro(new Libro("978-3-16-148410-0", "Il Signore degli Anelli"));
        biblioteca.aggiungiSocio(new Socio("RSSMRA85M01H501Z", "Mario Rossi"));

        
        
       
        biblioteca.salvaLibriSuFile();
        biblioteca.salvaSociSuFile();
        biblioteca.salvaPrestitiSuFile();

       
        biblioteca.mostraPrestiti();
        //biblioteca.deleteAllFileData();
    }
}