import java.io.Serializable;

public class Socio implements Serializable {
    private String codiceFiscale;
    private String nome;

    public Socio(String codiceFiscale, String nome) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Socio[CF=" + codiceFiscale + ", Nome=" + nome + "]";
    }
}
