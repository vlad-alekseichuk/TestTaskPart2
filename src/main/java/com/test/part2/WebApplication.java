package com.test.part2;

import com.test.part2.persistence.model.Row;
import com.test.part2.persistence.model.Seat;
import com.test.part2.persistence.model.User;
import com.test.part2.persistence.model.UserType;
import com.test.part2.persistence.repository.RowRepository;
import com.test.part2.persistence.repository.SeatRepository;
import com.test.part2.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, RowRepository rowRepository, SeatRepository seatRepository) {
        return (args) -> {
            if (userRepository.findByUsername("admin") == null) {
                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword("$2a$10$vTFRjgqxZ4jlOxpG3S3C3uKw5zQ5rVGrnaJ.LZQ/hHuGOQTSLt2We"); // admin
                adminUser.setUserType(UserType.ADMIN);
                userRepository.save(adminUser);
            }
            if (userRepository.findByUsername("user1") == null) {
                User user1 = new User();
                user1.setUsername("user1");
                user1.setPassword("$2a$10$qp3UZEIUK4nttkj9c1XUv.dgcSQGmR/ssTmTGGRt0Tvesssx7XB16"); // user1
                user1.setUserType(UserType.USER);
                userRepository.save(user1);
            }
            if (userRepository.findByUsername("user2") == null) {
                User user2 = new User();
                user2.setUsername("user2");
                user2.setPassword("$2a$10$kwDP69Wh1WkSdwMSqgsyROR.Dtg9hSSmZzdlal7bM5.L9euZpRjx6"); // user2
                user2.setUserType(UserType.USER);
                userRepository.save(user2);
            }


            for (int i = 1; i <= 10; i++) {
                Set<Seat> seats = new HashSet<>();
                for (int j = 1; j <= 10; j++) {
                    boolean available = Math.random() > 0.5;
                    seats.add(new Seat(j, available));
                }
                Row row = new Row();
                row.setNumber(i);
                row.setSeats(seats);
                rowRepository.save(row);
                for (Seat seat : seats) {
                    seat.setRow(row);
                    seatRepository.save(seat);
                }

            }
        };
    }
}
