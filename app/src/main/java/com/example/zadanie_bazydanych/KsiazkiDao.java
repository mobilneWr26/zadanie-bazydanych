package com.example.zadanie_bazydanych;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KsiazkiDao {

    @Insert
    void dodajKsiazke(Ksiazki ksiazka);

    @Delete
    void usunKsiazke(Ksiazki ksiazka);

    @Query("SELECT * FROM ksiazki")
    List<Ksiazki> pobierzWszystkie();

    @Query("DELETE FROM ksiazki")
    void usunWszystkie();
    @androidx.room.Update
    void aktualizujKsiazke(Ksiazki ksiazka);
}