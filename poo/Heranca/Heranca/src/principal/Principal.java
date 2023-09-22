package principal;

import classes.*;

public class Principal {
	public static void main(String[] args) {
		Funcionario f = new Funcionario("Funcionário", "123456", 2000, 0);
		Gerente g = new Gerente("Gerente", "852369", 5000, 1000);
		Diretor d = new Diretor("Diretor", "741224", 5000, 1500);
		//SubGerente s = new SubGerente();
		
		Funcionario funcionario = new Gerente("Gerente2", "855852369", 10000, 1000);
		Funcionario funcionario2 = new Diretor("Diretor2", "7411741224", 10000, 1500);
		
		imprimirDados(f);
		imprimirDados(g);
		imprimirDados(d);
		//imprimirDados(s);
		imprimirDados(funcionario);
		imprimirDados(funcionario2);

		
		/*
		f.setSalario(2000);
		System.out.println("Salário: " + f.getSalario());
		System.out.println("Bonificação: " + f.getBonificacao());
		System.out.println("Valor a pagar: " + f.calcularValorFinal());
		
		g.setSalario(5000);
		g.setBonus(1000);
		System.out.println("\nSalário: " + g.getSalario());		
		System.out.println("Bonificação: " + g.getBonificacao());
		System.out.println("Bônus gerente: " + g.getBonusEspecial());
		System.out.println("Valor a pagar: " + g.calcularValorFinal());
		
		d.setSalario(5000);
		d.setBonus(1500);
		System.out.println("\nSalário: " + d.getSalario());
		System.out.println("Bonificação: " + d.getBonificacao());
		System.out.println("Bônus diretor: " + d.getBonusEspecial());
		System.out.println("Valor a pagar: " + d.calcularValorFinal());
		
		funcionario.setSalario(10000);
		funcionario.setBonus(1000);
		System.out.println("\nSalário: " + funcionario.getSalario());
		System.out.println("Bonificação: " + funcionario.getBonificacao());
		System.out.println("Bônus Gerente: " + funcionario.getBonusEspecial());
		System.out.println("Valor a pagar: " + funcionario.calcularValorFinal());
		
		funcionario2.setSalario(10000);
		funcionario2.setBonus(1500);
		System.out.println("\nSalário: " + funcionario2.getSalario());
		System.out.println("Bonificação: " + funcionario2.getBonificacao());
		System.out.println("Bônus Gerente: " + funcionario2.getBonusEspecial());
		System.out.println("Valor a pagar: " + funcionario2.calcularValorFinal());
		*/
	}
	
	public static void imprimirDados(Funcionario f) {
		System.out.println("\nSalário: " + f.getSalario());
		System.out.println("Bonificação: " + f.getBonificacao());
		System.out.println("Bônus diretor: " + f.getBonusEspecial());
		System.out.println("Valor a pagar: " + f.calcularValorFinal());
	}
	
}
