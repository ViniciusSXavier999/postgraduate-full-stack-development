package application;

public interface Aula04POO_Interface_InterfaceConta {
	/*Toda conta que implementar essa interface deverá obrigatóriamente ter o método depositar.*/
	void depositar(double valor);
	void sacar(double valor);
	double getSaldo();

}
