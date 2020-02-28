package corona.api.java.javaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class JavaapiApplication {


    private static String coronaDataUrl = "https://raw.githubusercontent.com/hillal20/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(JavaapiApplication.class, args);

        System.out.println("==== api corona app is running ===== ");



        HttpClient  httpClient  =  HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(coronaDataUrl))
                .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());



        System.out.println("response  =====> "+ response.body());
    }

}
