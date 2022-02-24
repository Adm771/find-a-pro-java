package com.group.findapro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class FindAPro {

    public static void main(String[] args) {
        SpringApplication.run(FindAPro.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(OfferRepository offerRepository, RequestRepository requestRepository, CustomerRepository customerRepository, HandymanRepository handymanRepository) {
//        return args -> {
//            offerRepository.save(new Offer(34, LocalDate.parse("2022-03-11"), LocalTime.parse("18:00"), 33.00f, "SE1", true, "wall painting", 6));
//            offerRepository.save(new Offer(34, LocalDate.parse("2022-03-11"), LocalTime.parse("18:00"), 23.00f, "SE1", true, "wall painting", 7));
//            requestRepository.save(new Request(34, LocalDate.parse("2022-03-11"), LocalTime.parse("18:00"), 33.00f, "SE1", true, "wall painting", 5));
//            requestRepository.save(new Request(33, LocalDate.parse("2022-03-10"), LocalTime.parse("12:00"), 30.00f, "SW12", true, "drilling", 5));
//            customerRepository.save(new Customer("James", "Jones", "jameslogin", "password123", "james.jones123@gmail.co.uk", 716127271));
//            handymanRepository.save(new Handyman("Harry", "Carrick", "carrickharry", "mynameisharry", "mynameisharry@gmail.co.uk", 06771223452));
//            handymanRepository.save(new Handyman("Josh", "Stone", "joshhhhh", "1412342134", "joshhhhh@gmail.co.uk", 234234223));
//            handymanRepository.save(new Handyman("Mike", "Terry", "mmmike", "0000000", "mikemikemike@gmail.co.uk", 234123421));
//            offerRepository.save(new Offer(33, LocalDate.parse("2022-03-10"), LocalTime.parse("12:00"), 30.00f, "SW12", true, "drilling", 8));
//        };
    }


