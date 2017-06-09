package br.com.curiosity.contaazul.actions;

import java.util.ArrayList;
import java.util.List;

public class Move {
	
	private List<String> moviments = new ArrayList<>();

	public List<String> getMoviments() {
		return moviments;
	}

	public void setMoviments(String moviment){
		this.moviments.add(moviment);
	}
	
	public void runInAxi(Field field) throws Exception{
		if (field.isX()){
			if(field.isInc()){
				field.setX(field.getX()+1);
			}else{
				field.setX(field.getX()-1);
			}
		}else{
			if(field.isInc()){
				field.setY(field.getY()+1);
			}else{
				field.setY(field.getY()-1);
			}
		}
	}

}
