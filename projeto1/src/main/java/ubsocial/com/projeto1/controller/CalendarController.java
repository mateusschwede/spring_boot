package ubsocial.com.projeto1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {

    @GetMapping("/today")
    public String today() {
        return "Hoje é " + java.time.LocalDate.now();
    }

    @GetMapping("/tomorrow")
    public String tomorrow() {
        return "Amanhã será " + java.time.LocalDate.now().plusDays(1);
    }

}
