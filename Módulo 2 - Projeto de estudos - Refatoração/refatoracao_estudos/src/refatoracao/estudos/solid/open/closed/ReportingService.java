package refatoracao.estudos.solid.open.closed;

public class ReportingService {

	public void generateReportBasedOnStrategy(ReportingStrategy reportingStrategy) {
		System.out.println("----------------------------");
		System.out.println("Gerando relatório");
		reportingStrategy.generateReport();
		System.out.println();
	}
	
}
