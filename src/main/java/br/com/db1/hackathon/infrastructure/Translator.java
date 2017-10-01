package br.com.db1.hackathon.infrastructure;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface Translator<F, T> {

	T translate(F f);

	default List<T> translateList(List<F> fList) {
		return fList.stream().map(this::translate).collect(Collectors.toList());
	}

	default Set<T> translateSet(Set<F> fSet) {
		return fSet.stream().map(this::translate).collect(Collectors.toSet());
	}
}
