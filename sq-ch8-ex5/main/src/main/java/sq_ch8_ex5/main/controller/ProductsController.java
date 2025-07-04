package sq_ch8_ex5.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sq_ch8_ex5.main.model.Product;
import sq_ch8_ex5.main.service.ProductService;

@Controller
public class ProductsController {

    private final ProductService productService;

    //using DI through the controller's constructor parameters to get the service bean from the Spring contest
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //mapping the controller action to the /products path.
    //RequestMapping annotation, by default, uses HTTP GET method.

    //GetMapping maps the HTTP GET request with a specific
    // path to the controller's action
    @GetMapping("/products")
    public String viewProducts(
            //definning a Model parameter that use to send the data to the view
            Model model) {
        //getting the product list
        var products = productService.findAll();
        //sending products to the view
        model.addAttribute("products", products);
        //returning the view name, which will be taken and rendered by the dispatcher servlet.
        return "products.html";
    }


    //mapping the controller action to the /products path
    //change the HTTP method to POST

    //PostMapping maps the HTTP POST
    //request with a specific path to the controller's action
    @PostMapping("/products")
    // get the name and the price for the product to add using request parameters.
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        //build a new Product instance and add it
        //to the list by calling the service use case method
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);


        //get the list of products and send it to the view
        var products = productService.findAll();
        model.addAttribute("products", products);

        //return the name of the view rendered
        return "products.html";
    }
}
