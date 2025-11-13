package br.com.marcos.biblia2.mains;

import br.com.marcos.biblia2.models.*;
import br.com.marcos.biblia2.services.HTTP;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class Biblia2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Biblia2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
