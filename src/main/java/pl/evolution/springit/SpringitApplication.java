package pl.evolution.springit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import pl.evolution.springit.domain.Comment;
import pl.evolution.springit.domain.Link;
import pl.evolution.springit.repository.CommentRepository;
import pl.evolution.springit.repository.LinkRepository;


@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
        return args -> {
            Link link = new Link("Getting Started with Spring Boot 2", "http://therealdanvvega.com/spring-boot-2");
            linkRepository.save(link);

            Link link2 = new Link("Just do it!", "http://nike.com");
            linkRepository.save(link2);

            Comment comment = new Comment("This Spring boot 2 link is awesome!", link);
            commentRepository.save(comment);
            link.addComment(comment);

            System.out.println("We just insert a link and a comment");

        };
    }
}
