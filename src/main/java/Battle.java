package main.java;


import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Battle {


    private boolean statusGame = false;
    private Pokemon playerPokemon;
    private Pokemon computerPokemon;


    public void displayBattleInformation() throws IOException {

        PokemonDataReader pokemons = new PokemonDataReader();

        PokemonDataReader attacks = new PokemonDataReader();


        playerPokemon = pokemons.getRandomPokemon();
        playerPokemon.setAttackPrimary(attacks.getRandomAttack());
        playerPokemon.setAttackSecondary(attacks.getRandomAttack());

        computerPokemon = pokemons.getRandomPokemon();
        computerPokemon.setAttackPrimary(attacks.getRandomAttack());
        computerPokemon.setAttackSecondary(attacks.getRandomAttack());


        if (playerPokemon == null && computerPokemon == null) {
            throw new IllegalArgumentException("Some information's are missing!");

        }
        System.out.println("Player's Pokemon: " + playerPokemon.getName());
        System.out.println("Primary Attack: " + playerPokemon.getAttackPrimary().getName());
        System.out.println("Secondary Attack: " + playerPokemon.getAttackSecondary().getName());
        System.out.println("-----------------------------------");
        System.out.println("Computer's Pokemon: " + computerPokemon.getName());
        System.out.println("Primary Attack: " + computerPokemon.getAttackPrimary().getName());
        System.out.println("Secondary Attack: " + computerPokemon.getAttackSecondary().getName());

    }

    public void startBattle() throws IOException {

        displayBattleInformation();

        while (!statusGame) {
            if (playerPokemon.getSpeed() >= computerPokemon.getSpeed()) {
                attackPokemonComputer();
                if (computerPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("The Battle is over, the winner is Player!");
                    break;
                }

                attackPokemonPlayer();
                if (playerPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("The Battle is over, the winner is Computer!");
                    break;
                }
            } else{
                attackPokemonPlayer();
                if (playerPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("The Battle is over, the winner is Computer!");
                    break;
                }

                attackPokemonComputer();
                if (computerPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("The Battle is over, the winner is Player!");
                    break;
                }
            }
        }
    }

    private void attackPokemonPlayer() {


        int damage;
        Random random = new Random();
        int attackOption = random.nextInt(2) + 1; // Randomly select 1 or 2


        if (attackOption == 1) {
            damage = (int) ((computerPokemon.getAttackPrimary().getPower()) * (computerPokemon.getAttack() / playerPokemon.getDefense()) * (1.0 / 25.0));
            playerPokemon.setHp(playerPokemon.getHp() - damage);
            System.out.println("Computer used " + computerPokemon.getAttackPrimary().getName());
        } else if (attackOption == 2) {
            damage = (int) ((computerPokemon.getAttackSecondary().getPower()) * (computerPokemon.getAttack() / playerPokemon.getDefense()) * (1.0 / 25.0));
            playerPokemon.setHp(playerPokemon.getHp() - damage);
            System.out.println(" Computer used " + computerPokemon.getAttackSecondary().getName());
        } else {
            System.out.println("Invalid attack option. Try again.");
            return;
        }


        System.out.println("Player's HP: " + playerPokemon.getHp());
    }

    private void attackPokemonComputer() {
        Scanner sc = new Scanner(System.in);
        int attackOption;
        int damage;
        System.out.println("Player, choose your attack!");
        System.out.println("1. " + playerPokemon.getAttackPrimary().getName());
        System.out.println("2. " + playerPokemon.getAttackSecondary().getName());
        attackOption = sc.nextInt();

        if (attackOption == 1) {
            damage = (int) ((playerPokemon.getAttackPrimary().getPower()) * (playerPokemon.getAttack() / computerPokemon.getDefense()) * (1.0 / 25.0));

            computerPokemon.setHp(computerPokemon.getHp() - damage);
            System.out.println("Player used " + playerPokemon.getAttackPrimary().getName());
        } else if (attackOption == 2) {
            damage = (int) ((playerPokemon.getAttackSecondary().getPower()) * (playerPokemon.getAttack() / computerPokemon.getDefense()) * (1.0 / 25.0));

            computerPokemon.setHp(computerPokemon.getHp() - damage);
            System.out.println("Player  used " + playerPokemon.getAttackSecondary().getName());
        } else {
            System.out.println("Invalid attack option. Try again.");
            return;
        }


        System.out.println("Computer's HP: " + computerPokemon.getHp());
    }

}
