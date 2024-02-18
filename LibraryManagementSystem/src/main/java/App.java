
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //Author Adding
        Author author = new Author();
        author.setName("Victor Hugo");
        author.setBirthDate(LocalDate.of(1802, 2, 26));
        author.setCountry("Fransız");
        entityManager.persist(author);

        //Publisher Adding
        Publisher publisher = new Publisher();
        publisher.setName("Can Yayınevi");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(1862);
        entityManager.persist(publisher);

        //Category Adding
        Category categoryHistory = new Category();
        categoryHistory.setName("history");
        categoryHistory.setDescription("test");
        entityManager.persist(categoryHistory);

        ArrayList<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(categoryHistory);

        Book book = new Book();
        book.setName("Sefiller");
        book.setStock(25);
        book.setPublicationYear(1862);
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Büşra Şahin");
        bookBorrowing.setBorrowingDate(LocalDate.of(2024,02,10));
        bookBorrowing.setReturnDate(LocalDate.of(2024,03,10));
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);

        transaction.commit();

    }
}
