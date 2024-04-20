package com.upn.contactsapp.entities;

import java.util.List;

public class PokemonResponse {
    public int count;
    public String next;
    public String previous;

    public List<PokemonResult> results;

    public class PokemonResult {
        public String name;
        public String url;
    }
}
