package quotes;

import com.google.gson.Gson;
import java.io.*;
import java.util.Random;

public class App {
    public static void main(String[] args) {
       Gson gson = new Gson();
       Quote[] quotes = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/quotes.json")) ) {
            quotes = gson.fromJson(reader, Quote[].class);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
        if (quotes != null && quotes.length > 0) {
            int randomIndex = new Random().nextInt(quotes.length);
            Quote randomQuote = quotes[randomIndex];
            System.out.println("Quote: " + randomQuote.getText());
            System.out.println("Author: " + randomQuote.getAuthor());
        } else {
            System.out.println("No quotes found.");
        }
    }
}

//package quotes;
//
//import com.google.gson.Gson;
//import java.io.*;
//import java.util.Random;
//
//public class App {
//    private Quote[] quotes;
//
//    public App() {
//        Gson gson = new Gson();
//        try (BufferedReader reader = new BufferedReader(new FileReader("app/src/main/resources/quotes.json"))) {
//            quotes = gson.fromJson(reader, Quote[].class);
//        } catch (IOException e) {
//            System.out.println("Error reading JSON file: " + e.getMessage());
//            quotes = new Quote[0]; // Initialize with an empty array
//        }
//    }
//
//    public Quote getRandomQuote() {
//        if (quotes.length > 0) {
//            int randomIndex = new Random().nextInt(quotes.length);
//            return quotes[randomIndex];
//        } else {
//            return null;
//        }
//    }
//
//    public static void main(String[] args) {
//        App app = new App();
//        Quote randomQuote = app.getRandomQuote();
//
//        if (randomQuote != null) {
//            System.out.println("Quote: " + randomQuote.getText());
//            System.out.println("Author: " + randomQuote.getAuthor());
//        } else {
//            System.out.println("No quotes found.");
//        }
//    }
//}


