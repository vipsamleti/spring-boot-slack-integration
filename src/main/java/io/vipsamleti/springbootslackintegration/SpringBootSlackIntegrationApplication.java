package io.vipsamleti.springbootslackintegration;

import io.vipsamleti.springbootslackintegration.analyzers.EventsAnalyzer;
import io.vipsamleti.springbootslackintegration.analyzers.SignOutEventAnalyzer;
import io.vipsamleti.springbootslackintegration.reporters.EventsReporter;
import io.vipsamleti.springbootslackintegration.reporters.EventsReporterImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSlackIntegrationApplication {


	public static final long MINUTES = 1000 * 60;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSlackIntegrationApplication.class, args);

	}

	@Bean
	public EventsAnalyzer eventsAnalyzer(){
		return new SignOutEventAnalyzer();
	}
	@Bean
	public EventsReporter eventsReporter(){
		return new EventsReporterImpl();
	}

}
