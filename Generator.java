
import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.util.*;


public class Generator
{
  
    
    private HashMap<String, ArrayList> dictionary;
    private ArrayList<String> seeds;
    private ArrayList<String> ends;

    
    public Generator() 
    {
        
        dictionary = new HashMap<String, ArrayList>();
        seeds = new ArrayList<String>();
        ends = new ArrayList<String>();
        ArrayList<String> filenames = new ArrayList<String>();
        filenames.add("hallandoats.txt");
        filenames.add("georgemichael.txt");
        filenames.add("duranduran.txt");
        for (String s : filenames)
        {
        try{
         String contents = new String(Files.readAllBytes(Paths.get(s)));
         setDictionary(contents);
     
         }
       catch(IOException e) 
         {System.out.println("Please insert text files to project and try again.");}
        }


    }

    
    private void setSentence(String sentence)
    {
       
        String[] words = sentence.toLowerCase().split(" ");
        
           
       
        seeds.add(words[0]);
        ends.add(words[words.length-1]);
        
        for(int i=0;i<words.length-1;i++){
        String current = words[i]; 
        String next = words[i+1];
        if(dictionary.containsKey(current))
          {dictionary.get(current).add(next);}
        
        else
        {ArrayList<String> nextword = new ArrayList<String>();
            nextword.add(next);
            dictionary.put(current, nextword);
        }
         }
    
  
        
    }
    
    public HashMap getDictionary()
    { return dictionary;
    }
    
    public ArrayList getSeeds()
    {return seeds;}
    
    public ArrayList getEnds()
    
    {return ends;}
   
    
    private void setDictionary(String contents) 
    {
         
        contents = contents.replaceAll("[(\\?)(\\,)]", "");
        String[] lines = contents.split(System.getProperty("line.separator"));
        
        for(String line : lines){
         if(!line.isEmpty()){
          if(!line.trim().isEmpty())
             {setSentence(line);
                }
         }
         else 
         { 
            }
        }
        
       
        
        
       
    }
    
    
}

