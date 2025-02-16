public class Main {
    
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.aggiungiLibro(new Libro("978-3-16-148410-0", "Il Signore degli Anelli"));
        biblioteca.aggiungiSocio(new Socio("RSSMRA85M01H501Z", "Mario Rossi"));

        biblioteca.registraPrestito("978-3-16-148410-0", "RSSMRA85M01H501Z");
        biblioteca.mostraPrestiti();  

        //sout fuori dal main per scopo pienamente dimostrativo
    }
}
