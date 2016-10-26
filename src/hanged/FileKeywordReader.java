package hanged;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileKeywordReader implements KeywordReader{
    
    ArrayList<Keyword> keywords;
    
    FileKeywordReader(String filepath) throws FileNotFoundException, IOException {
        keywords = new ArrayList<>();    
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            keywords.add(new Keyword(line));
            line = br.readLine();
        }
    }

    @Override
    public List<Keyword> getKeywords() {
        return keywords;
    }
    
}
