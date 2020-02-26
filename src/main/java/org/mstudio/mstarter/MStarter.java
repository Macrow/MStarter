package org.mstudio.mstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Macrow
 * @date 2020/2/25
 */
@SpringBootApplication
@EnableJpaAuditing
public class MStarter {

	public static void main(String[] args) {
		SpringApplication.run(MStarter.class, args);
	}

}
