package hanged;

public class Main {
    public static void main(String[] args) {

        KeywordReader keywordReader = new FileReader("keywords.txt");
        Display display = new ConsoleDisplay();
        RoundRobin<Player> roundRobin = new RoundRobin<>();
        roundRobin.add(new Player("brandon"));
        roundRobin.add(new Player("david"));
        
        Game game = new Game( roundRobin, keywordReader, display);
        
        while(!game.isGameover()){
            game.play();
        }
    }
    
}
