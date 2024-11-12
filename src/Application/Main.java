package Application;

import Entities.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Entre com os dados da conta: ");
            System.out.print("Digite o número da conta: ");
            int numeroConta = sc.nextInt();
            System.out.print("Digite o nome do Titular: ");
            String titular = sc.next();
            System.out.print("Digite o depósito inicial: ");
            double saldoInicial = sc.nextDouble();
            System.out.print("Digite o limite de saque: ");
            double limiteSaque = sc.nextDouble();

            Account account = new Account(numeroConta, titular, saldoInicial, limiteSaque);

            System.out.println(account);

            System.out.println("Digite o valor para Saque: ");
            double valorSaque = sc.nextDouble();
            account.sacar(valorSaque);

            System.out.println("Gostaria de depositar algum valor ? ");
            double valorDepositar = sc.nextDouble();
            account.depositar(valorDepositar);

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida, digite um número.");

        } catch (Account.SaldoInsuficienteException | Account.LimiteSaqueExcedidoException e) {
            System.out.println(e.getMessage());
        }
    }
}