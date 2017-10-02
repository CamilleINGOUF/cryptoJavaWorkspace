import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindKey {
	public static Map<String,Double> letterFreq;
	
	public static void letterFreqOfText(String text)
	{
		letterFreq = new HashMap<String, Double>();
		for(int i = 0; i < 26; i++)
			letterFreq.put(""+(char)(i+97), (double) 0);
		
		for(char c : text.toCharArray())
		{
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		String content = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
		letterFreqOfText(content);
		
		for (Map.Entry<String, Double> entry : letterFreq.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}

}
