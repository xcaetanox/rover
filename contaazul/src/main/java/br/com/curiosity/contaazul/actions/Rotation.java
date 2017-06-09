package br.com.curiosity.contaazul.actions;

import java.util.ArrayList;
import java.util.List;

public class Rotation {

	private List<String> rotations = new ArrayList<>();

	public List<String> getRotations() {
		return rotations;
	}

	private String[] posicao = new String[] { "N", "E", "S", "W" };

	public void setRotations(String rotation) {
		this.rotations.add(rotation);
	}

	public void setAxiToRun(Field field) {
		int i = 0;
		for (String rto : rotations) {

			if (i <= 3) {
				if (rto.equals("R")) {
					if (i == 3) {
						i = 0;
					} else {
						i++;
					}

				} else {
					if (i == 0) {
						i = 3;
					} else {
						i--;
					}

				}
				field.setViradoPara(posicao[i]);
				field.setWay();
			}
		}

	}

}
