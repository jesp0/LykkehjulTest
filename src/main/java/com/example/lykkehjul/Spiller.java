package com.example.lykkehjul;

public class Spiller {

    private String navn;
    private String epost;
    private int tlf;

    public Spiller(String navn, String epost, int tlf){
        setNavn(navn);
        setEpost(epost);
        setTlf(tlf);
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    public void setEpost(String epost) {
        this.epost = epost;
    }
    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
}
