package pl.pawc.jokes;

import pl.pawc.jokes.model.Joke;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static HashMap<Integer, Joke> map = new HashMap<Integer,Joke>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]){
		String input = null;
		while(!"exit".equals(input)){
			input = sc.nextLine();
			Handler.handle(input);
		}
	}
		
}