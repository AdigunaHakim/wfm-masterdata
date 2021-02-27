package id.co.asyst.wfm.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@EnableScheduling
@ComponentScan("id.co.asyst.wfm.master")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
