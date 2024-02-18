import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
/*
        Supplier supplier = new Supplier();
        supplier.setAddress("Adres");
        supplier.setCompany("Patika");
        supplier.setContact("553545");
        supplier.setMail("info@patika.dev");
        supplier.setPerson("Mustafa");
        entityManager.persist(supplier);

        Category category = new Category();
        category.setName("Telefonlar");
        entityManager.persist(category);




        //Code Ekleme
        Code code = new Code();
        code.setGroup("11123");
        code.setSerial("444556");
        entityManager.persist(code);
        //Ürün Ekleme
        Product product = new Product();
        product.setName("Iphone 15pro");
        product.setPrice(1223);
        product.setStock(100);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);

        entityManager.persist(product);
        System.out.println(product.toString());

        Color blue = new Color("Blue");
        Color red = new Color("Red");
        Color yellow = new Color("Yellow");

        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(yellow);


        List<Color>colorList = new ArrayList<>();
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);
        entityManager.persist(product);*/

        Product product = entityManager.find(Product.class,1);
        System.out.println(product.getColorList().toString());

        transaction.commit();


    }
}
