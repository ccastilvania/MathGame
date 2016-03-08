package angel.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button btnJ;
    Button btnR,btnP,btnN,btnS;
    Intent obj;
    String nivel="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnJ   = (Button)findViewById(R.id.btnJugar);
        btnR   = (Button)findViewById(R.id.btnReglas);
        btnP   = (Button)findViewById(R.id.btnPuntuacion);
        btnN   = (Button)findViewById(R.id.btnDif);
        btnS   = (Button)findViewById(R.id.btnSalir);
        nivel  = "Facil";
    }

    public void jugar(View v){
        obj = new Intent(this,PlayGame.class);
        startActivity(obj);
    }
    public void reglas(View v){
        obj = new Intent(this,Reglas.class);
        startActivity(obj);
    }
    public void puntuacion(View v){
        obj = new Intent(this,Puntuaciones.class);
        startActivity(obj);
    }
    public void dificultad(View v){
        obj = new Intent(this,Niveles.class);
        startActivity(obj);

    }
    public void salir(View v){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
