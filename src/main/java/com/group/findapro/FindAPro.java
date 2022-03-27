package com.group.findapro;

import com.group.findapro.category.model.ServiceCategory;
import com.group.findapro.category.service.ServiceCategoryService;
import com.group.findapro.communication.offer.model.Offer;
import com.group.findapro.communication.offer.repository.OfferRepository;
import com.group.findapro.communication.request.model.Request;
import com.group.findapro.communication.request.repository.RequestRepository;
import com.group.findapro.communication.review.model.Review;
import com.group.findapro.communication.review.repository.ReviewRepository;
import com.group.findapro.user.standard_user.model.User;
import com.group.findapro.user.standard_user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class FindAPro {

    public static void main(String[] args) {
        SpringApplication.run(FindAPro.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ServiceCategoryService serviceCategoryService, OfferRepository offerRepository, RequestRepository requestRepository, UserRepository userRepository, ReviewRepository reviewRepository) {
        return args -> {
            requestRepository.save(new Request("Need wall painting", 33.00, "wall painting", LocalDateTime.now(), 34, "SE1", LocalDate.parse("2022-03-11"), LocalTime.parse("18:00")));
            requestRepository.save(new Request("Drilling urgent!", 33.00, "drilling", LocalDateTime.now(), 33, "SW12", LocalDate.parse("2022-03-10"), LocalTime.parse("12:00")));
            requestRepository.save(new Request("Plummer needed", 33.00, "plumming", LocalDateTime.now(), 32, "SE1", LocalDate.parse("2022-03-25"), LocalTime.parse("10:00")));

            requestRepository.save(new Request("Need plumming", 33.00, "plumming", LocalDateTime.now(), 32, "SE11", LocalDate.parse("2022-03-22"), LocalTime.parse("11:00")));
            requestRepository.save(new Request("Drilling needed!", 33.00, "drilling", LocalDateTime.now(), 33, "SW22", LocalDate.parse("2022-03-12"), LocalTime.parse("12:00")));

            offerRepository.save(new Offer("best in painting", 23.00, "wall painting", LocalDateTime.now(), 34, "SE1"));
            offerRepository.save(new Offer("drilling everything", 30.00, "drilling", LocalDateTime.now(), 33, "SW12"));

            userRepository.save(new User("Josh", "Stone", 234234223L, "joshhhhh@gmail.co.uk", "123123", "SE1 and neighborhood almost everything"));
            userRepository.save(new User("Mike", "Terry", 234123421L, "mikemikemike@gmail.co.uk", "0000000", "drilling everything"));

            userRepository.save(new User("James", "Jones", 716127271L, "james.jones123@gmail.co.uk", "password123", "Hello handymen!"));

//            reviewRepository.save(new Review("Handyman rates customer", "nice guy", LocalDate.parse("2022-03-03"), 5, 9L, 6L));
//            reviewRepository.save(new Review("Handyman rates customer", "decent payment", LocalDate.parse("2022-03-01"),4, 9L, 7L));

            userRepository.save(new User("Brian", "Wallace", 222227271L, "brianwallace@gmail.com", "222227271", "Interested?"));

//            reviewRepository.save(new Review("Handyman rates customer", "everything fine", LocalDate.parse("2022-03-05"), 5, 10L, 7L));
            reviewRepository.save(Review.builder().description("everything fine").publishedOn(LocalDateTime.now()).rating(5).build());

            serviceCategoryService.addService(new ServiceCategory(34, "painting"));
            serviceCategoryService.addService(new ServiceCategory(33, "drilling"));
            serviceCategoryService.addService(new ServiceCategory(32, "plumbing"));

            Offer offer1 = Offer.builder().title("wall painting and wall drilling").payment(33.00).description("wall painting and wall drilling").publishedOn(LocalDateTime.now()).serviceCategoryId(34).postCode("SE1").build();
            User user1 = User.builder().firstName("Harry").lastName("Carrick").phoneNumber(06771223452L).email("mynameisharry@gmail.co.uk").password("mynameisharry").description("wall painting and wall drilling").offer(offer1).build();
            userRepository.save(user1);
        };
    }
}



