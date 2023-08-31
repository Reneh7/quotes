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
}
