package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPlayer;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPlayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (resp == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble(); 
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPlayer taxplayer : list) {
			System.out.println(taxplayer.getName() + ": $ " + String.format("%.2f",taxplayer.tax()));
			sum += taxplayer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		
		sc.close();
	}

}
