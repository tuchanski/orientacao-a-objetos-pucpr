package models;

public abstract class ItemBibliotecaDigital {

    private String title;
    private String author;

    public ItemBibliotecaDigital(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract String description();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ItemBibliotecaDigital [title=" + title + ", author=" + author + "]";
    }

    
}
