package quotes;

import com.google.gson.Gson;
import java.io.*;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\quotes\\app\\src\\main\\resources\\quotes.json"));
                Quote[] quoteList = gson.fromJson(reader, Quote[].class);
                if(quoteList.length>0)
                {
                    Random random= new Random();
                    int randomIndex = random.nextInt(quoteList.length);
                    Quote randomQuote = quoteList[randomIndex];
                    System.out.println("Quote: " + randomQuote.getText());
                    System.out.println("Author: " + randomQuote.getAuthor());
                }else {
                    System.out.println("Quote not found");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
    }
}



