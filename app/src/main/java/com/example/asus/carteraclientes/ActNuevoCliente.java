package com.example.asus.carteraclientes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.asus.carteraclientes.BaseDatos.DatosOpenHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.carteraclientes.BaseDatos.FeedReaderContract;
import com.example.asus.carteraclientes.BaseDatos.FeedReaderContract.FeedEntry;

public class ActNuevoCliente extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtDireccion;
    private EditText edtEmail;
    private EditText edtTelefono;

    private SQLiteDatabase conexion;
    private DatosOpenHelper datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nuevo_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_nuevo_cliente, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.action_ok:
                if (bCamposCorrectos()){
                    try {
                        datosOpenHelper = new DatosOpenHelper( this);
                        conexion = datosOpenHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put(FeedEntry.COLUMN_NAME, edtNombre.getText().toString().trim());
                        values.put(FeedEntry.COLUMN_DIREC, edtDireccion.getText().toString().trim());
                        values.put(FeedEntry.COLUMN_EMAIL, edtEmail.getText().toString().trim());
                        values.put(FeedEntry.COLUMN_NUMBER, edtTelefono.getText().toString().trim());
                        finish();

                        conexion.insert(FeedEntry.TABLE_NAME, null, values);
                        conexion.close();

                    }   catch (Exception ex){
                        AlertDialog.Builder dlg = new AlertDialog.Builder( this);
                        dlg.setTitle("Aviso");
                        dlg.setMessage(ex.getMessage());
                        dlg.setNeutralButton( "OK", null);
                        dlg.show();
                    }
                }
                else{
                    AlertDialog.Builder dlg = new AlertDialog.Builder( this);
                    dlg.setTitle("Aviso");
                    dlg.setMessage("Existen campos vacios");
                    dlg.setNeutralButton( "OK", null);
                    dlg.show();
                    break;
                }
                break;

            case R.id.action_cancelar:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean bCamposCorrectos() {
        boolean res = true;
        if (edtNombre.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if (edtDireccion.getText().toString().trim().isEmpty()) {
            edtDireccion.requestFocus();
            res = false;
        }
        if (edtEmail.getText().toString().trim().isEmpty()) {
            edtEmail.requestFocus();
            res = false;
        }
        if (edtTelefono.getText().toString().trim().isEmpty()) {
            edtTelefono.requestFocus();
            res = false;
        }
        return res;
    }
}
