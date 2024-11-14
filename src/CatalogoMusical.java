import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoMusical {
    private List<Disco> discos;
    private List<Artista> artistas;

    public CatalogoMusical() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }


    public void cadastrarArtista(String nome, String genero) {
        Artista artista = new Artista(nome, genero);
        artistas.add(artista);
        System.out.println("Artista cadastrado com sucesso.");
    }

    
    public void cadastrarDisco(String titulo, int anoLancamento, List<String> faixas, Artista artista) {
        Disco disco = new Disco(titulo, anoLancamento, faixas, artista);
        discos.add(disco);
        System.out.println("Disco cadastrado com sucesso.");
    }

    
    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Não há discos cadastrados.");
        } else {
            for (Disco disco : discos) {
                System.out.println(disco);
            }
        }
    }

    
    public void editarDisco(String titulo, String novoTitulo, int novoAnoLancamento, List<String> novasFaixas) {
        for (Disco disco : discos) {
            if (disco.getTitulo().equals(titulo)) {
                disco = new Disco(novoTitulo, novoAnoLancamento, novasFaixas, disco.getArtista());
                System.out.println("Disco editado com sucesso.");
                return;
            }
        }
        System.out.println("Disco não encontrado.");
    }

    
    public void removerDisco(String titulo) {
        discos.removeIf(disco -> disco.getTitulo().equals(titulo));
        System.out.println("Disco removido com sucesso.");
    }

    
    public void listarArtistas() {
        if (artistas.isEmpty()) {
            System.out.println("Não há artistas cadastrados.");
        } else {
            for (Artista artista : artistas) {
                System.out.println(artista);
            }
        }
    }

    
    public void removerArtista(String nome) {
        artistas.removeIf(artista -> artista.getNome().equals(nome));
        System.out.println("Artista removido com sucesso.");
    }
    
    public static void main(String[] args) {
        CatalogoMusical catalogo = new CatalogoMusical();
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.println("Bem-vindo ao Catálogo Musical!");
        
        
        catalogo.cadastrarArtista("The Beatles", "Rock");
        catalogo.cadastrarArtista("Adele", "Pop");
        
        
        List<String> faixasBeatles = List.of("Hey Jude", "Let It Be", "Come Together");
        catalogo.cadastrarDisco("Abbey Road", 1969, faixasBeatles, catalogo.artistas.get(0));
        
        List<String> faixasAdele = List.of("Hello", "Someone Like You", "Rolling in the Deep");
        catalogo.cadastrarDisco("21", 2011, faixasAdele, catalogo.artistas.get(1));

        
        System.out.println("\nLista de Discos:");
        catalogo.listarDiscos();
        
        
        System.out.println("\nEditando o disco 'Abbey Road'...");
        List<String> novasFaixas = List.of("Something", "Here Comes The Sun");
        catalogo.editarDisco("Abbey Road", "Abbey Road - Remasterizado", 1969, novasFaixas);
        
        
        System.out.println("\nLista de Discos Atualizada:");
        catalogo.listarDiscos();
        
        
        System.out.println("\nRemovendo o disco '21'...");
        catalogo.removerDisco("21");
        
        
        System.out.println("\nLista de Discos Atualizada após Remoção:");
        catalogo.listarDiscos();
        
        
        System.out.println("\nLista de Artistas:");
        catalogo.listarArtistas();
    }
}
