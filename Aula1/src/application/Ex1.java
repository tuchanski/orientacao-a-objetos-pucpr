package application;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Insira o tamanho da lista: ");
        int size = input.nextInt();
        input.close();

        int[] arr = getRandomList(size);

        System.out.print("\n----- RESULTADO -----");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                System.out.printf("\n%d - número múltiplo de três", arr[i]);
            }

            if (arr[i] % 2 == 0) {
                System.out.printf("\n%d - número par", arr[i]);
            } else {
                System.out.printf("\n%d - número ímpar", arr[i]);
            }
        }

    }

    public static int[] getRandomList(int size) {

        if (size > 0) {

            int[] arr = new int[size];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) ((Math.random()) * 100);
            }

            return arr;

        } else {
            throw new IllegalArgumentException("Tamanho inválido.");
        }

    }

}
