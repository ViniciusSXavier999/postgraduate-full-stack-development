package application;

// EXCEÇÃO QUE SERÁ SUBSTITUIDA PELA VALIDAÇÃO

public class Exemplo {
	
	double [] values;
	
	double getValueForPeriod (int periodNumber) {
		try {
			return values[periodNumber];
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}

}
