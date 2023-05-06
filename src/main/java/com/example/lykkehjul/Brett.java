package com.example.lykkehjul;

import java.util.ArrayList;

public class Brett {

    private ArrayList<ArrayList<Integer>> spillerBrett = new ArrayList<>();
    private ArrayList<Integer> rekke = new ArrayList<>();
    private Spiller spiller;

    public Brett(Spiller spiller){
        //spillerBrett.add(new ArrayList<>());
        this.spiller = spiller;


    }

    // brukes for å legge den nye rekken til bruker inn i brettet
    private void leggTilRekke(int[] rekke){
        spillerBrett.add(new ArrayList<>());
        for (int i=0; i<rekke.length;i++){
            // Finner denne sizen den siste ArrayList-en eller ikke?
            spillerBrett.get(spillerBrett.size()).add(rekke[i]);
        }

    }
}
