import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cryptanalyse 
{
	//Nombre de chaque lettre dans chaque texte de 1/k
	//exemple letterFrenquencie['a' - 97][3] -> nombre de 'a' dans le texte 1/3
	private int[][] letterFrequencies;
	
	private int[][] letterFrequencies2;
	
	//Indices de coincidence de chaque 1/k
	private double[] ics;
	
	private double[] ics2;
	
	private String text;
	
	//Somme de toutes les lettres de chaque texte 1/k
	private int[] sums;
	
	private int[] sums2;
	
	//longueur max à tester pour la taille dela clé
	private int maxLength;
	
	//init tous les tableaux à 0
	public Cryptanalyse(int maxLength, String text) 
	{
		this.letterFrequencies = new int[26][maxLength];
		this.ics = new double[maxLength];
		sums = new int[maxLength];
		this.text = new String(text);
		this.maxLength = maxLength;
		
		for(int i = 0; i < letterFrequencies.length; i++)
		{
			for(int j = 1; j <= letterFrequencies[i].length; j++)
			{
				letterFrequencies[i][j - 1] = 0;
				ics[j-1] = 0.0;
				sums[j - 1] = 0;
			}
		}
	}
	
	//Calcule le nombre de chaque lettres pour chaque texte 1/k
	//Et remplit le tableau des sommes
	private void calculLettersFrequencies()
	{
		for(int i = 1; i <= maxLength; i++)
		{
			for(int j = 0; j < text.length(); j += i)
			{
				char tempChar = Character.toLowerCase(text.charAt(j));
				
				//tant que c'est pas une lettre minuscule je passe à la lettre suivante
				while(!(tempChar >= 'a' && tempChar <= 'z'))
				{
					j++;
					
					if(j >= text.length())
						break;
					
					tempChar = Character.toLowerCase(text.charAt(j));
				}
				
				if(j >= text.length())
					break;
				
				letterFrequencies[tempChar - 97][i - 1]++;
				sums[i-1]++;
			}
		}
	}
	
	private List<String> splitEqually(String text, int size) 
	{
	    List<String> ret = new ArrayList<String>(size);
	    int partSize = text.length()/size;
	    //System.out.println(text.length() % size);
	    
	    String buffer = new String();
	    for(int j = 0; j < size; j++)
	    {
		    for(int i = partSize * j; i < partSize * j + partSize; i++)
		    {
		    	buffer += text.charAt(i);
		    }
		    if(j == size - 1)
		    {
		    	for (int i = text.length() - 1; i >= text.length() - text.length()%size; i--) 
		    	{
		    		buffer += text.charAt(i);
				}
		    }
		    ret.add(buffer);
		    buffer = new String();
	    }
	    return ret;
	}

	private Map<Integer, Double> calculLettersFrequencies2() 
	{
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for(int i = 1; i <= maxLength; i++)
		{
			List<String> subStrings = splitEqually(text, i);
			List<Double> ics = new ArrayList<Double>();
			
			for(String s : subStrings)
			{
				int[] letterFreq = new int[26];
				int sum = 0;
				for(int j = 0; j < s.length(); j++)
				{
					char tempChar = Character.toLowerCase(s.charAt(j));
					
					//tant que c'est pas une lettre minuscule je passe à la lettre suivante
					while(!(tempChar >= 'a' && tempChar <= 'z'))
					{
						j++;
						
						if(j >= s.length())
							break;
						
						tempChar = Character.toLowerCase(s.charAt(j));
					}
					
					if(j >= s.length())
						break;
					
					letterFreq[tempChar - 97]++;
					sum++;
				}
				
				double tempIC = 0.0;
				for(int j = 0; j < letterFreq.length; j++)
				{
					tempIC += (letterFreq[j] * (letterFreq[j] - 1)) / (double)(sum * (sum - 1));
				}
				ics.add(tempIC);
			}
			
			double sumIC = 0.0;
			for (int j = 0; j < ics.size(); j++) 
				sumIC += ics.get(j);
			map.put(i, sumIC/ics.size() * 100);
		}
		return map;
	}

	//Calcule tous les indices de coincidence pour chaque 1/k
	private void calculICs() 
	{
		for(int j = 1; j <= maxLength; j++)
		{
			for(int i = 0; i < letterFrequencies.length; i++)
			{
				double top = letterFrequencies[i][j - 1] * (letterFrequencies[i][j - 1] - 1);
				double bottom = sums[j - 1] * (sums[j - 1] - 1);
				ics[j - 1] += top/bottom;
				//System.out.println(j+" "+(char)(97 + i)+" "+letterFrequencies[i][j - 1]+ " * " + (letterFrequencies[i][j - 1] - 1));
			}
		}
	}

	//retourne le plus grand indice de coincidence
	private int maxIC() 
	{
		int toReturn = 0;
		double maxIC = 0.0;
		for(int i = 0; i < ics.length; i++)
		{
			//System.out.println((i+1) + " " + (ics[i]*100));
			if(maxIC < ics[i])
			{
				maxIC = ics[i];
				toReturn = i + 1;
			}
		}
		
		return toReturn;
	}

	//Retourne la taille supposée de la clé (ne fonctionne surement pas)
	public int getSupposedKeyLength() 
	{
		calculLettersFrequencies();
		calculICs();
		
		System.out.println(calculLettersFrequencies2());
		
		return maxIC();
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException 
	{
		String text = new Scanner(new File("texteChiffre.txt")).useDelimiter("\\Z").next();
		Cryptanalyse breagVig = new Cryptanalyse(10, text);
		
		int size = breagVig.getSupposedKeyLength();
		//System.out.println("Length ~ "+size);
	}
}
