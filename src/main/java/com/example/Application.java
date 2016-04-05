package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(final CustomerRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // save a couple of customers
              /*  repository.save(new Customer("Jack", "Bauer"));
                repository.save(new Customer("Chloe", "O'Brian"));
                repository.save(new Customer("Kim", "Bauer"));
                repository.save(new Customer("David", "Palmer"));
                repository.save(new Customer("Michelle", "Dessler"));
*/
                // fetch all customers
                log.info("Customers found with findAll():");
                log.info("-------------------------------");
                for (User customer : repository.findAll()) {
                    log.info(customer.toString());
                }
                log.info("");

                // fetch customers by last name
                log.info("Customer found with findByLastName('Bauer'):");
                log.info("--------------------------------------------");
                for (User bauer : repository.findByName("admin")) {
                    log.info(bauer.toString());
                }
                log.info("");
            }
        };
    }

}