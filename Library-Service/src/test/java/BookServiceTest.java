import com.formation.infotel.config.SpringConfig;
import com.formation.infotel.entity.Book;
import com.formation.infotel.services.interfaces.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BookServiceTest {
    private BookService service;

    @Before
    public void setup(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(SpringConfig.class);
        ctx.refresh();

        service = ctx.getBean(BookService.class);
    }

    @Test
    public void itShouldReturnBookWithNaruto() throws Exception{
        String recherche = "Naruto Shippuden";

        List<Book> books = service.getBooksByCriteria(recherche);

        assertThat(books)
                .isNotNull()
                .hasSize(1)
                .doesNotContainNull();

        Book livre0 = books.get(0);
        assertThat(livre0)
                .extracting(Book::getIsbn, Book::getBookTitle, Book::getBookPrice) // actual
                .contains(53, "Naruto Shippuden", 7.0f); // expected

    }
}
