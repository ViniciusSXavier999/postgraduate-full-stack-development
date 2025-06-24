package refatoracao.estudos.solid.open.closed;

public class XMLReportingStrategy implements ReportingStrategy {
	
	@Override
	public void generateReport() {
		System.out.println("Generate XML Report");
	}

}
