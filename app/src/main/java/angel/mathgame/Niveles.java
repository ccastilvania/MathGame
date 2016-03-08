package angel.mathgame;

import clases.math;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveles extends AppCompatActivity {

    Button F,D;
    Intent obj;
    math objF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

        F=(Button)findViewById(R.id.btnNormal);
        D=(Button)findViewById(R.id.btnDificil);
        objF = new math();
    }

    public void facil(View v){
        obj = new Intent(this,Main.class);
        startActivity(obj);
    }
    public void dificil(View v){
        obj = new Intent(this,Main.class);
        startActivity(obj);
    }

}
