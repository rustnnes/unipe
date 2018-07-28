package mt;

public class Transition {
	State actual;
	State to;
	String direction; // [R]ight	[L]eft	[S]top
	
	public Transition(State actual, State to, String direction) {
		this.actual = actual;
		this.to = to;
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return actual + " -> " + to + " / " + direction;
	}
	
}
