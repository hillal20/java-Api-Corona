package corona.api.java.javaapi.CoronaController;


import corona.api.java.javaapi.CoronaModel.CoronaModel;
import corona.api.java.javaapi.CoronaService.CoronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoronaController {

    @Autowired
    CoronaService coronaService;
    @GetMapping("/home")
    public String getCoronaData(Model uiModel){

        uiModel.addAttribute("coronaStats",   coronaService.getResults());

        // thymleaf
       return "home.html";
    }




}
