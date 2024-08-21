package application;

import java.util.Scanner;

import models.Bank;
import models.BankAccount;
import models.User;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        Boolean menuLoop = true;

        do {

            int userChoice;

            System.out.println("\n- Banco Central da Lapa PR -");
            System.out.println("[1] - Registrar Usuário");
            System.out.println("[2] - Sacar");
            System.out.println("[3] - Depositar");
            System.out.println("[4] - Verificar saldo");
            System.out.println("[5] - Alterar informações");
            System.out.println("[0] - Sair do programa");
            System.out.print("\nDigite aqui: ");
            userChoice = input.nextInt();

            switch (userChoice) {
                case 0:
                    menuLoop = false;
                    break;

                case 1:
                    System.out.println("\n - Criando Usuário -");

                    System.out.print("\nInsira um username: ");
                    String newUsername = input.next();

                    BankAccount newBankAccount = new BankAccount(new User(newUsername));
                    bank.add(newBankAccount);

                    System.out.println("- Usuário criado com sucesso.");
                    break;

                case 2:
                    System.out.println("\n - Sacando -");
                    System.out.print("\nInsira um nome de usuário: ");

                    String userToWithdraw = input.next();
                    boolean userValidation = false;
                    for (BankAccount bankAccount : bank.getBankAccounts()) {

                    }

            }

        } while (menuLoop);

        System.out.println("\nPrograma encerrado.");

        input.close();

    }

}