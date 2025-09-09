package application;

public class Exemplo2 {
	
double [] values;
	
	double getValueForPeriod (int periodNumber) {
		
		if(periodNumber >= values.length) {
			return 0;
		} else {
			return values[periodNumber];
		}
	}

}
