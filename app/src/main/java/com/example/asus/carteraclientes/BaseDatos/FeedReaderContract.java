package com.example.asus.carteraclientes.BaseDatos;
import android.provider.BaseColumns;

public final class FeedReaderContract {
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "CLIENTES";
        public static final String COLUMN_NAME = "NOMBRE";
        public static final String COLUMN_DIREC = "DIRECCION";
        public static final String COLUMN_EMAIL = "EMAIL";
        public static final String COLUMN_NUMBER = "TELEFONO";
    }
}