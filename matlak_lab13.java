package matlak_lab13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class matlak_lab13 {
	
	List<Integer> numbers = new ArrayList<Integer> ();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void readData(String filename)
	 {
		 URL url = getClass().getResource(filename);
		 File f = new File(url.getPath());
	        try (BufferedReader reader = new BufferedReader(new FileReader(f));)
	        {
	            String line = null;
	            while ((line = reader.readLine()) != null) 
	            {
	            	try {
	            	numbers.add(Integer.parseInt(line));
	            	}catch(Exception e) {continue;}
	                
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	 }
	 public long getTotalCount()
	 {
		 return numbers.stream().count();
	 }
	 public long getOddCount()
	 {
		 return numbers.stream().filter(c -> c%2 != 0).count();
	 }
	 public long getEvenCount()
	 {
		 return numbers.stream().filter(c -> c%2 == 0).count();
	 }
	 public long getDistinctGreaterThanFiveCount()
	 {
		 return numbers.stream().filter(c -> c>5).distinct().count();
	 }
	 public Integer[] getResult1()
	 {
		 return (Integer[]) numbers.stream().filter(c -> (((c%2 == 0)||(c==0)) &&  (c> 5 && c<50))).sorted().collect(Collectors.toList()).toArray(Integer[]::new);
	 }
	 public Integer[] getResult2()
	 {
		
		 return (Integer[]) numbers.stream().map(c -> (c*c)*3).limit(50).collect(Collectors.toList()).toArray(Integer[]::new);
	 }
	 public Integer[] getResult3()
	 {
		 return (Integer[]) numbers.stream().filter(n -> {return ((n%2)!=0);}).collect(Collectors.toList()).stream().map(n -> {return n*2;}).sorted().skip(20).distinct().collect(Collectors.toList()).toArray(Integer[]::new);
		
		 	
	 }


}
