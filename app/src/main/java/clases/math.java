package clases;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class math {

    //Variables Globales
    double n1=0,n2=0,res=0;
    private String comp = null,operacion=null,cadena=null,auxDes=null;
    private char D;
    private String tiempo="02:00";
    private String dif ="F";
    final String[] op = {"+", "-", "*", "/","^"};
    final String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    final String[] aux = {"s","n","s","n","n","n","s","n","s","s","n","s","s","s","n","s","n",};

    //Constructor
    public math(){

    }

    // Propiedades

    // SET
    public void setGenerar(){
        generarOP();
    }
    public void setTiempo(String t){
        tiempo = t;
    }
    public void setDificultad( String dif){
        this.dif = dif;
    }
    //GET
    public String getCadena(){
        return cadena;
    }
    public BigDecimal getRes(){
        BigDecimal big = new BigDecimal(res);
        big = big.setScale(2, RoundingMode.HALF_UP);
        return big;
    }
    public char getD(){
        return  D;
    }
    public String getDificultad(){
        return dif;
    }
    public String getTiempo(){
        return tiempo;
    }



    // Metodos de las operaciones
    private void sumar(double n1,double n2){
       try {
           res = n1+n2;
       }catch (Exception ex){
           res = 0.00;
       }

    }
    private void restar(double n1,double n2){
        try {
            res = n1-n2;
        }catch (Exception ex){
            res = 0.00;
        }
    }
    private void multiplicar(double n1,double n2){
        try {
            res = n1*n2;
        }catch (Exception ex){
            res = 0.00;
        }
    }
    private void dividir(double n1,double n2){
        try {
            res = n1/n2;
        }catch (Exception ex){
            res = 0.00;
        }
    }
    private void potencia(double n1,double n2){
        try {
            res = Math.pow(n1,n2);
        }catch (Exception ex){
            res = 0.00;
        }

    }
    private void comparaciones(double n1, double n2){
        if(n1 > n2){
            comp = "mayor primero";
        }else if (n1 < n2){
            comp = "menor primero";
        }else{
            comp = "iguales";
        }
    }

    // Genera la operacion de manera aleatoria y la resuelve
    private void generarOP(){
        try {
            Random random = new Random();

            int numero1 = random.nextInt(num.length);
            int signo = random.nextInt(op.length);
            int numero2 = random.nextInt(num.length);
            int des = random.nextInt(aux.length);

            n1 = Double.parseDouble(num[numero1]);
            n2 = Double.parseDouble(num[numero2]);
            operacion = op[signo];
            auxDes = aux[des];

            switch (operacion) {
                case "+":
                    sumar(n1, n2);
                    break;
                case "-":
                    restar(n1, n2);
                    break;
                case "*":
                    multiplicar(n1, n2);
                    break;
                case "^":
                    potencia(n1, n2);
                    break;
                case "/":
                    dividir(n1, n2);
                    break;
                default:
                    break;
            }

            if (auxDes.equals("s")) {
                cadena = n1 + op[signo] + n2 + "=" + getRes();
                D = 'T';
            } else {
                D = 'F';
                BigDecimal big;
                try {
                    big = new BigDecimal((Math.random()* 200 + 1));
                    big = big.setScale(2, RoundingMode.HALF_UP);
                    cadena = n1 + op[signo] + n2 + "=" + big;
                } catch (Exception ex) {
                    cadena = n1 + op[signo] + n2 + "= 0.05";
                }

            }
        }catch (Exception ex){
            generarOP();
        }
    }
}
