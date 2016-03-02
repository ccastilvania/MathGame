package angel.mathgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Reglas extends AppCompatActivity {

    ImageButton salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglas);

        salir = (ImageButton)findViewById(R.id.imgbtnSR);
    }

    public void salir(View v){
        Intent obj = new Intent(this,Main.class);
        startActivity(obj);
        finish();
    }
}
