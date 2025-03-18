package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(productRepository.count() == 0 && partRepository.count() == 0){

            Product wristGuard = new Product(1, "Wrist Guard", 35.00, 10);
            Product deck = new Product(2, "Real Skateboard", 65.00, 15);
            Product helmet = new Product(3, "Helmet", 70.00, 20);
            Product wax = new Product(4, "Buttery Wax", 5.00, 30 );
            Product wheel = new Product(5, "Spitfire Wheels", 30, 40);

            OutsourcedPart elbowPads = new OutsourcedPart();
            elbowPads.setId(1);
            elbowPads.setName("Elbow Pads");
            elbowPads.setPrice(30.0);
            elbowPads.setInv(5);
            elbowPads.setCompanyName("S1 Helmets");
            elbowPads.setMinInv(1);
            elbowPads.setMaxInv(40);

            OutsourcedPart screws = new OutsourcedPart();
            screws.setId(2);
            screws.setName("Allen Screws");
            screws.setPrice(5.0);
            screws.setInv(10);
            screws.setCompanyName("Diamond Supply Co.");
            screws.setMinInv(1);
            screws.setMaxInv(50);

            InhousePart zeroSkateboards = new InhousePart();
            zeroSkateboards.setName("Zero Skateboards");
            zeroSkateboards.setPrice(60.0);
            zeroSkateboards.setInv(10);
            zeroSkateboards.setPartId(1);
            zeroSkateboards.setMinInv(1);
            zeroSkateboards.setMaxInv(60);

            InhousePart shoes = new InhousePart();
            shoes.setName("Adidas Shoes");
            shoes.setPrice(60.0);
            shoes.setInv(5);
            shoes.setPartId(2);
            shoes.setMinInv(1);
            shoes.setMaxInv(70);

            InhousePart bushings = new InhousePart();
            bushings.setName("bushings");
            bushings.setPrice(10.0);
            bushings.setInv(50);
            bushings.setPartId(3);
            bushings.setMinInv(1);
            bushings.setMaxInv(80);


            // Outsource parts
            partRepository.save(elbowPads);
            partRepository.save(screws);


            // In house parts
            partRepository.save(zeroSkateboards);
            partRepository.save(shoes);
            partRepository.save(bushings);

            productRepository.save(wristGuard);
            productRepository.save(deck);
            productRepository.save(helmet);
            productRepository.save(wax);
            productRepository.save(wheel);
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */



        System.out.println(partRepository.findAll()+ "All products");


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
