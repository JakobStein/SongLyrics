import java.util.*;
public class WordFrequency

{
    // instance variables - replace the example below with your own
    private HashMap<String,Integer> count;
    private String text;
    private String[] wordlist;

    /**
     * Constructor for objects of class WordFrequency
     */
    public WordFrequency(String sampleText)
    {
        count= new HashMap<String,Integer>();
        text=sampleText;
        wordlist=sampleText.toLowerCase().split(" ");
        for(String i: wordlist)
        {if(count.containsKey(i))
            {Integer t=count.get(i);
                count.put(i,t+1);

            }
            else
            {count.put(i,1);}

        }
    }


    public WordFrequency()
    {
        count= new HashMap<String,Integer>();
        text="sampleText";
        wordlist=text.toLowerCase().split(" ");
        for(String i: wordlist)
        {if(count.containsKey(i))
            {Integer t=count.get(i);
                count.put(i,t+1);

            }
            else
            {count.put(i,1);}

        }
    }

    public Set<String> wordused()
    {System.out.println(count.keySet().toString());
        return count.keySet();
    }
    

}