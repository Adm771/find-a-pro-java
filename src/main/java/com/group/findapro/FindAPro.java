package com.group.findapro;


import com.group.findapro.category.ServiceCategory;
import com.group.findapro.category.ServiceCategoryRepository;
import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import com.group.findapro.communication.review.Review;
import com.group.findapro.communication.review.ReviewRepository;
import com.group.findapro.user.pro_user.model.Handyman;
import com.group.findapro.user.pro_user.repository.HandymanRepository;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class FindAPro {

    public static void main(String[] args) {
        SpringApplication.run(FindAPro.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(OfferRepository offerRepository, RequestRepository requestRepository, UserRepository userRepository, HandymanRepository handymanRepository, ReviewRepository reviewRepository, ServiceCategoryRepository serviceCategoryRepository) {
        return args -> {
            requestRepository.save(new Request("Need wall painting", 33.00, "wall painting", LocalDateTime.now(), false, 34, "SE1", LocalDate.parse("2022-03-11"), LocalTime.parse("18:00"), 9L, null, false));
            requestRepository.save(new Request("Drilling urgent!", 33.00, "drilling", LocalDateTime.now(), false, 33, "SW12", LocalDate.parse("2022-03-10"), LocalTime.parse("12:00"), 9L, null, false));
            requestRepository.save(new Request("Plummer needed", 33.00, "plumming", LocalDateTime.now(), false, 32, "SE1", LocalDate.parse("2022-03-25"), LocalTime.parse("10:00"), 9L, null, false));

            requestRepository.save(new Request("Need plumming", 33.00, "plumming", LocalDateTime.now(), false, 32, "SE11", LocalDate.parse("2022-03-22"), LocalTime.parse("11:00"), 10L, null, false));
            requestRepository.save(new Request("Drilling needed!", 33.00, "drilling", LocalDateTime.now(), false, 33, "SW22", LocalDate.parse("2022-03-12"), LocalTime.parse("12:00"), 10L, null, false));

            offerRepository.save(new Offer("wall painting and wall drilling", 33.00, "wall painting and wall drilling", LocalDateTime.now(), false, new ArrayList<>(Arrays.asList(34, 33, 32)), 6L, "SE1"));
            offerRepository.save(new Offer("best in painting", 23.00, "wall painting", LocalDateTime.now(), false, new ArrayList<>(Arrays.asList(34, 13, 32)), 7L, "SE1"));
            offerRepository.save(new Offer("drilling everything", 30.00, "drilling", LocalDateTime.now(), false, new ArrayList<>(Arrays.asList(33, 13, 32)), 8L, "SW12"));

            handymanRepository.save(new Handyman("Harry", "Carrick", 06771223452L,"mynameisharry@gmail.co.uk", "mynameisharry", "wall painting and wall drilling"));
            handymanRepository.save(new Handyman("Josh", "Stone", 234234223L, "joshhhhh@gmail.co.uk", "123123", "SE1 and neighborhood almost everything"));
            handymanRepository.save(new Handyman("Mike", "Terry", 234123421L, "mikemikemike@gmail.co.uk", "0000000", "drilling everything"));

            userRepository.save(new User("James", "Jones", 716127271L, "james.jones123@gmail.co.uk", "password123", "Hello handymen!"));

            reviewRepository.save(new Review("Handyman rates customer", "nice guy", LocalDate.parse("2022-03-03"), 5, 9L, 6L));
            reviewRepository.save(new Review("Handyman rates customer", "decent payment", LocalDate.parse("2022-03-01"),4, 9L, 7L));

            userRepository.save(new User("Brian", "Wallace", 222227271L, "brianwallace@gmail.com", "222227271", "Interested?"));

            reviewRepository.save(new Review("Handyman rates customer", "everything fine", LocalDate.parse("2022-03-05"), 5, 10L, 7L));

            serviceCategoryRepository.save(new ServiceCategory(34, "painting"));
            serviceCategoryRepository.save(new ServiceCategory(33, "drilling"));
            serviceCategoryRepository.save(new ServiceCategory(32, "plumbing"));
        };
    }
}



