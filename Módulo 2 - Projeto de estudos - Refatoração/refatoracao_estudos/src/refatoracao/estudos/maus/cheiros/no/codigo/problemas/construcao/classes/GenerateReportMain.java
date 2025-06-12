package refatoracao.estudos.maus.cheiros.no.codigo.problemas.construcao.classes;

public class GenerateReportMain {

	public static void main(String[] args) {
		ReportingService rs = new ReportingService();
		
		// GERAR RELATÓRIO CSV
		ReportingStrategy csvReportingStrategy = new CSVReportingStrategy();
		rs.generateReportBasedOnStrategy(csvReportingStrategy);
		
		// GERAR RELATÓRIO XML 
		ReportingStrategy xmlReportingStrategy = new XMLReportingStrategy();
		rs.generateReportBasedOnStrategy(xmlReportingStrategy);
	}

}
