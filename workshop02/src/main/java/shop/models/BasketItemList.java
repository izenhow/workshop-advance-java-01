package shop.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasketItemList {
    private List<BasketItem> items = new ArrayList<>();

    public List<BasketItem> getItems() {
        return items;
    }

    public void setItems(List<BasketItem> items) {
        this.items = items;
    }

    public int getSize() {
        return items.size();
    }

    public List<Book> getBookList() {
        return items.stream().map(BasketItem::getBook).collect(Collectors.toList());
    }

    public BasketItem findItem(Book book) {
        return items.stream().filter(b -> b.isBook(book)).findFirst().orElse(null);
    }

    public Book findBook(Book book) {
        return Optional.of(findItem(book)).map(BasketItem::getBook).orElse(null);
    }

    public int getSumPrice() {
        return items.stream().reduce(0, (sum, item) -> sum + item.getSumPrice(), Integer::sum);
    }

    public void addBook(Book book) {
        BasketItem item = findItem(book);
        if (item == null) {
            items.add(new BasketItem(book));
            return;
        }
        item.increaseQty();
    }
}
