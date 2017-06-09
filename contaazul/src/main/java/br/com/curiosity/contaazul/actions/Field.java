package br.com.curiosity.contaazul.actions;

public class Field {

	public static final int heigth = 5;
	public static final int whith = 5;

	private int x = 0;

	private int y = 0;
	
	private boolean inc = true;

	private boolean isX;

	private String turnFor = "N";

	public boolean isInc() {
		return inc;
	}

	public void setInc(boolean inc) {
		this.inc = inc;
	}

	public boolean isX() {
		return isX;
	}

	public void setX(boolean isX) {
		this.isX = isX;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws Exception {
		if(x>whith|| x<0){
			throw new Exception();	
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws Exception {
		if(y>heigth || y<0){
			throw new Exception();	
		}
		this.y = y;
	}
	
	 public void setWay(){
			if (turnFor.equals("N")) {
				setX(false);
				setInc(true);
			} else if (turnFor.equals("E")) {
				setX(true);
				setInc(true);
			} else if (turnFor.equals("S")) {
				setX(false);
				setInc(false);
			} else if (turnFor.equals("W")) {
				setX(true);
				setInc(false);
			}
		}
	
	public String getViradoPara() {
		return turnFor;
	}

	public void setViradoPara(String viradoPara) {
		this.turnFor = viradoPara;
	}
	
	public String myPosition() {
		return "("+getX() + ", " + getY() +", "+getViradoPara()+")";

	}
	

}
