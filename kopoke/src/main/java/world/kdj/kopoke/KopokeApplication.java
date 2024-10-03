package world.kdj.kopoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "world.kdj.kopoke")
public class KopokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KopokeApplication.class, args);
	}

}
