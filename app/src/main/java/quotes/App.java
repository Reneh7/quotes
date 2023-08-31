package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        HttpURLConnection connection = getQuoteFromApi();
        Quote quote = readResponseFromApi(connection);
        addQuoteToFile(quote.getAuthor(), quote.getBody(), quote.getFavoritesCount(), quote.getTags());
    }

    public static HttpURLConnection getQuoteFromApi() {
        try {
            URL url = new URL("https://favqs.com/api/qotd");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            return connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Quote readResponseFromApi(HttpURLConnection connection) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            Gson gson = new Gson();
            APIResponse apiResponse = gson.fromJson(reader, APIResponse.class);
            Quote randomQuote = apiResponse.getQuote();
            reader.close();
            connection.disconnect();
            return randomQuote;
        } catch (IOException e) {
            System.out.println("Error fetching quote from API: " + e.getMessage());
            System.out.println("Loading quotes from JSON file...");
            Quote[] quotesFromFile = readQuotesFromFile();
            if (quotesFromFile.length > 0) {
                int randomIndex = new Random().nextInt(quotesFromFile.length);
                return quotesFromFile[randomIndex];
            } else {
                throw new RuntimeException("No quotes available.");
            }
        }
    }

    public static void addQuoteToFile(String author, String body, int favoritesCount, List<String> tags) {
        try {
            File file = new File("app/src/main/resources/quotes.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            List<Quote> existingQuotes = loadQuotesFromFile();

            Quote quoteToAdd = new Quote();
            quoteToAdd.setAuthor(author);
            quoteToAdd.setBody(body);
            quoteToAdd.setFavoritesCount(favoritesCount);
            quoteToAdd.setTags(tags);

            existingQuotes.add(quoteToAdd);

            FileWriter writer = new FileWriter(file);
            gson.toJson(existingQuotes, writer);
            writer.close();

            System.out.println("The Author: " + author);
            System.out.println("The Quote: " + body);
            System.out.println("=========================");
            System.out.println("Quote added to file.");
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public static Quote[] readQuotesFromFile() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(App.class.getClassLoader().getResourceAsStream("quotes.json")))) {
            return gson.fromJson(reader, Quote[].class);
        } catch (Exception e) {
            System.out.println("Error reading quotes from JSON file: " + e.getMessage());
            return new Quote[0];
        }
    }

    public static List<Quote> loadQuotesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/quotes.json"))) {
            Gson gson = new Gson();
            List<Quote> existingQuotes = new ArrayList<>();

            Quote[] quotes = gson.fromJson(reader, Quote[].class);
            if (quotes != null) {
                for (Quote quote : quotes) {
                    existingQuotes.add(quote);
                }
            }

            return existingQuotes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
