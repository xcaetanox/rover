package br.com.curiosity.contaazul.actions;

public class Goto {

	private Move move = new Move();
	private Rotation rotation = new Rotation();
	private Field field = new Field();

	public String move(char[] command) throws Exception {

		for (char c : command) {
			if (c == 'M') {
				move.setMoviments(Character.toString(c));
				move.runInAxi(field);
			} else if (c == 'R' || c == 'L') {
				rotation.setRotations(Character.toString(c));
				rotation.setAxiToRun(field);
			} else {
				throw new Exception();
			}
		}
		return field.myPosition();

	}

}
