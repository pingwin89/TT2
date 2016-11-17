package pl.pawc.jokes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import pl.pawc.jokes.model.Joke;

import java.util.HashMap;

public class Database {
	
	static String fileName = "database";

	public static HashMap<Integer, Joke> load(){
		BufferedReader bfr = null;
		HashMap<Integer, Joke> result = new HashMap<>();
		try{
			bfr = new BufferedReader(new FileReader(new File(fileName)));
			String line;
			int key = 1;
			while((line = bfr.readLine()) != null){
				Joke joke = Util.getJokeFrom(line);
				result.put(key, joke);
				key++;
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			return result;
		}
		catch(IOException e){
			e.printStackTrace();
			return result;
		}
		finally{
			close(bfr);
		}
		return result;
	}
	
	private static void close(BufferedReader bfr){
		try{
			bfr.close();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void save(HashMap<Integer, Joke> map){
		FileWriter fw = null;
		try{
			fw = new FileWriter(fileName);
			for(int key : map.keySet()){
				fw.write(Util.getStringFrom(map.get(key)));
				fw.write("\n");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			close(fw);
		}
	}
	
	private static void close(FileWriter fw){
		try{
			fw.close();
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
