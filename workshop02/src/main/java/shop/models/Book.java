package shop.models;

public class Book {
    private String name;
    private int price;

    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Copied/pasted from internet. Normally would be using Lombok instead.
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        final Book other = (Book) obj;
        if (name == null && other.getName() != null) {
            return false;
        }

        return name.equals(other.getName()) && price == other.getPrice();
    }

    // Also copied/pasted from internet.
    @Override
    public int hashCode() {
        int hash = 13;
        hash = 53 * hash + (name != null ? name.hashCode() : 0);
        hash = 53 * hash + price;
        return hash;
    }
}
