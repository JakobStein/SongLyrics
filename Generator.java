
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
     


    }

    
    public void setSentence(String sentence)
    {
        
        String[] words = sentence.toLowerCase().split(" ");
        seeds.add(words[0]);
        ends.add(words[-1]);
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
    
    
    
   
    
    public void setDictionary() throws IOException
    {
        String contents = new String(Files.readAllBytes(Paths.get("hallandoats.txt"))); 
         
        String[] lines = contents.split(System.getProperty("line.separator"));
        
        for(String line : lines){
         if(!line.isEmpty()){
          setSentence(line);
             System.out.println(line);
         }
         else
         { 
            }
        }
        
        StringBuilder stringBuild = new StringBuilder();
         for(String s:lines){
        if(!s.equals("")){
         stringBuild.append(s);
          }
        }
        
        String finalString = stringBuild.toString();
        
        
        //System.out.println(finalString);
    }
    
    public void testMethod()
     { try{
         setDictionary();
       
       }
       catch(IOException e) 
       {}
       Set<String> keys = dictionary.keySet();
       for( String key : keys)
       {System.out.println(key);}
       ArrayList<String> values = dictionary.get("i'm");
       for( String value : values)
       {System.out.println(value);}
        }
}
