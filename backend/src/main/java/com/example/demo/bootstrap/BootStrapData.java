package com.example.demo.bootstrap;

import com.example.demo.dao.CountryRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Country;
import com.example.demo.entities.Division;
import com.example.demo.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapData implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(BootStrapData.class);

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    private final CountryRepository countryRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        //If no customers in db, add sample customers
        if (customerRepository.count() == 1) {
            //At least one division and one country
            Optional<Division> divisionOpt = divisionRepository.findAll().stream().findFirst();
            Optional<Country> countryOpt = countryRepository.findAll().stream().findFirst();

            if (divisionOpt.isPresent() && countryOpt.isPresent()){
                Division division = divisionOpt.get();
                //Country country = countryOpt.get();

                //Sample
                Customer customer1 = new Customer(division, "123 Main Street", "Jon", "Doe", "558089976", "12345");
                Customer customer2 = new Customer(division, "456 Oak Avenue", "Alice", "Smith", "5559873209", "67890");
                Customer customer3 = new Customer(division, "789 Pine Lane", "Billy Bob", "Sponge", "4431112233", "54321");
                Customer customer4 = new Customer(division, "101 Cedar Bark Road", "Eva", "Stevenson", "5556667889", "98753");
                Customer customer5 = new Customer(division, "202 Maple Bacon Court", "Chris", "Tank", "6609321776", "13721");

                customerRepository.save(customer1);
                customerRepository.save(customer2);
                customerRepository.save(customer3);
                customerRepository.save(customer4);
                customerRepository.save(customer5);

                System.out.println("Started in Bootstrap");
                System.out.println("Number of Customers " + customerRepository.count());
                System.out.println(customerRepository.findAll());
            }else{
                log.warn("There must be one division and one country exist in the database.");
            }

        }
    }
}
