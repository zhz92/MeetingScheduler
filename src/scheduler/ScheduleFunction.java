package scheduler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleFunction {
	public static void save (String filename, List<String> x) throws IOException{
		  BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter(filename));
		  for (String s : x) {
		    outputWriter.write(s);
		    outputWriter.newLine();
		  }
		  outputWriter.flush();  
		  outputWriter.close();  
		}
	
    public static List<String> load (String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines;
    }

    public static Boolean updateTime(String date) throws IOException {
    	Integer i = Integer.parseInt(date);
    	List<String> schedule = load("/Users/davidzhang/Desktop/database.txt");
    	while(schedule.size() <= i) {
    		schedule.add("0");
    	}
    	if(schedule.get(i).equals("0")) {
    		schedule.set(i,"1");
    		save("/Users/davidzhang/Desktop/database.txt",schedule);
    		return true;
    	}
    	return false;
    }
    
    public static Boolean checkDate (String date) throws IOException {
//    	Integer i = Integer.parseInt(date);
    	List<String> schedule = load("/Users/davidzhang/Desktop/database.txt");
    	if (schedule.contains(date)) {
    		return true;
    	}
    	return false;
    }
    
    public static void clear() throws IOException {
    	List<String> blank = new ArrayList<String>();
    	save("/Users/davidzhang/Desktop/database.txt", blank);
    }
}
