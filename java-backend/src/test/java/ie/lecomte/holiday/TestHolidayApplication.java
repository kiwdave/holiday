package ie.lecomte.holiday;

import org.springframework.boot.SpringApplication;

public class TestHolidayApplication {

	public static void main(String[] args) {
		SpringApplication.from(HolidayApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
