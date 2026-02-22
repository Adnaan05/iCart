package com.addy.ICart.seeds;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.addy.ICart.Entities.ProductEntity;
import com.addy.ICart.Repositories.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRep;

    @Override
    public void run(String... args) throws Exception {
        
        if(productRep.count() == 0) {
            
            List<ProductEntity> demoProducts = Arrays.asList(
                // Format: id, name, category, price, description, ratings, seller, stock, numOfReviews
                new ProductEntity(null, "iPhone 14 Pro", "Smartphones", 999.99, 
                    "Latest Apple iPhone with A16 chip and 48MP camera", 0.0, 
                    "Apple Store", 50, 0, List.of("/product/1.png") ),
                
                new ProductEntity(null, "Samsung Galaxy S23", "Smartphones", 899.99, 
                    "Flagship Android phone with amazing camera system", 0.0, 
                    "Samsung Official", 45, 0, List.of("/product/2.png") ),
                
                new ProductEntity(null, "Sony WH-1000XM4", "Audio", 349.99, 
                    "Industry-leading noise cancelling headphones", 0.0, 
                    "Sony Electronics", 100, 0, List.of("/product/3.png") ),
                
                new ProductEntity(null, "MacBook Pro 14", "Computers", 1999.99, 
                    "Powerful laptop with M2 Pro chip for professionals", 0.0, 
                    "Apple Store", 30, 0, List.of("/product/4.png") ),
                
                new ProductEntity(null, "Nike Air Max 270", "Footwear", 149.99, 
                    "Comfortable lifestyle shoes with air cushioning", 0.0, 
                    "Nike Official", 200, 0, List.of("/product/5.png") ),
                
                new ProductEntity(null, "Kindle Paperwhite", "Electronics", 139.99, 
                    "Waterproof e-reader with 6.8\" display and warm light", 0.0, 
                    "Amazon", 150, 0, List.of("/product/6.png") ),
                
                new ProductEntity(null, "PlayStation 5", "Gaming", 499.99, 
                    "Next-gen gaming console with lightning fast loading", 0.0, 
                    "Sony Gaming", 25, 0, List.of("/product/7.png") ),
                
                new ProductEntity(null, "Instant Pot Duo", "Home Appliances", 89.99, 
                    "7-in-1 multi-functional pressure cooker", 0.0, 
                    "Instant Brands", 300, 0, List.of("/product/8.png") ),
                
                new ProductEntity(null, "Dyson V15 Vacuum", "Home Appliances", 699.99, 
                    "Powerful cordless vacuum with laser detection", 0.0, 
                    "Dyson", 40, 0, List.of("/product/9.png") ),
                
                new ProductEntity(null, "LG 55\" OLED TV", "Televisions", 1299.99, 
                    "4K Smart TV with perfect blacks and vibrant colors", 0.0, 
                    "LG Electronics", 35, 0, List.of("/product/10.png") )
            );
            
            productRep.saveAll(demoProducts);
            System.out.println("10 demo products seeded successfully!");
        } else {
            System.out.println("Products already exist in database. Skipping seeder.");
        }
    }
}