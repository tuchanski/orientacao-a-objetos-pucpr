package application;

import models.Ebook;
import models.VideoDigital;

public class Program {

    public static void main(String[] args) {

        Ebook eb1 = new Ebook("O pequeno príncipe", "Antoine de Saint-Exupéry");
        Ebook eb2 = new Ebook("Jojo's Bizarre Adventure Vol. 1", "Hirohiko Araki",
                "A história da família Joestar, uma família cujos vários membros descobrem que estão destinados a derrubar inimigos sobrenaturais.");

        VideoDigital video1 = new VideoDigital("Inscrição | Apple Developer Academy", "Guilherme Tuchanski",
                "Algo que me orgulho de ter feito.");
        VideoDigital video2 = new VideoDigital("Coletânia Músicas Final Fantasy", "Hironobu Sakaguchi");

        System.out.println("Testando descrições: ");

        System.out.println(eb1.description() + "\n" +
                eb2.description() + "\n" +
                video1.description() +
                video2.description());

        System.out.println("\nBaixando ebooks: ");
        eb1.download();
        eb2.download();

        System.out.println("\n\nVisualizando vídeos: ");
        video1.view();
        video2.view();

    }

}