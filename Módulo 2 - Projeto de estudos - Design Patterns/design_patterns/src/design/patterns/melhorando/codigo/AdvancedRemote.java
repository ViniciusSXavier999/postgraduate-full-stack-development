package design.patterns.melhorando.codigo;

public class AdvancedRemote extends BasicRemote {
	
	public AdvancedRemote (Device device) {
		super.device = device;
	}
	
	public void mute() {
		System.out.println("Controlo remoto: tirar volume (mudo)");
		device.setVolume(0);
	}

}
