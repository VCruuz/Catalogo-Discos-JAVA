import java.util.List;

public class Disco {
    private String titulo;
    private int anoLancamento;
    private List<String> faixas;
    private Artista artista;

    public Disco(String titulo, int anoLancamento, List<String> faixas, Artista artista) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.faixas = faixas;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public List<String> getFaixas() {
        return faixas;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "Disco: " + titulo + " | Ano: " + anoLancamento + " | Artista: " + artista.getNome();
    }
}

