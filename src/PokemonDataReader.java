import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDataReader {
    private List<Pokemon> pokemons;

    public PokemonDataReader() {
        pokemons = new ArrayList<>();
    }

    public List<Pokemon> readWithBufferedReader(String csvFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
            reader.readLine(); // Skip the header line
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(";");
                if (parts.length >= 11) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String type1 = parts[2];
                    String type2 = parts[3].isEmpty() ? null : parts[3];
                    int total = Integer.parseInt(parts[4]);
                    int hp = Integer.parseInt(parts[5]);
                    int attack = Integer.parseInt(parts[6]);
                    int defense = Integer.parseInt(parts[7]);
                    int spAtk = Integer.parseInt(parts[8]);
                    int spDef = Integer.parseInt(parts[9]);
                    int speed = Integer.parseInt(parts[10]);

                    Pokemon pokemon = new Pokemon(id, name, type1, type2, total, hp, attack, defense, spAtk, spDef, speed);
                    pokemons.add(pokemon);
                }
            }

        return pokemons;
    }

    public void displayAllPokemons() {
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getID() + " " + pokemon.getName() + " " + pokemon.getType1() + " " + pokemon.getType2() + " " + pokemon.getTotal() + " " + pokemon.getHp() + " " + pokemon.getAttack() + " " + pokemon.getDefense() + " " + pokemon.getSpAtk() + " " + pokemon.getSpDef() + " " + pokemon.getSpeed());
        }
    }
}
