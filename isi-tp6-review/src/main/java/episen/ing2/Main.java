package episen.ing2;

import episen.ing2.persistence.Review;
import episen.ing2.persistence.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Main implements CommandLineRunner {


    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    protected ReviewRepository reviewRepository;



    @Override
    public void run(String...args) throws Exception{
        logger.info("isi-tp6-review started");
        // Ajout de reviews en BD
        Review r1 = new Review();
        r1.setTrainingId(10L);
        r1.setEmail("eyo@gmail.com");
        r1.setAuthor("Gaby");
        r1.setMessage("Cours de merde");
        reviewRepository.save(r1);
        Review r2 = new Review();
        r2.setTrainingId(34L);
        r2.setEmail("mich@gmail.com");
        r2.setAuthor("Michel");
        r2.setMessage("ça sort comme ça sort");
        reviewRepository.save(r2);
        Review r3 = new Review();
        r3.setTrainingId(8L);
        r3.setEmail("hd@gmail.com");
        r3.setAuthor("Hamza");
        r3.setMessage("merde");
        reviewRepository.save(r3);
        logger.info("isi-tp6-review 3 reviews saved");
    }
}
