package refatoracao.estudos.solid.open.closed;

public class CSVReportingStrategy implements ReportingStrategy {
	
	@Override
	public void generateReport() {
		System.out.println("CSV");
	}

}
