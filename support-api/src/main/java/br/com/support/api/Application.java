/**
 * 
 */
package br.com.support.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "br.com.support" })
@EnableJpaRepositories("br.com.support.core.repository")
@EntityScan("br.com.support.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
