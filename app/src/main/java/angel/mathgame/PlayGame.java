package angel.mathgame;

import clases.math;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGame extends AppCompatActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {

    ImageButton si,no;
    Button salto;
    TextView op,lblpunt,modo;
    Chronometer cronometro;

    math objm;
    double puntos = 0;
    long tiempoPausado = 0;
    char aux;
    String auxCrono;
    Boolean isPause = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        si    =  (ImageButton)findViewById(R.id.imgbtnS);
        si.setOnClickListener(this);
        no    =  (ImageButton)findViewById(R.id.imgbtno);
        no.setOnClickListener(this);
        salto = (Button)findViewById(R.id.btnSaltar);
        salto.setOnClickListener(this);

        op    = (TextView)findViewById(R.id.lblOpArt);
        modo    = (TextView)findViewById(R.id.lblmodo);
        lblpunt    = (TextView)findViewById(R.id.lblPuntuacion);
        cronometro = (Chronometer)findViewById(R.id.cronometro);
        cronometro.setOnChronometerTickListener(this);
        cronometro.start();
        tiempoPausado = 0;
        isPause= false;

        objm = new math();
        objm.setGenerar();
        op.setText(objm.getCadena());
        //modo.setText(" --- Nivel "+objm.getDificultad()+" --- ");
        si.setEnabled(true);
        no.setEnabled(true);
        salto.setEnabled(true);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.imgbtnS:
                aux = 'T';
                if(objm.getD()=='T' && aux=='T'){
                    sumar();
                    cambiarOP();
                }else if(objm.getD()=='F' && aux=='T'){
                    restar();
                    cambiarOP();
                }
                break;
            case R.id.imgbtno:
                aux='F';

                if(objm.getD()=='F' && aux =='F') {
                    sumar();
                    cambiarOP();
                }else if(objm.getD()=='T' && aux=='F'){
                    restar();
                    cambiarOP();
                }
                break;
            case R.id.btnSaltar:
                if(objm.getDificultad().equals("D")){
                    puntos -= 30;
                    lblpunt.setText("Puntuacion = " + puntos);
                }
                objm.setGenerar();
                op.setText(objm.getCadena());
                break;

            default:
                break;
        }
    }
    //
    //checa el tiempo en el que va

    public void onChronometerTick(Chronometer chronometer) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.pum);

        if (objm.getTiempo().equals(chronometer.getText())) {
            Toast.makeText(PlayGame.this, "SE TERMINO EL TIEMPO . . . ",
                    Toast.LENGTH_SHORT).show();
            op.setText("SE TERMINO EL TIEMPO . . .");
            si.setEnabled(false);
            no.setEnabled(false);
            salto.setEnabled(false);
            mp.start();
        }
        if("02:09".equals(chronometer.getText())){
            mp.stop();
            Intent obj = new Intent(this,Puntuaciones.class);
            startActivity(obj);
        }
    }

    public void regresar(View v){
        Intent obj = new Intent(this,Main.class);
        startActivity(obj);
        finish();
    }

    public void cambiarOP(){
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
            cambiarOP();
        }else if(objm.getD()=='F' && aux=='T'){
            restar();
            cambiarOP();
        }

    }
    public void verificarNo(View v){
        aux='F';

        if(objm.getD()=='F' && aux =='F') {
            sumar();
            cambiarOP();
        }else if(objm.getD()=='T' && aux=='F'){
            restar();
            cambiarOP();
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
        MediaPlayer mp = MediaPlayer.create(this, R.raw.error);
        mp.start();
        if(objm.getDificultad().equals("D")) {
            //descontar 10 segundos
        }else if(objm.getDificultad().equals("F")){
            puntos -= 8;
        }
        lblpunt.setText("Puntuacion = " + puntos);
    }

    public void onStop(){
        super.onStop();

        tiempoPausado=cronometro.getBase() - SystemClock.elapsedRealtime();
        cronometro.stop();
        isPause = true;
    }
    public void onPause(){
        super.onPause();

        tiempoPausado=cronometro.getBase() - SystemClock.elapsedRealtime();
        cronometro.stop();
        isPause = true;


    }
    public void onResume(){
        super.onResume();
        if(isPause){
            cronometro.setBase(SystemClock.elapsedRealtime() + tiempoPausado);
            cronometro.start();
            tiempoPausado = 0;
            isPause = false;
        }
    }


}
