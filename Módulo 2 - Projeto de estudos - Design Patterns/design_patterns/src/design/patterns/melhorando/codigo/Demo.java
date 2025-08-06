package design.patterns.melhorando.codigo;

public class Demo {

	public static void main(String[] args) {
		testDevice(new Tv());
	}
	
	
	public static void testDevice(Device device) {
		System.out.println("Testes com controle remoto básico");
		BasicRemote basicRemote = new BasicRemote(device);
		basicRemote.power();
		device.printStatus();
		
		System.out.println("Testes com controle remoto avançado. ");
		AdvancedRemote advancedRemote = new AdvancedRemote(device);
		advancedRemote.power();
		advancedRemote.mute();
		device.printStatus();
	}

}
