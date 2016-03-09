package angel.mathgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class Puntuaciones extends AppCompatActivity {

    ImageButton salir;
    private String[] puntuacion;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuaciones);

        salir=(ImageButton)findViewById(R.id.imgbtnSP);
        list = (ListView)findViewById(R.id.puntos);
        puntuacion = new String[0];


    }
    private void llenar(){
        String puntos = getIntent().getExtras().getString("puntos");
        if(puntos != "si"){
            puntuacion[0]=puntos;
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, puntuacion);
            list.setAdapter(adaptador);
        }
    }

    public void salirP(View v){
        Intent obj = new Intent(this,Main.class);
        startActivity(obj);
        finish();
    }

}
