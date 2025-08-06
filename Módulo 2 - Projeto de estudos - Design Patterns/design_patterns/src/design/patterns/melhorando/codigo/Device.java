package design.patterns.melhorando.codigo;

public interface Device {
	
	boolean isEnabled();
	
	void enable();
	
	void disable();
	
	// MÉTODOS DE ACESSO
	int getVolume();
	
	// MÉTODOS DE ACESSO
	void setVolume(int percent);
	
	// MÉTODOS DE ACESSO
	int getChannel();
	
	// MÉTODOS DE ACESSO
	void setChannel(int channel);
	
	void printStatus();
	
	
	
	

}
