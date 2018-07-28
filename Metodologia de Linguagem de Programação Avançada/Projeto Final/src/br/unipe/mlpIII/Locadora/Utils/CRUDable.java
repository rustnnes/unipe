package br.unipe.mlpIII.Locadora.Utils;

import java.util.List;

public interface CRUDable <T> {
	public void			insert(List<T> t);
	public void 		update(List<T> t);
	public void 		delete(List<T> t);
	public List <T> 	select(String query);
	public List<String>	metaData(String where);
}
