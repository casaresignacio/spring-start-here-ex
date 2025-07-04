package sq_ch8_ex5.main.service;

import org.springframework.stereotype.Service;
import sq_ch8_ex5.main.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public void addProduct (Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
}
