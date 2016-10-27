package hanged;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ConsoleInput implements Input {
    BufferedReader br;
    
    public ConsoleInput() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public PlayerInput getPlayerInput() throws InputException {
        String line;
        System.out.println("Enter line:");
        try {
            line = br.readLine();
        } catch (IOException ex) {
        //    new Exception("", ex)
            throw new InputException(ex.getMessage());
        }
        return new PlayerInput(line);
    }
    
}
