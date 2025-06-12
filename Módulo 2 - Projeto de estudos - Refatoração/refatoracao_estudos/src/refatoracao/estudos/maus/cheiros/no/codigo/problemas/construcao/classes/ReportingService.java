package refatoracao.estudos.maus.cheiros.no.codigo.problemas.construcao.classes;

public class ReportingService {
	
	public void generateReportBasedOnStrategy(ReportingStrategy reportingStrategy) {
		System.out.println("===============================");
		System.out.println("Gerando relatório ");
		reportingStrategy.generateReport();
		System.out.println();
	}

}
