package angel.mathgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity {

    ImageButton si,no,salir;
    Button salto;
    TextView op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        si    =  (ImageButton)findViewById(R.id.imgbtnS);
        no    =  (ImageButton)findViewById(R.id.imgbtno);
        salto = (Button)findViewById(R.id.btnSaltar);
        op    = (TextView)findViewById(R.id.lblOpArt);

    }

    public void regresar(View v){
        Intent obj = new Intent(this,Main.class);
        startActivity(obj);
        finish();
    }

}
