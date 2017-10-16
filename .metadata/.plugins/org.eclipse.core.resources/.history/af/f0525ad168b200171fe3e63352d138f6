import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FindKey {
	public static HashMap<HashMap<String,Integer>, Double> letterFreq;
	public static HashMap<HashMap<String,Integer>, Double> letterNumber;
	public static HashMap<Integer, Double> totalLetterForN;
	public static HashMap<Integer, Double> icForN;
	
	public static void letterFreqOfTextForN(String text, int n)
	{
		letterFreq = new HashMap<HashMap<String, Integer>, Double>();
		letterNumber = new HashMap<HashMap<String, Integer>, Double>();
		
		totalLetterForN = new HashMap<Integer,Double>();
		for(int i = 1; i <= n; i++)
		{
			totalLetterForN.put(i, 0.0);
			for(int j = 0; j < 26; j++)
			{
				HashMap keyStringInteger = new HashMap<String, Integer>();
				keyStringInteger.put(""+(char)(j+97), i);
				
				letterFreq.put(keyStringInteger, 0.0);
				letterNumber.put(keyStringInteger, 0.0);
			}
		}
		
		char[] charsText = text.toCharArray();
		
		for(int k = 1; k <= n; k++)
		{
			for(int i = 0; i < charsText.length; i += k)
			{
				charsText[i] = Character.toLowerCase(charsText[i]);
				
				//tant que c'est pas une lettre minuscule
				while(!(charsText[i] >= 'a' && charsText[i] <= 'z'))
				{
					i++;
					
					if(i >= charsText.length)
						break;
					
					charsText[i] = Character.toLowerCase(charsText[i]);
				}
				
				if(i >= charsText.length)
					break;
				
				totalLetterForN.put(k, totalLetterForN.get(k) + 1);
				HashMap keyStringInteger = new HashMap<String, Integer>();
				keyStringInteger.put(""+charsText[i], k);
				letterNumber.put(keyStringInteger, letterNumber.get(keyStringInteger) + 1);
			}
		}
		
		for(int k = 1; k <= n; k++)
		{
			for(int i = 97; i <= 'z';i++)
			{
				HashMap keyStringInteger = new HashMap<String, Integer>();
				keyStringInteger.put(""+(char)i, k);
				letterFreq.put(keyStringInteger, letterNumber.get(keyStringInteger)/totalLetterForN.get(k));
			}
		}
		
		calculateIC(n);
	}
	
	public static void calculateIC(int n)
	{
		icForN = new HashMap<Integer, Double>();
		for(int k = 1; k <= n; k++)
		{
			icForN.put(k, getIC(k));
		}
	}
	
	public static double getIC(int k)
	{
		double toReturn = 0.0;
		for(int i = 97; i <= 'z'; i++)
		{
			HashMap keyStringInteger = new HashMap<String, Integer>();
			keyStringInteger.put(""+(char)i, k);
			double top = letterNumber.get(keyStringInteger) * (letterNumber.get(keyStringInteger) - 1.0);
			double bottom = totalLetterForN.get(k) * totalLetterForN.get(k) - 1.0;
			toReturn += top/bottom;
		}
		return toReturn;
	}

	//Donne l'indice de coincidence max du tableau des indices de coincidence
	public static void maxIC(int k) 
	{
		double maxIC = 0.0;
		int indexIC = 0;
		for(int i = 1; i < k; i++)
		{
			if(maxIC < icForN.get(i))
			{
				maxIC = icForN.get(i);
				indexIC = i;
			}	
		}
			
		System.out.println(icForN);
		
		System.out.println(indexIC);
		System.out.println(maxIC);
	}
	
	
	//Retrouve la taille de la clé
	public static void sizeOfKey(String content)
	{
		int n = 10;
		letterFreqOfTextForN(content,n);
		maxIC(n);
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		String content = new Scanner(new File("texteChiffre.txt")).useDelimiter("\\Z").next();
		sizeOfKey(content);
	}

}
