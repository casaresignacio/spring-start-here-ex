package sq_ch10_ex3.sq_ch10_ex3.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sq_ch10_ex3.sq_ch10_ex3.DTO.Country;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france(){
        Country c = Country.of("France", 67);
        return c;
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("France",67);
        Country c2 = Country.of("Spain",47);

        //returns a collection in the HTTP response body
        return List.of(c1,c2);
    }
}
