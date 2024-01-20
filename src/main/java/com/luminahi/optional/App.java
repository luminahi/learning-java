package com.luminahi.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.luminahi.optional.lib.Pokemon;

public class App {
    
    public static void mapping() {
                List<String> list = Arrays.asList("alex", "sora", "sarah", "karen");
        
        Optional<List<String>> optional = Optional.of(list);

        Optional<?> filterResult = optional.
            filter((value) -> value.size() > 2).
            filter((value) -> value.size() < 8);

        if (filterResult.isEmpty()) {
            System.out.println("totalmente vazio!");
        } else {
            System.out.println("cool! filter pass!");
        }

        Optional<Integer> mapResult = optional
            .map((value) -> value.size())
            .map((value) -> value * 10);

        if (mapResult.isEmpty()) {
            System.out.println("now empty!");
        } else {
            System.out.println("cool! map pass!");
        }

        Optional<Integer> flatMapResult = optional.flatMap((value) -> {
            if (value.size() > 2) {
                return Optional.ofNullable(value.size());
            } else {
                return Optional.empty();
            }
        });

        System.out.println(flatMapResult);
    }

    class FairyPokemon extends Pokemon {
        public FairyPokemon() {}
    }

    private static Optional<Pokemon> getPokemonByName(String pokemonName) {
        Pokemon pokemon = new Pokemon(pokemonName);
        return Optional.ofNullable(pokemon);
    }

    public static void main(String[] args) {
        // mapping();
        
        Optional<Pokemon> pokemon = getPokemonByName("pikachu");
        
        // checking if is present
        if (pokemon.isPresent()) pokemon.get().attack();
        
        // create a new one if value is not present
        pokemon.orElse(new Pokemon("a new pokemon"));

        // create a new pokemon using lambda
        pokemon.orElseGet(Pokemon::new);

        // returns a new optional of pokemon
        pokemon.or(() -> Optional.of(new Pokemon()));

        // if present, use function
        pokemon.ifPresent(Pokemon::attack);

        // in case this is null, return a appropriate value
        pokemon.map(Pokemon::getName).orElse("no string for you");

        // check if is a pokemon, if not, create a new default one
        pokemon.filter(Pokemon::isPokemon).orElseGet(Pokemon::new).attack();
    }
}
