package models;

import models.interfaces.Visualizavel;

public class VideoDigital extends ItemBibliotecaDigital implements Visualizavel {

    public VideoDigital(String title, String author) {
        super(title, author);
    }

    public VideoDigital(String title, String author, String description) {
        super(title, author);
        this.description = description;
    }

    private String description;

    @Override
    public void view() {
        System.out.printf("\nViewing: %s", this.getTitle());
    }

    @Override
    public String description() {
        if (this.description == null) {
            return "\nDescription has not been implemented.";
        }
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
