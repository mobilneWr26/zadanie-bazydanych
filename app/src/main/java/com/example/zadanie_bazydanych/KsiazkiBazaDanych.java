package com.example.zadanie_bazydanych;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database( entities = {Ksiazki.class}, version = 2)
public abstract class KsiazkiBazaDanych extends RoomDatabase{
    public abstract KsiazkiDao zwrocKsiazkiDao();
    private static KsiazkiBazaDanych instancja;
    public static KsiazkiBazaDanych zwrocInstancjeBazyDanych(Context context){
        if(instancja == null){
            instancja = Room.databaseBuilder(context, KsiazkiBazaDanych.class, "ksiazki_db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instancja;
    }
}
