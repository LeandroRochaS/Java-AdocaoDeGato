package core.methods;

import java.util.List;

import entites.Cat;

public class CatMethods {

	public static Cat searchCat(String idCat, List<Cat> cats) {
		for (Cat cat : cats) {
			if (cat.getSingleCode().equals(idCat)) {
				return cat;
			}
		}
		return null;
	}
	
	//Adiciona os gatos que não foram adotados em uma lista
	public static List<Cat> relatorioCat(List<Cat> cats, List<Cat> relatorio) {
		relatorio.clear();
	    for (Cat cat : cats) {
	        if (cat.getCpfAdopter().equals("")) {
	            Cat novoCat = new Cat(cat.getSingleCode(), cat.getName(), cat.getRace(), cat.getSurname(), cat.getGender(), cat.getEntryDate(), cat.getAge(), cat.getFood(), cat.getQuantityFood(), cat.getWeight(),
	            		cat.getExitDate(), cat.getCpfAdopter()); // Cria um novo objeto Cat com os atributos relevantes
	            relatorio.add(novoCat); // Adiciona o novo objeto à lista relatorio
	        }
	    }
	    return relatorio;
	}}
