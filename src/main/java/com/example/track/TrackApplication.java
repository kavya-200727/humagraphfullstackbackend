package com.example.track;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackApplication.class, args);
	}

	@Bean
	public CommandLineRunner databaseInitializer(JdbcTemplate jdbcTemplate) {
		return args -> {
			try {
				System.out.println("Executing automated database schema migration to support expanded user roles...");
				jdbcTemplate.execute("ALTER TABLE users_table MODIFY COLUMN role VARCHAR(255)");
				System.out.println("Database schema migration completed successfully! Column 'role' altered to VARCHAR(255).");
			} catch (Exception e) {
				System.err.println("Role column migration skipped or failed: " + e.getMessage());
			}

			try {
				System.out.println("Dropping legacy foreign key constraint referencing user_account table...");
				jdbcTemplate.execute("ALTER TABLE biometric_profile DROP FOREIGN KEY FKfsmv163u4pioem55m14h7a43t");
				System.out.println("Dropped old constraint FKfsmv163u4pioem55m14h7a43t successfully.");
			} catch (Exception e) {
				System.out.println("Old constraint FKfsmv163u4pioem55m14h7a43t was not found or already dropped: " + e.getMessage());
			}

			try {
				System.out.println("Adding new foreign key constraint referencing users_table...");
				jdbcTemplate.execute("ALTER TABLE biometric_profile ADD CONSTRAINT FK_biometric_profile_users FOREIGN KEY (user_id) REFERENCES users_table(id)");
				System.out.println("Added FK_biometric_profile_users constraint successfully.");
			} catch (Exception e) {
				System.out.println("New constraint was already added or failed: " + e.getMessage());
			}
		};
	}

}
