import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cryptanalyse2 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		String text = new Scanner(new File("texteAnglais1.txt")).useDelimiter("\\Z").next();
		String key = findKey(text);
		
		System.out.println(key);
	}

	private static String findKey(String text)
	{
		String cleanedText = cleanText(text);
		String key = new String();
		
		int keyLength = findkeyLength(cleanedText,15);
		
		
		
		return key;
	}
	
	private static int findkeyLength(String text, int maxLength) 
	{
		int keyLength = 0;
		float maxIC = 0.0f;
		
		for(int i = 1; i <= maxLength; i++)
		{
			int nbCharInText = 0;
			float ic = 0.0f;
			
			int[] alphabet = new int[26];
			
			for(int j = 0; j < alphabet.length; j++)
			{
				alphabet[j] = 0;
			}
			
			for(int j = 0; j < text.length(); j += i)
			{
				alphabet[text.charAt(j) - 'a']++;
				nbCharInText++;
			}
			
			for(int j = 0; j < alphabet.length; j++)
			{
				double freq = alphabet[j];
				ic += (freq / nbCharInText) * ((freq -1) / (nbCharInText - 1)); 
			}
			
			if(ic > maxIC)
			{
				maxIC = ic;
				keyLength = i;
			}
		}
		
		return keyLength;
	}

	private static String cleanText(String text)
	{
		String str = new String();
		for(char c : text.toCharArray())
		{
			if(isLower(c))
				str += c;
			else if(isUpper(c))
				str += Character.toLowerCase(c);
		}
		return str;	
	}
	
	private static boolean isUpper(char ch)
	{
		return ch >= 'A' && ch <= 'Z';
	}

	private static boolean isLower(char ch)
	{
		return ch >= 'a' && ch <= 'z';
	}
}
