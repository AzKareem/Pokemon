import java.io.IOException;

public class Practice {
    public static void main(String[] args) throws IOException {

PokemonDataReader pokemons = new PokemonDataReader();

        pokemons.readWithBufferedReader("C:\\Users\\Codersbay\\IdeaProjects\\Pokemon\\src\\resources\\2023-03-13-Pokemon.csv");
    pokemons.displayAllPokemons();
    }
}
