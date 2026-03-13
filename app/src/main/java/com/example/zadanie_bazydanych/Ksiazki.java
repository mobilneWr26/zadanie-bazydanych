package com.example.zadanie_bazydanych;

public class Ksiazki {
    private int id;
    private String tytul, autor;
    private int iloscStron;
    private double cena;

    public Ksiazki(int id, String tytul, String autor, int iloscStron, double cena) {
        this.id = id;
        this.tytul = tytul;
        this.autor = autor;
        this.iloscStron = iloscStron;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getIloscStron() {
        return iloscStron;
    }

    public void setIloscStron(int iloscStron) {
        this.iloscStron = iloscStron;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @Override
    public String toString() {
        return "Ksiazki{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", iloscStron=" + iloscStron +
                ", cena=" + cena +
                '}';
    }
}
