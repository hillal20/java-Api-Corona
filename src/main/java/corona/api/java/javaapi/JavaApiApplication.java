package corona.api.java.javaapi;

import corona.api.java.javaapi.CoronaService.CoronaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class JavaApiApplication {




    public static void main(String[] args) throws IOException, InterruptedException {

          SpringApplication.run(JavaApiApplication.class, args);


        System.out.println("==== api corona app is running ===== ");


//        ConfigurableApplicationContext context = SpringApplication.run(JavaApiApplication.class, args);
//        CoronaService coronaService = context.getBean(CoronaService.class);
//        coronaService.fetchCoronaData();



    }

}
