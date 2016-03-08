package angel.mathgame;

import clases.math;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity {

    ImageButton si,no;
    Button salto;
    TextView op,lblpunt,modo;

    math objm;
    double puntos=0;
    char aux;


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
        modo    = (TextView)findViewById(R.id.lblmodo);
        lblpunt    = (TextView)findViewById(R.id.lblPuntuacion);
        objm = new math();
        objm.setGenerar();
        op.setText(objm.getCadena());
        //modo.setText(" --- Nivel "+objm.getDificultad()+" --- ");

    }

    public void regresar(View v){
        Intent obj = new Intent(this,Main.class);
        startActivity(obj);
        finish();
    }

    public void cambiarOP(View v){
        if(objm.getDificultad().equals("D")){
            puntos -= 30;
            lblpunt.setText("Puntuacion = " + puntos);
        }
        objm.setGenerar();
        op.setText(objm.getCadena());
    }

    public void verificarSi(View v){
        aux = 'T';
        if(objm.getD()=='T' && aux=='T'){
            sumar();
            cambiarOP(v);
        }else if(objm.getD()=='F' && aux=='T'){
            restar();
            cambiarOP(v);
        }

    }
    public void verificarNo(View v){
        aux='F';

        if(objm.getD()=='F' && aux =='F') {
            sumar();
            cambiarOP(v);
        }else if(objm.getD()=='T' && aux=='F'){
            restar();
            cambiarOP(v);
        }

    }
    private void sumar(){
        if(objm.getDificultad().equals("D")) {
            puntos += 10;
        }else if(objm.getDificultad().equals("F")){
            puntos += 8;
        }
        lblpunt.setText("Puntuacion = " + puntos);

    }
    private void restar(){
        if(objm.getDificultad().equals("D")) {
            //descontar 10 segundos
        }else if(objm.getDificultad().equals("F")){
            puntos -= 8;
        }
        lblpunt.setText("Puntuacion = " + puntos);
    }


}
