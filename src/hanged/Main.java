package hanged;

import java.util.ArrayList;

//Single player mode is done

//ToDo: Multiplayer mode
//Todo: Better variable/method names?
//Todo: Refine Code if possible

public class Main {
    public static void main(String[] args) {

        try {
            KeywordReader keywordReader = new FileKeywordReader("keywords.txt");
            ArrayList<Keyword> keywords = (ArrayList<Keyword>) keywordReader.getKeywords();
            
            Display display = new ConsoleDisplay();
            Input consoleInput = new ConsoleInput();
            
            RoundRobin<Player> roundRobin = new RoundRobin<>();
            roundRobin.add(new Player("brandon"));
            roundRobin.add(new Player("david"));
            
            //Todo: Console Display responsibility?
            for(Keyword kw : keywords)
                System.out.println(kw);
            
            Game game = new Game( roundRobin, keywords, display);
        
            while(!game.isGameover()){
                //Todo: Console Display responsibility?
                System.out.println(game.getMatchedLetters());
                System.out.println("Chances left: " + game.getChances());
                //
                PlayerInput input = consoleInput.getPlayerInput();
                game.play(input);
            }
            
            //Todo: Console Display responsibility?
            if(game.isSuccess())
                System.out.println("Te la ganaste, saludos (y)");
            
        }catch(Exception e){
            //Todo: Console Display responsibility?
            System.out.println(e.getMessage());
        }
    }
    
}
