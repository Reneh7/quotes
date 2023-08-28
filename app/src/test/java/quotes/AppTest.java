package quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testJSONFileParsing() {
        try {
            Gson gson = new Gson();
            Quote[] quoteArray = gson.fromJson(new FileReader("src/main/resources/quotes.json"), Quote[].class);
            List<Quote> quotes = Arrays.asList(quoteArray);

            assertNotNull(quotes);
            assertFalse(quotes.isEmpty());
            assertEquals(138, quotes.size());

            Quote firstQuote = quotes.get(0);
            assertEquals("I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.", firstQuote.getText());
            assertEquals("Marilyn Monroe", firstQuote.getAuthor());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRandomQuote() {
        InputStream inputStream = getClass().getResourceAsStream("/test-quotes.json");
        Quote[] quotes = new Gson().fromJson(new InputStreamReader(inputStream), Quote[].class);

        assertTrue(quotes != null && quotes.length > 0);

        int randomIndex = (int) (Math.random() * quotes.length);
        Quote randomQuote = quotes[randomIndex];

        assertNotNull(randomQuote);

        System.out.println("Quote: " + randomQuote.getText());
        System.out.println("Author: " + randomQuote.getAuthor());
    }
}
