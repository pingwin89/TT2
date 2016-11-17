package pl.pawc.jokes;

import pl.pawc.jokes.model.Joke;
import pl.pawc.jokes.model.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Util {

	public static Joke getJokeFrom(String line){
		String[] input = line.split(";");
		String author = input[0];
		String text = input[1];
		Date date = parseDate(input[2]);
		int likes = parseLikes(input[3]);
		ArrayList<Comment> comments = parseComments(input);
		
		Joke joke = new Joke(author, text, date, likes, comments);
		
		return joke;
	}
	
	private static Date parseDate(String line){
		Long dateLong = 0L;
		try{
			dateLong = Long.parseLong(line);
		}
		catch(Exception e){
			e.printStackTrace();
			dateLong = 0L;
		}
		return new Date(dateLong);
	}
	
	private static int parseLikes(String line){
		int result = 0;
		try{
			result = Integer.parseInt(line);
		}
		catch(Exception e){
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	private static ArrayList<Comment> parseComments(String[] table){
		ArrayList<Comment> result = new ArrayList<Comment>();
		for(int i=4; i<table.length; i+=2){
			Comment comment = new Comment(table[i], table[i+1]);
			result.add(comment);
		}
		return result;
	}
	
	public static String getStringFrom(Joke joke){
		String result = "";
		result += joke.getAuthor()+";";
		result += joke.getText()+";";
		result += joke.getDate().getTime()+";";
		result += joke.getLikes()+";";
		result += getStringFrom(joke.getComments());
		return result;
	}
	
	private static String getStringFrom(ArrayList<Comment> comments){
		String result = "";
		if(comments.isEmpty()) return result;
		for(Comment comment : comments){
			result += comment.getAuthor()+";";
			result += comment.getText()+";";
		}
		return result.substring(0, result.length()-1);
	}
	
	public static ArrayList<Joke> getArrayListFrom(HashMap<Integer, Joke> map){
		ArrayList<Joke> result = new ArrayList<Joke>();
		for(int key : map.keySet()){
			result.add(map.get(key));
		}
		return result;
	}
	
}