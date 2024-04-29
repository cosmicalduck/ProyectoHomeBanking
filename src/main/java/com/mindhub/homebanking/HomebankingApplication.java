package com.mindhub.homebanking;

import com.mindhub.homebanking.models.*;
import com.mindhub.homebanking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(
			ClientRepository clientRepository,
			AccountRepository accountRepository,
			TransactionRepository transactionRepository,
			LoanRepository loanRepository,
			ClientLoanRepository clientLoanRepository,
			CardRepository cardRepository
	) {
		return args -> {

			LocalDate fechaHoy = LocalDate.now();

			Client cliente1 = clientRepository.save(new Client("Melba", "Morel", "melba@mindhub.com", passwordEncoder.encode("Hola777")));
			Client cliente2 = clientRepository.save(new Client("Rodrigo", "Ribeiro", "rori@mindhub.com", passwordEncoder.encode("jiji_43")));

//			Account cuenta1 = accountRepository.save(new Account("VIN001", fechaHoy,99999));
//			Account cuenta2 = accountRepository.save(new Account("VIN002",fechaHoy,77777777));
//			Account cuenta3 = accountRepository.save(new Account("VIN003",fechaHoy,77777));
//
//			Client cliente1 = clientRepository.save(new Client("Melba", "Morel", "melba@mindhub.com"));
//			Client cliente2 = clientRepository.save(new Client("Rey", "Pato", "cuack@pato.com"));
//
//			cuenta1.setClient(cliente1);
//			accountRepository.save(cuenta1);
//			cuenta2.setClient(cliente1);
//			accountRepository.save(cuenta2);
//
//			cuenta3.setClient(cliente2);
//			accountRepository.save(cuenta3);
//
//			Transaction t1 = transactionRepository.save(new Transaction(TransactionType.CREDIT, 7000.0, "Compra bubble tea", fechaHoy));
//			Transaction t2 = transactionRepository.save(new Transaction(TransactionType.DEBIT, -700.0, "Compra bazar", fechaHoy));
//			Transaction t3 = transactionRepository.save(new Transaction(TransactionType.DEBIT, -84000.0, "Compra almacén", fechaHoy));
//			Transaction t4 = transactionRepository.save(new Transaction(TransactionType.CREDIT, 777.7, "Compra stickers", fechaHoy));
//
//			Transaction t5 = transactionRepository.save(new Transaction(TransactionType.DEBIT, 88.8, "Compra bubble tea", fechaHoy));
//
//			t1.setAccount(cuenta1);
//			transactionRepository.save(t1);
//			t2.setAccount(cuenta1);
//			transactionRepository.save(t2);
//			t3.setAccount(cuenta2);
//			transactionRepository.save(t3);
//			t4.setAccount(cuenta2);
//			transactionRepository.save(t4);
//
//			t5.setAccount(cuenta3);
//			transactionRepository.save(t5);
//
//			Loan l1 = loanRepository.save(new Loan("Hipotecario", 500000, List.of(12,24,36,48,60)));
//			Loan l2 = loanRepository.save(new Loan("Personal", 100000, List.of(6,12,24)));
//			Loan l3 = loanRepository.save(new Loan("Automotriz", 300000, List.of(6,12,24,36)));
//
//			ClientLoan cl1 = clientLoanRepository.save(new ClientLoan(400000,60));
//			ClientLoan cl2 = clientLoanRepository.save(new ClientLoan(50000,12));
//
//			ClientLoan cl3 = clientLoanRepository.save(new ClientLoan(100000, 24));
//			ClientLoan cl4 = clientLoanRepository.save(new ClientLoan(200000, 36));
//
//			cl1.setClient(cliente1);
//			cl1.setLoan(l1);
//			clientLoanRepository.save(cl1);
//
//			cl2.setClient(cliente1);
//			cl2.setLoan(l2);
//			clientLoanRepository.save(cl2);
//
//			cl3.setClient(cliente2);
//			cl3.setLoan(l2);
//			clientLoanRepository.save(cl3);
//
//			cl4.setClient(cliente2);
//			cl3.setLoan(l3);
//			clientLoanRepository.save(cl4);
//
//			LocalDate fechaVencimiento = LocalDate.now().plusYears(5);
//			Card card1 = cardRepository.save(new Card("Melba Morel", CardType.DEBIT, CardColor.GOLD, "8325-2893-5275-2345", 898, fechaHoy, fechaVencimiento));
//			Card card2 = cardRepository.save(new Card("Melba Morel", CardType.CREDIT, CardColor.TITANIUM, "8309-2893-5275-2467", 832, fechaHoy, fechaVencimiento));
//			Card card3 = cardRepository.save(new Card("Rey Pato", CardType.CREDIT, CardColor.SILVER, "8909-2893-5764-8765", 320, fechaHoy,fechaVencimiento));
//
//			card1.setClient(cliente1);
//			cardRepository.save(card1);
//			card2.setClient(cliente1);
//			cardRepository.save(card2);
//			card3.setClient(cliente2);
//			cardRepository.save(card3);

		};
	}

}
