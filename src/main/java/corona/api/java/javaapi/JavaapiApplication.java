package corona.api.java.javaapi;

import corona.api.java.javaapi.CoronaService.CoronaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class JavaapiApplication {




    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("==== api corona app is running ===== ");


        ConfigurableApplicationContext context = SpringApplication.run(JavaapiApplication.class, args);
        CoronaService coronaService = context.getBean(CoronaService.class);
        coronaService.fetchCoronaData();



    }

}
