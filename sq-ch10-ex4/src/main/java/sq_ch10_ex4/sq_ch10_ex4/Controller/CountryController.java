package sq_ch10_ex4.sq_ch10_ex4.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sq_ch10_ex4.sq_ch10_ex4.DTO.Country;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country c = Country.of("France",67);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)  //changes the HTTP response status to 202 Accepted
                //Adds three custom headers to the response
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(c); //Sets the response body
    }
}
