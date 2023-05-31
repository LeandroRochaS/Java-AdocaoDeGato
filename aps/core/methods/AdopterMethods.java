package core.methods;

import java.util.List;

import entites.Adopter;

public class AdopterMethods {

	public Adopter searchAdopter(String cpf, List<Adopter> adopters) {
		for (Adopter adopter : adopters) {
			if (adopter.getCpf().equals(cpf)) {
				return adopter;
			}
		}
		return null;
	}
}
