package episen.ing2;


import episen.ing2.persistence.Training;
import episen.ing2.persistence.TrainingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Main implements CommandLineRunner{


    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    protected TrainingRepository trainingRepository;

    @Override
    public void run(String...args) throws Exception{
        logger.info("isi-tp6-training started");
        // Ajout de training en BD
        Training t1 = new Training();
        t1.setTitle("Java");
        t1.setDescription("Cours de Java");
        trainingRepository.save(t1);
        Training t2 = new Training();
        t2.setTitle("Python");
        t2.setDescription("Cours de Python");
        trainingRepository.save(t2);
        Training t3 = new Training();
        t3.setTitle("C++");
        t3.setDescription("Cours de C++");
        trainingRepository.save(t3);
        logger.info("isi-tp6-training 3 training saved");
    }

}