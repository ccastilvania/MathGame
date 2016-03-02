package angel.mathgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveles extends AppCompatActivity {

    Button F,D;
    Intent obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);

        F=(Button)findViewById(R.id.btnNormal);
        D=(Button)findViewById(R.id.btnDificil);
    }

    public void regresar(){
        obj = new Intent(this,Main.class);
        startActivity(obj);
    }

    public void facil(View v){
        regresar();
    }
    public void dificil(View v){
        regresar();
        finish();
    }

}
