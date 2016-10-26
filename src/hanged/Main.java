package hanged;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            KeywordReader keywordReader = new FileKeywordReader("keywords.txt");
            ArrayList<Keyword> keywords = (ArrayList<Keyword>) keywordReader.getKeywords();
            Display display = new ConsoleDisplay();
            RoundRobin<Player> roundRobin = new RoundRobin<>();
            roundRobin.add(new Player("brandon"));
            roundRobin.add(new Player("david"));
            
            for(Keyword kw : keywords)
                System.out.println(kw);
            
//            Game game = new Game( roundRobin, keywords, display);
//        
//            while(!game.isGameover()){
//                game.play();
//            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
