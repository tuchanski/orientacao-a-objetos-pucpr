package models;

import models.interfaces.Baixavel;

public class Ebook extends ItemBibliotecaDigital implements Baixavel {

    public Ebook(String title, String author) {
        super(title, author);
    }

    public Ebook(String title, String author, String description) {
        super(title, author);
        this.description = description;
    }

    private String description;

    @Override
    public String description() {
        if (this.description == null) {
            return "\nDescription has not been implemented.";
        }
        return this.description;
    }

    @Override
    public void download() {
        System.out.printf("\n%s has been downloaded successfully.", this.getTitle());
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
