package com.example.RestApiMongoDB;

import com.example.RestApiMongoDB.enums.Gender;
import com.example.RestApiMongoDB.models.Address;
import com.example.RestApiMongoDB.models.Student;
import com.example.RestApiMongoDB.repository.StudentsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class RestApiMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiMongoDbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentsRepository repository,
							 MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address(
					"Bangladesh",
					"Dhaka",
					"DHA82"
			);

			String email = "zahidH@rokomari.com";
			Student student = new Student(
					"Zahid",
					"Hasan",
					email,
					Gender.MALE,
					address,
					List.of("CSE", "EEE"),
					10.02,
					LocalDateTime.now()
			);
			//usingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> {
						System.out.println("Data found. So no need to insert data.");
					}, ()->{
						System.out.println("No data found. So insert data");
						repository.insert(student);
					});
		};
	}

	private void usingMongoTemplateAndQuery(StudentsRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() == 0) {
			System.out.println("No data found. So insert data");
			repository.insert(student);
		} else {
			System.out.println("Data found. So no need to insert data.");
		}
	}

}
