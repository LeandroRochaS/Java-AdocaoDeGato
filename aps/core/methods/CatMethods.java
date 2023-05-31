package core.methods;

import java.util.List;

import entites.Cat;

public class CatMethods {

	public Cat searchCat(String idCat, List<Cat> cats) {
		for (Cat cat : cats) {
			if (cat.getSingleCode().equals(idCat)) {
				return cat;
			}
		}
		return null;
	}
}
