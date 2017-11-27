import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.util.*;
/**
 * Write a description of class SongManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Song
{
    
    private int x; //limitofsentencesize
  

    
    public Song(int x)
    {
        
        this.x = x;
        
        
        
    }
    
    public Song()
    {
        
        x=8;
        
        
        
    }
    
    public void printSong(int numlines)
    {Generator generator = new Generator();
    for(int i=0; i<numlines; i++)
    {String line = generateSentence(generator);
        System.out.println(line);
    }
    }

    
    public String generateSentence(Generator generator) 
    { Random random = new Random();
      ArrayList<String> seeds = generator.getSeeds();
      ArrayList<String> ends = generator.getEnds();
      String seed = seeds.get(random.nextInt(seeds.size()));
      ArrayList<String> sentence = new ArrayList<String>();
      
      sentence.add(seed);
      HashMap<String, ArrayList> dictionary = generator.getDictionary();
      for(int i=0; i<x; i++)
      { if(ends.contains(sentence.get(i))) {
          if(dictionary.keySet().contains(sentence.get(i)))
          {}
          else
          {break;}
        }
      else{
        
          ArrayList<String> nextwords = dictionary.get(sentence.get(i));
          try{
        String nextword = nextwords.get(random.nextInt(nextwords.size()));
        
        sentence.add(nextword);}
        catch(Exception e){sentence.add("ERROR");}
          }
        
        }
        
        return String.join(" ",sentence);
    }
    
    public void testMethod()
     { 
       Generator g = new Generator(); 
      
       HashMap<String, ArrayList> dictionary = g.getDictionary();
       /**Set<String> keys = dictionary.keySet();
       for( String key : keys)
       {System.out.println(key);}
       ArrayList<String> values = dictionary.get("i'm");
       for( String value : values)
       {System.out.println(value);} */
       System.out.println(generateSentence(g));
       
        }
}
