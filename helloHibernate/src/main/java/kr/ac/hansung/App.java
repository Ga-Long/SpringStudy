package kr.ac.hansung;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Configuration conf = new Configuration();
//        conf.configure();
//        SessionFactory sessionFactory = conf.buildSessionFactory();

        Category category1 = new Category();
        category1.setName("컴퓨터");
        Category category2 = new Category();
        category1.setName("자동차");


        Product product1 = new Product();
        product1.setName("노트북1");
        product1.setPrice(2000);
        product1.setDescription("Awesome NoteBook");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("노트북2");
        product2.setPrice(3000);
        product2.setDescription("Powerful NoteBook");
        product2.setCategory(category1);

        Product product3 = new Product();
        product3.setName("소나타");
        product3.setPrice(30000);
        product3.setDescription("good ");
        product3.setCategory(category2);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("helloHibernate : " + "saving products");
        session.save(product1); //cache에 저장되어있다가
        session.save(product2);
        session.save(product3);
        System.out.println("helloHibernate : " + "saved products");


        //Product savedProduct = session.get(Product.class, product1.getId());
        //System.out.println("saved product: " + savedProduct);

        Query<Product> aQuery = session.createQuery("from Product order by name", Product.class); //HQL
        List<Product> products = aQuery.getResultList(); //조회해서 리스트 가져옴
        System.out.println(products);

        tx.commit(); // 비로소 이때 db에 insert
        session.close();
        sessionFactory.close();


    }
}
