package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PokemonDataReader {

    public static final String POKEMON_CSV_FILE_PATH = "./data/2023-03-13-Pokemon.csv";
    public static final String ATTACK_CSV_FILE_PATH = "./data/2023-04-03-Attacks.csv";
    private final HashMap<Integer, Pokemon> pokemons;
    private final HashMap<Integer, Attack> attacks;

    public PokemonDataReader() {

        pokemons = new HashMap<>();
        attacks = new HashMap<>();
    }


    public void loadPokemons() throws IOException {
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new FileReader(POKEMON_CSV_FILE_PATH));
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
                pokemons.put(id, pokemon);


            }
        }
        reader.close();
    }

    public void loadAttacks() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ATTACK_CSV_FILE_PATH));
        reader.readLine(); // Skip the header line
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {

            String[] parts = currentLine.split(";");
            if (parts.length >= 8) {

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String effect = parts[2];
                String type = parts[3];
                String kind = parts[4];
                int power = Integer.parseInt(parts[5]);
                String accuracy = parts[6];
                int pp = Integer.parseInt(parts[7]);

                Attack attack = new Attack(id, name, effect, type, kind, power, accuracy, pp);
                attacks.put(id, attack);
            }
        }
        reader.close();
    }

    public void displayAllPokemons() {
        for (Map.Entry<Integer, Pokemon> entry : pokemons.entrySet()) {
            Pokemon pokemon = entry.getValue();
            System.out.println(pokemon.getID() + " " + pokemon.getName() + " " + pokemon.getType1() + " " + pokemon.getType2() + " " + pokemon.getTotal() + " " + pokemon.getHp() + " " + pokemon.getAttack() + " " + pokemon.getDefense() + " " + pokemon.getSpAtk() + " " + pokemon.getSpDef() + " " + pokemon.getSpeed());
        }
    }

    public void displayAllAttacks() {
        for (Map.Entry<Integer, Attack> entry : attacks.entrySet()) {
            Attack attack = entry.getValue();
            System.out.println(attack.getId() + " " + attack.getName() + " " + attack.getEffect() + " " + attack.getType() + " " + attack.getKind() + " " + attack.getPower() + " " + attack.getAccuracy() + " " + attack.getPp());
        }
    }

    public Pokemon printPokemonDetails(int pokemonId) {
        Pokemon pokemon = pokemons.get(pokemonId);
        if (pokemon != null) {

            System.out.println(pokemon.getName() + " " + pokemon.getType1() + " " + pokemon.getType2() + " " + pokemon.getTotal() + " " + pokemon.getHp() + " " + pokemon.getAttack() + " " + pokemon.getDefense() + " " + pokemon.getSpAtk() + " " + pokemon.getSpDef() + " " + pokemon.getSpeed());
            System.out.println("-----------------------------------");

        } else {
            System.out.println("Pokemon not found for ID: " + pokemonId);
        }
        return pokemon;
    }

    public Pokemon getRandomPokemon() throws IOException {
        loadPokemons();
        if (pokemons.isEmpty()) {
            throw new NoSuchElementException("There are no pokemons right now!");
        }

        Random random = new Random();

        int randomIndex = random.nextInt(pokemons.size());

        return pokemons.get(randomIndex);
    }

    public Attack getRandomAttack() throws IOException {
        loadAttacks();
        if (attacks.isEmpty()) {
            throw new NoSuchElementException("There are no attacks right now!");
        }
        Random random = new Random();


        int randomAttackId = random.nextInt(attacks.size()) + 1; // Adding 1 to avoid selecting attack with ID 0
        Attack randomAttack = attacks.get(randomAttackId);
        attacks.remove(randomAttackId);   // noch etwas umändern
        return randomAttack;
    }


}
