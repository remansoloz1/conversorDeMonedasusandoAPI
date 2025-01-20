import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    Scanner keyboard=new Scanner(System.in);
    ConsultaMoneda consulta=new ConsultaMoneda();

    public void realizarConversion(String monedaUno,String monedaDos,String monedaDeCambio,boolean multiplica){
        consulta.setInicialMoneda(monedaDeCambio);
        System.out.println("Ingresa valor");
        double valor=keyboard.nextDouble();
        double tasaDeCambio= consulta.consultaYCalulo();
        double resultado=multiplica?valor*tasaDeCambio:valor/tasaDeCambio;
       // String operacion=multiplica?"USD":monedaDeCambio;
        //String destino=multiplica?monedaDeCambio:"USD";
        System.out.println("El valor "+valor+"["+monedaUno+"] corresponde "+
                " al valor final de =>> "+resultado+"["+monedaDos+"]");
    }
    public static void main(String[] args){

        Principal princip=new Principal();
        int opc=0;

        String menu= """
                Sea bienvenido/a al Conversor de Moneda =)
                 1) Dólar  =>>  Peso Argentino 
                 2) Peso Argentino  =>>  Dólar 
                 3) Dólar  =>>  Real brasileño
                 4) Real brasileño  =>>  Dólar
                 5) Dólar  =>>  Peso Colombiano
                 6) Peso Colombiano  =>>  Dólar
                 7) Salir
                """;


        Scanner keyboard = new Scanner(System.in);
       // System.out.println("ingrese valor: ");
        double valor=0.0;




        while(opc!=7){
            System.out.println(menu);
            System.out.println("Elija una opcion valida\n*********************************************");
            opc=keyboard.nextInt();
            switch(opc){

                case 1:

                    princip.realizarConversion("USD","ARS","ARS",true);

                    break;
                case 2:
                    princip.realizarConversion("ARS","USD","ARS",false);

                    break;
                case 3:
                    princip.realizarConversion("USD","BRL","BRL",true);
                    break;

                case 4:
                    princip.realizarConversion("BRL","USD","BRL",false);
                    break;
                case 5:
                    princip.realizarConversion("USD","COP","COP",true);
                    break;
                case 6:
                    princip.realizarConversion("COP","USD","COP",false);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Ingreso opcion incorrecta, intente nuevamente");break;
            }
        }


    }
}
