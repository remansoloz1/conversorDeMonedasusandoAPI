import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/60ed7d9d67f92b6d986f1a34/latest/USD");
    Gson gson=new Gson();
    private String inicialMoneda;

    public String getInicialMoneda() {
        return inicialMoneda;
    }

    public void setInicialMoneda(String inicialMoneda) {
        this.inicialMoneda = inicialMoneda;
    }

    public Double consultaYCalulo(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        {
            try {
                HttpResponse<String> response;
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json=response.body();

                Monedas monedas=gson.fromJson(json,Monedas.class);
                return monedas.conversion_rates().get(inicialMoneda);
            } catch (Exception e) {
                System.out.println("No encontre lo solicitado\n "+e.getMessage());

                return null;
            }
        }

    }
}
