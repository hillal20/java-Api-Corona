package corona.api.java.javaapi.CoronaService;

import corona.api.java.javaapi.CoronaModel.CoronaModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


//@Component
@Service
public class CoronaService {


    private static String coronaDataUrl = "https://raw.githubusercontent.com/hillal20/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

    private  List<CoronaModel> results = new ArrayList<>();

    public List<CoronaModel> getResults() {
        return results;
    }

    public void setResults(List<CoronaModel> results) {
        this.results = results;
    }

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")                // this will precise time of  the execution of the fetching seconds minutes hours day month year
  public void fetchCoronaData ()  throws IOException, InterruptedException {

      HttpClient httpClient  =  HttpClient.newHttpClient();
      HttpRequest httpRequest = HttpRequest.newBuilder()
              .uri(URI.create(coronaDataUrl))
              .build();

      HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      System.out.println("response  =====> "+ response.body());



      //// reading the csv file
        StringReader csvText = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvText);
        List<CoronaModel>  tempList = new ArrayList<>();
        for (CSVRecord record : records) {

            String state = record.get("Province/State");
            String country  = record.get("Country/Region");
            String lastStat = record.get(record.size() -1);


           CoronaModel instance = new CoronaModel();
           instance.setCountry(country);
           instance.setLatestStats(lastStat);
           instance.setProvince(state);


          tempList.add(instance);


        }

      this.results =  tempList;

    }
}
