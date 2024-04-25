package brycen.brycen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// DB config 무시
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BrycenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrycenApplication.class, args);
	}

}
