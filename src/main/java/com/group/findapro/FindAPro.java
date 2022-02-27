package com.group.findapro;

import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import com.group.findapro.communication.review.model.Review;
import com.group.findapro.user.customer.model.Customer;
import com.group.findapro.user.customer.repository.CustomerRepository;
import com.group.findapro.user.handyman.model.Handyman;
import com.group.findapro.user.handyman.repository.HandymanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.group.findapro.communication.review.repository.ReviewRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class FindAPro {

    public static void main(String[] args) {
        SpringApplication.run(FindAPro.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OfferRepository offerRepository, RequestRepository requestRepository, CustomerRepository customerRepository, HandymanRepository handymanRepository, ReviewRepository reviewRepository) {
        return args -> {
            offerRepository.save(new Offer(33.00f, "SE1", "wall painting", 6, new ArrayList<>(Arrays.asList(34, 33, 32))));
            offerRepository.save(new Offer(23.00f, "SE1", "wall painting", 7, new ArrayList<>(Arrays.asList(34, 13, 22))));
            requestRepository.save(new Request(33.00f, "SE1", true, "wall painting", 34, LocalDate.parse("2022-03-11"), LocalTime.parse("18:00"),  5));
            requestRepository.save(new Request(33.00f, "SE1", false, "plumbing", 32, LocalDate.parse("2022-01-22"), LocalTime.parse("18:00"),  5));
            requestRepository.save(new Request(30.00f, "SW12", true, "drilling", 33, LocalDate.parse("2022-03-10"), LocalTime.parse("12:00"),  5));
            customerRepository.save(new Customer("James", "Jones", "jameslogin", "password123", "james.jones123@gmail.co.uk", 716127271));
            handymanRepository.save(new Handyman("Harry", "Carrick", "carrickharry", "mynameisharry", "mynameisharry@gmail.co.uk", 671223452));
            handymanRepository.save(new Handyman("Josh", "Stone", "joshhhhh", "1412342134", "joshhhhh@gmail.co.uk", 234234223));
            handymanRepository.save(new Handyman("Mike", "Terry", "mmmike", "0000000", "mikemikemike@gmail.co.uk", 234123421));
            offerRepository.save(new Offer(30.00f, "SW12", "drilling", 8, new ArrayList<>(Arrays.asList(33, 32, 13))));
            reviewRepository.save(new Review("nice guy", 5, 6));
            reviewRepository.save(new Review("decent payment", 5, 7));
        };
    }
}

