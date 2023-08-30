package quotes;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testGetQuoteFromApi() {
        HttpURLConnection connection = App.getQuoteFromApi();
        assertNotNull(connection);
    }

    @Test
    void testReadResponseFromApi() {
        HttpURLConnection connection = App.getQuoteFromApi();
        Quote quote = App.readResponseFromApi(connection);
        assertNotNull(quote);
    }

    @Test
    void testAddQuoteToFile() throws IOException {
        String author = "Test Author";
        String body = "Test Body";
        int favoritesCount = 100;
        List<String> tags = Arrays.asList("tag1", "tag2");

        App.addQuoteToFile(author, body, favoritesCount, tags);

        Quote[] updatedQuotes = App.readQuotesFromFile();
        assertTrue(updatedQuotes.length > 0);
    }
}
