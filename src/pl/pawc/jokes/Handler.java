package pl.pawc.jokes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import pl.pawc.jokes.model.Comment;
import pl.pawc.jokes.model.Joke;
import pl.pawc.jokes.model.SortByDate;

public class Handler {
	
	public static void handle(String command){
		switch(command){
		case "help" : help(); break;
		case "load" : load(); break;
		case "save" : save(); break;
		case "list" : list(); break;
		case "top" : top(); break;
		case "worst" : worst(); break;
		case "recent" : recent(); break;
		case "oldest" : oldest(); break;
		case "add" : add(); break;
		case "like" : like(); break;
		case "remove" : remove(); break;
		case "comment" : comment(); break;
		}
	}
	
	private static void help(){
		log("Available commands:");
		log("exit, help, load, save, list, top, worst, recent, oldest, add, remove, comment");
	}
	
	private static void load(){
		Main.map = Database.load();
	}
	
	private static void save(){
		Database.save(Main.map);
	}
	
	private static void list(){
		for(int key : Main.map.keySet()){
			log(key+": "+Main.map.get(key).toString());
		}
	}
	
	private static void top(){
		ArrayList<Joke> jokes = Util.getArrayListFrom(Main.map);
		Collections.sort(jokes);
		list(jokes);
	}
	
	private static void worst(){
		ArrayList<Joke> jokes = Util.getArrayListFrom(Main.map);
		Collections.sort(jokes, Collections.reverseOrder());
		list(jokes);
	}
	
	private static void recent(){
		ArrayList<Joke> jokes = Util.getArrayListFrom(Main.map);
		Collections.sort(jokes, new SortByDate());
		list(jokes);
	}
	
	private static void oldest(){
		ArrayList<Joke> jokes = Util.getArrayListFrom(Main.map);
		Collections.sort(jokes, Collections.reverseOrder(new SortByDate()));
		list(jokes);
	}

	private static void list(ArrayList<Joke> jokes){
		for(Joke joke : jokes){
			log(joke.toString());
		}
	}
	
	private static void add(){
		log("Your name: ");
		String author = readString();
		log("Your joke: ");
		String text = readString();
		Joke joke = new Joke(author, text);
		int nextKey;
		if(Main.map.keySet().isEmpty()){
			nextKey = 1;
		}
		else{
			nextKey = Collections.max(Main.map.keySet())+1;
		}
		Main.map.put(nextKey, joke);
	}
	
	private static void like(){
		log("Which joke");
		int number = readInteger();
		if(Main.map.get(number) == null){
			log("No such joke");
			return;
		}
		else{
			Main.map.get(number).addLike();
		}
	}
	
	private static void remove(){
		log("Which joke");
		int number = readInteger();
		if(Main.map.get(number) == null){
			log("No such joke");
			return;
		}
		else{
			Main.map.remove(number);
		}
	}
	
	private static void comment(){
		
		log("Your name: ");
		String author = readString();
		log("Your comment: ");
		String text = readString();
		
		log("Which joke");
		int number = readInteger();
		if(Main.map.get(number) == null){
			log("No such joke");
			return;
		}
		
		Comment comment = new Comment(author, text);
		Main.map.get(number).addComment(comment);
	}
	
	private static void log(String message){
		System.out.println(message);
	}
	
	private static String readString(){
		String result = "";
		try{
			result = Main.sc.nextLine();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	private static int readInteger(){
		int result;
		try{
			result = Main.sc.nextInt();
		}
		catch(InputMismatchException e){
			e.printStackTrace();
			result = 0;
		}
		catch(Exception e){
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
}