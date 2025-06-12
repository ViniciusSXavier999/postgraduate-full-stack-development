# 6 → COMENTÁRIOS

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/comentarios1.png" />

> Quando enchemos nosso código de comentários não é bem visto, porque isso pode significar que o nosso código está mal estruturado
> 

> Devemos utilizar os comentários de forma assertiva, quando efetivamente algo precisa ser esclarecido com uma cautela um pouco maior.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/comentarios2.png" />

> Nós podemos colocar aquela função em um método, isso pode facilitar a compreensão e organização do nosso código.
> 

---

<img width="600" src = "https://github.com/ViniciusSXavier999/Assets/blob/main/P%C3%B3sGradua%C3%A7%C3%A3o/comentarios3.png" />

> A refatoração vai ser o nosso ponto de partida.
> 

---

## MÃO NA MASSA!

### PODEMOS OBSERVAR QUE NA NOSSA AULA ANTERIOR UTILIZAMOS O USO DO COMENTÁRIO NAS NOSSAS FUNÇÕES

🏆 Podemos notar que o uso desse comentário não é tão necessário assim, porque o nome do objeto já faz menção ao XML e ao CSV, o código está muito bem legível.


🏆 Só colocamos os comentários em situações muito especificas, sendo assim, tornando a leitura do nosso código fluida. 

```java
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
```
