package pl.pawc.jokes.model;

import java.util.ArrayList;
import java.util.Date;

public class Joke {

	private String author;
	private String text;
	private Date date;
	private int likes;
	private ArrayList<Comment> comments;
	
	public Joke(String author, String text){
		this.author = author;
		this.text = text;
		date = new Date();
		likes = 0;
		comments = new ArrayList<Comment>();
	}
	
	public Joke(String author, String text, Date date, int likes, ArrayList<Comment> comments){
		this.author = author;
		this.text = text;
		this.date = date;
		this.likes = likes;
		this.comments = comments;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getText(){
		return text;
	}
	
	public Date getDate(){
		return date;
	}
	
	public int getLikes(){
		return likes;
	}
	
	public ArrayList<Comment> getComments(){
		return comments;
	}
	
	public String toString(){
		String mainPart = author+": "+text+"\nSubmitted on: "+date.toString()+
				"\nLikes: "+likes;
		String commentPart = "\n";
		for(Comment comment : comments){
			commentPart += comment.toString()+"\n";
		}
		return mainPart + commentPart;
	}
}