package com.example.zadanie_bazydanych;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ksiazki")
public class Ksiazki {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String autor;
    public String tytul;
    public double cena;
    public int liczbaStron;

    public Ksiazki(String autor, String tytul, double cena, int liczbaStron) {
        this.autor = autor;
        this.tytul = tytul;
        this.cena = cena;
        this.liczbaStron = liczbaStron;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getLiczbaStron() {
        return liczbaStron;
    }

    public void setLiczbaStron(int liczbaStron) {
        this.liczbaStron = liczbaStron;
    }

    @Override
    public String toString() {
        return "Ksiazki{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", tytul='" + tytul + '\'' +
                ", cena=" + cena +
                ", liczbaStron=" + liczbaStron +
                '}';
    }
}