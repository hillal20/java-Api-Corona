package corona.api.java.javaapi.CoronaService;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class CoronaService {
    private static String coronaDataUrl = "https://raw.githubusercontent.com/hillal20/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
  public void fetchCoronaData ()  throws IOException, InterruptedException {

      HttpClient httpClient  =  HttpClient.newHttpClient();
      HttpRequest httpRequest = HttpRequest.newBuilder()
              .uri(URI.create(coronaDataUrl))
              .build();

      HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.out.println("response  =====> "+ response.body());


  }
}
