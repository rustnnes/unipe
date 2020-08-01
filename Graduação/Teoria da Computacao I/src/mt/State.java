package mt;

import java.util.HashSet;
import java.util.Set;

public class State {

	public final String Id;
	private static int nId;
	private static boolean nInitial;
	private boolean _initial;
	private boolean _final;

	public boolean isInitial() { return _initial; }

	public boolean isFinal() { return _final; }

	public void setFinal() { _final = true; }

	public State() {
		Id = "q" + nId++;
		if (!nInitial) { 
			nInitial = !nInitial;
			this._initial = nInitial;
		}
	}

	public State(boolean _final) {
		this();
		this._final = _final;
	}

	public static State getInitialState(Set<State> states) {
		if (states != null)
			if (!states.isEmpty())
				for (State state : states)
					if (state.isInitial())
						return state;
		return null;
	}

	public static Set<State> getFinalStates(Set<State> states) {
		Set<State> rStates = null;
		if (states != null)
			if (!states.isEmpty()){
				rStates = new HashSet<State>();
				for (State state : states)
					if (state.isFinal())
						rStates.add(state);
			}
		return rStates;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + (_final ? 1231 : 1237);
		result = prime * result + (_initial ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof State))
			return false;
		State other = (State) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (_final != other._final)
			return false;
		if (_initial != other._initial)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "State " + Id + " [Initial=" + _initial + "\tFinal=" + _final + "]";
	}

}
