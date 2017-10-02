import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindKey {
	public static Map<String,Double> letterFreq;
	public static Map<String,Double> letterNumber;
	
	public static void letterFreqOfText(String text)
	{
		letterFreq = new HashMap<String, Double>();
		letterNumber = new HashMap<String, Double>();
		for(int i = 0; i < 26; i++)
		{
			letterFreq.put(""+(char)(i+97), (double) 0);
			letterNumber.put(""+(char)(i+97), (double) 0);
		}
		
		int numberOfLetters = 0;
		
		for(char c : text.toCharArray())
		{
			c = Character.toLowerCase(c);
			if(c >= 'a' && c <= 'z')
			{
				numberOfLetters++;
				//System.out.println(c);
				letterNumber.put(""+c,(double)(letterNumber.get(""+c)+1));
			}
		}
		for(int i = 97; i <= 'z';i++)
		{
			letterFreq.put(""+(char)i,((letterNumber.get(""+(char)i)*100)/numberOfLetters));
		}
		System.out.println(numberOfLetters+" letters !");
	}
	
	//Calculer l'indice de coincidence pour chaque taille de clé jusque 20
	public static void Kasiski(String text)
	{
		
		for(int sizeToTest = 2; sizeToTest < 20; sizeToTest++)
		{
			for(int j=0; j < text.length();j += sizeToTest)
			{
				
			}
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		String content = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
		letterFreqOfText(content);
		Kasiski(content);
		
		double totalLetters = 0;
		double totalPercent = 0;
		
		for (Map.Entry<String, Double> entry : letterNumber.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		    totalLetters += entry.getValue();
		}
		
		for (Map.Entry<String, Double> entry : letterFreq.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		    totalPercent += entry.getValue();
		}
		
		//System.out.println("Total letters : "+totalLetters);
		//System.out.println("Total percent : "+totalPercent);
	}

}
