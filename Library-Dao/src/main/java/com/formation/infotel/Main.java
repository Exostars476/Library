package com.formation.infotel;

import com.formation.infotel.config.SpringConfig;
import com.formation.infotel.entity.*;
import com.formation.infotel.entity.Editor;
import com.formation.infotel.interfaces.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        Dao dao = (Dao) ctx.getBean("daoImpl");

        List<Library> libraries1 = new ArrayList<>();
        List<Library> libraries2 = new ArrayList<>();
        List<Category> categs1 = new ArrayList<>();
        List<Category> categs2 = new ArrayList<>();
        Set<Author> authors1 = new HashSet<>();
        Set<Author> authors2 = new HashSet<>();
        Set<Author> authors3 = new HashSet<>();
        Set<Author> authors4 = new HashSet<>();
        List<Book> books = new ArrayList<>();
        List<Book_copy> bookCopies1 = new ArrayList<>();
        List<Book_copy> bookCopies2 = new ArrayList<>();
        List<Book_copy> bookCopies3 = new ArrayList<>();
        List<Book_copy> bookCopies4 = new ArrayList<>();
        List<Member> members1 = new ArrayList<>();
        List<Member> members2 = new ArrayList<>();
        List<Registration> registrations1 = new ArrayList<>();
        List<Registration> registrations2 = new ArrayList<>();

        Library lib1 = new Library("Books for all", "Angleterre");
        Library lib2 = new Library("Livre pour tous", "France");
        Library lib3 = new Library("Libro para todos", "Espagne");
        Library lib4 = new Library("Subete o yoyaku / すべてを予約", "Japon");
        Library lib5 = new Library("Prenota per tutti", "Italie");
        libraries1.add(lib1);
        libraries1.add(lib2);
        libraries2.add(lib3);
        libraries2.add(lib4);
        libraries2.add(lib5);

        Member m1 = new Member("davezac","davezac.davezac@gmail.com", "password64", "allées c'est parti", "rennes", "63000", 2, "0788224455", "christelle");
        Member m2 = new Member("legu","legu.michel@gmail.com", "password42", "allées viens", "rennes", "75000", 2, "0788224455", "michel");
        Member m3 = new Member("freecs","freecs.gon@gmail.com", "password32", "allées salut", "rennes", "32000", 2, "0788224455", "gon");
        Member m4 = new Member("hirako","hirako.shinji@gmail.com", "password72", "allées oui", "rennes", "25000", 2, "0788224455", "shinji");
        Member m5 = new Member("colleter","julien.colleter@infotel.com", "motdepass", "19 rue michel colomb", "rennes", "35000", 1, "0788224455", "julien");
        members1.add(m1);
        members1.add(m2);
        members1.add(m3);
        members1.add(m4);
        members2.add(m5);

        Date date1 = new Date(1996, 4, 17);
        Date date2 = new Date(2000, 5, 27);
        Date date3 = new Date(2005, 6, 30);
        Date date4 = new Date(2009, 7, 12);
        Date date5 = new Date(2015, 8, 9);

        Registration reg1 = new Registration(m1, lib1, date1);
        Registration reg2 = new Registration(m2, lib2, date2);
        Registration reg3 = new Registration(m3, lib3, date3);
        Registration reg4 = new Registration(m4, lib4, date4);
        Registration reg5 = new Registration(m5, lib5, date5);
        registrations1.add(reg1);
        registrations1.add(reg2);
        registrations1.add(reg3);
        registrations2.add(reg4);
        registrations2.add(reg5);

        lib1.setRegistrations(registrations1);
        lib2.setRegistrations(registrations1);
        lib3.setRegistrations(registrations1);
        lib4.setRegistrations(registrations2);
        lib5.setRegistrations(registrations2);

        Category cat1 = new Category("Action", "Manga d'Action");
        Category cat2 = new Category("Aventure", "Manga d'Aventure");
        Category cat3 = new Category("Romance", "Manga de Romance");
        Category cat4 = new Category("Combat", "Manga de Combat");
        Category cat5 = new Category("Periodic", "Periodiques");
        categs1.add(cat3);
        categs1.add(cat5);
        categs2.add(cat1);
        categs2.add(cat2);
        categs2.add(cat4);

        Author auth1 = new Author("Yoshihiro", "Togashi");
        Author auth2 = new Author("Nakaba", "Suzuki");
        Author auth3 = new Author("Hajime", "Isayama");
        Author auth4 = new Author("Kazuma", "Kondou");
        Author auth5 = new Author("Jinsei", "Kataoka");
        authors1.add(auth1);
        authors2.add(auth2);
        authors3.add(auth3);
        authors4.add(auth4);
        authors4.add(auth5);

        Editor edit1 = new Editor("Kana", "France");
        Editor edit2 = new Editor("Dybex", "France");
        Editor edit3 = new Editor("Netflix", "France");
        Editor edit4 = new Editor("White fox", "France");

        Book book1 = new Book("Nanatsu no taizai", "The seven deadly sins", 7, date1, true, "images/nanatsu.jpg");
        Book book2 = new Book("Hunter X Hunter", "Aventures de Gon et Kirua", 7, date2, true, "images/hunter.jpg");
        Book book3 = new Book("Shingeki no Kyojin", "L'attaque des titans", 7, date3, true, "images/shingeki.jpg");
        Book book4 = new Book("Deadman Wonderland", "Deadman Wonderland", 7, date4, true, "images/deadmanw.jpg");
        Book book5 = new Book("Yu Yu Hakusho", "Yu Yu Hakusho", 7, date1, true, "images/nnt.jpg");
        book1.setAuthors(authors2);
        book2.setAuthors(authors1);
        book3.setAuthors(authors3);
        book4.setAuthors(authors4);
        book4.setAuthors(authors1);
        book1.setEditor(edit1);
        book2.setEditor(edit2);
        book3.setEditor(edit3);
        book4.setEditor(edit2);
      
        book1.setCategory(cat4);
        book2.setCategory(cat2);
        book3.setCategory(cat1);
        book4.setCategory(cat1);
        book5.setCategory(cat2);

        /*cat1.setBooks(books);
        cat2.setBooks(books);
        cat3.setBooks(books);
        cat4.setBooks(books);
        cat5.setBooks(books);*/

        BookShelf bookShelf1 = new BookShelf("Etagère 1", "Nanatsu");
        BookShelf bookShelf2 = new BookShelf("Etagère 2", "Hunter");
        BookShelf bookShelf3 = new BookShelf("Etagère 3", "Titan");
        BookShelf bookShelf4 = new BookShelf("Etagère 4", "Deadman");

        Book_copy copy1 = new Book_copy("Nanatsu no taizai #1", book1, bookShelf1);
        Book_copy copy2 = new Book_copy("Nanatsu no taizai #2", book1, bookShelf1);
        Book_copy copy3 = new Book_copy("Hunter X Hunter", book2, bookShelf2);
        Book_copy copy4 = new Book_copy("Shingeki no Kyojin", book3, bookShelf3);
        Book_copy copy5 = new Book_copy("Deadman Wonderland", book4, bookShelf4);
        bookCopies1.add(copy1);
        bookCopies1.add(copy2);
        bookCopies2.add(copy3);
        bookCopies3.add(copy4);
        bookCopies4.add(copy5);

        bookShelf1.setBook_copies(bookCopies1);
        bookShelf2.setBook_copies(bookCopies2);
        bookShelf3.setBook_copies(bookCopies3);
        bookShelf4.setBook_copies(bookCopies4);

        /// Enregistrement ///

        dao.save(lib1);
        dao.save(lib2);
        dao.save(lib3);
        dao.save(lib4);
        dao.save(lib5);

        dao.save(m1);
        dao.save(m2);
        dao.save(m3);
        dao.save(m4);
        dao.save(m5);

        dao.save(reg1);
        dao.save(reg2);
        dao.save(reg3);
        dao.save(reg4);
        dao.save(reg5);

        dao.save(cat1);
        dao.save(cat2);
        dao.save(cat3);
        dao.save(cat4);
        dao.save(cat5);

        dao.save(auth1);
        dao.save(auth2);
        dao.save(auth3);
        dao.save(auth4);
        dao.save(auth5);

        dao.save(edit1);
        dao.save(edit2);
        dao.save(edit3);
        dao.save(edit4);

        dao.save(book1);
        dao.save(book2);
        dao.save(book3);
        dao.save(book4);
        dao.save(book5);

        dao.save(bookShelf1);
        dao.save(bookShelf2);
        dao.save(bookShelf3);
        dao.save(bookShelf4);

        dao.save(copy1);
        dao.save(copy2);
        dao.save(copy3);
        dao.save(copy4);
        dao.save(copy5);

        System.out.println("Données insérés");
    }
}
