package pt.ies.cristiano.movieswebcontent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuoteControler {

    private final String file = "quotes.txt";
    
    @GetMapping("/api/quote")
    public Quote randomQuote() {
        ArrayList<Quote> quotes = CarregarQuotes();
        int random = (int) (Math.random() * quotes.size());
        return quotes.get(random);
    }

    @GetMapping("/api/show")
    public HashSet<Show> getShows() {
        ArrayList<Quote> quotes = CarregarQuotes();
        HashSet<Show> shows = new HashSet<>();     
        for (Quote q : quotes) {
            if (!shows.contains(q.getShow())) {
                shows.add(q.getShow());
            }
        }
        return shows;
    }

    @GetMapping("/api/quotes")
    public Quote randomQuotefromShow (@RequestParam(name = "show", defaultValue = "1") int id) {
        ArrayList<Quote> quotes = CarregarQuotes();
        ArrayList<Quote> quotesFromShow = new ArrayList<>();
        for (Quote q : quotes) {
            if (q.getShow().getId() == id) {
                quotesFromShow.add(q);
            }
        }
        int random = (int) (Math.random() * quotesFromShow.size());
        return quotesFromShow.get(random);
    }

    private ArrayList<Quote> CarregarQuotes(){
        ArrayList<Quote> quotes = new ArrayList<>();
        Set<Show> shows = new HashSet<>();
        AtomicLong counter = new AtomicLong();
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File(file));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                Show show = null;

                for(Show s : shows){
                    if(s.getName().equals(parts[1])){
                        show = s;
                        break;
                    }
                }

                if(show == null){
                    show = new Show(counter.incrementAndGet(), parts[1]);
                    shows.add(show);
                }
                
                Quote q = new Quote(parts[0], show);
                quotes.add(q);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Quote file not found."+ e);
            System.exit(1);
        }            
        return quotes;
    }

}
