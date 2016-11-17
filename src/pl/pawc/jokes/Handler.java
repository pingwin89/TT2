package pl.pawc.jokes;

import java.util.Collections;
import java.util.InputMismatchException;

import pl.pawc.jokes.model.Joke;

public class Handler {
	
	public static void handle(String command){
		switch(command){
		case "help" : help(); break;
		case "load" : load(); break;
		case "save" : save(); break;
		case "print" : print(); break;
		//case "top" : top(); break;
		//case "worst" : worst(); break;
		//case "recent" : recent(); break;
		//case "oldest" : oldest(); break;
		case "add" : add(); break;
		//case "remove" : remove(); break;
		//case "comment" : comment(); break;
		}
	}
	
	private static void help(){
		log("Available commands:");
		log("exit, help, load, save, print, top, worst, recent, oldest, add, remove, comment");
	}
	
	private static void load(){
		Main.map = Database.load();
	}
	
	private static void save(){
		Database.save(Main.map);
	}
	
	private static void print(){
		for(int key : Main.map.keySet()){
			log(Main.map.get(key).toString());
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