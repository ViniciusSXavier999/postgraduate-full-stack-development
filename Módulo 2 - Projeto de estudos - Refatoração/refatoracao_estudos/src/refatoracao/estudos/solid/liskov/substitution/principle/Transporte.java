package refatoracao.estudos.solid.liskov.substitution.principle;

public class Transporte {
	
	String name;
	double speed;
	Motor motor;
	SemMotor semMotor;
	
	// MÉTODO DA CLASSE
	public void ligarMotor() {
		
	}
	
	public String vaiNaMarra() {
		return "QUEIMANDO CALORIAAAAAAAAAAA";
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public SemMotor getSemMotor() {
		return semMotor;
	}

	public void setSemMotor(SemMotor semMotor) {
		this.semMotor = semMotor;
	}
	

}
