package hanged;

import java.util.ArrayList;

//Done: Single player mode
//Done: Multiplayer un jugador seleccione la palabra

//Todo: Multiplayer mode
//Todo: Better variable/method names?
//Todo: Refine Code if possible
//BUG: Arreglar el bug de los usuarios: 
//      al cambiar de usuario el primer jugador juega dos veces seguidas 
//      y perdiendo 
//Todo: Console Display responsibility?

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
            
            /*
            for(Keyword kw : keywords)
                System.out.println(kw);
            */
            
            Game game = new Game( roundRobin, keywords, display, consoleInput);
        
            while(!game.isGameOver()){
                System.out.println(game.getMatchedLetters());
                System.out.println("Chances left: " + game.getChances());
                
                /*
                    Las validaciones de game.playTurn tiene que estar
                    antes del player input.
                */
                if(game.checkResetRound())
                    continue;
                
                if(game.isGameOver())
                    break;
            
                
                PlayerInput input = consoleInput.getPlayerInput();
                game.playTurn(input);
            
            
                if(game.isSuccess())
                {
                    roundRobin.forEach((player) -> {
                        System.out.println(player.username + " " + player.score);
                    });
                    System.out.println("Te la ganaste, saludos (y)");
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
