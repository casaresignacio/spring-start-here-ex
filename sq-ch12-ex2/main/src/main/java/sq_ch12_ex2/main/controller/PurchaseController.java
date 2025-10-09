package sq_ch12_ex2.main.controller;

import org.springframework.web.bind.annotation.*;
import sq_ch12_ex2.main.model.Purchase;
import sq_ch12_ex2.main.repository.PurchaseRepository;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    // HTTP POST endpoint to save a new purchase in the database.
    // The client sends a JSON body → Spring converts it into a Purchase object.
    // Then I just call purchaseRepository.storePurchase() to persist it.
    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }


    // HTTP GET endpoint to fetch all purchases from the database.
    // Here I just call purchaseRepository.findAllPurchases()
    // and return the result as the response body.
    // Spring automatically converts the List<Purchase> into JSON for the client.
    @GetMapping
    public List<Purchase> findPurchase() {
        return purchaseRepository.findAllPurchases();
    }
}
