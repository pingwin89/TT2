package pl.pawc.jokes.model;

import java.util.Comparator;

public class SortByDate implements Comparator<Joke> {

	@Override
	public int compare(Joke o1, Joke o2) {
		if(o1.getDate().getTime() == o2.getDate().getTime()) return 0;
		return o1.getDate().getTime() < o2.getDate().getTime() ? 1 : -1 ;
	}

} 