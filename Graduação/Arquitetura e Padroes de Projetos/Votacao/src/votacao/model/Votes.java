package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Votes implements Serializable {
	private static final long serialVersionUID = 8190717856303033913L;
	//private static Votes INSTANCE;
	private Map<String, Integer> options;

	private Votes() {
		options = new HashMap<String, Integer>();
	}
	
	private static class Loader {
		private static final Votes INSTANCE = new Votes();		
	}

	public static /*synchronized*/ Votes getInstance() {
		/*if (INSTANCE == null)
			INSTANCE = new Votes();
		return INSTANCE;*/
		return Loader.INSTANCE;
	}
	
	public void addOption(String s) {
		options.putIfAbsent(s, new Integer(0));
	}

	public List<String> Options(){
		if (options.isEmpty()) return null;
		List<String> list = new LinkedList<String>(options.keySet());
		Collections.sort(list);
		return list;
	}
	
	public void voteFor(String s) {
		if (options.containsKey(s)) {
			int v = options.get(s);
			options.put(s, ++v);
		}
	}

	public int getOptionVotes(String s) {
		return options.get(s).intValue();
	}

	public int getTotalVotes() {
		int i = 0;
		for (Integer v : options.values())
			i += v.intValue();
		return i;
	}
	
	/*private Votes readResolve(){
		return getInstance();
	}*/

	public boolean isEmpty(){
		return options.isEmpty();
	}

	public boolean zeroVotes(){
		return getTotalVotes() == 0;
	}

}
