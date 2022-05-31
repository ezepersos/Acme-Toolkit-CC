
package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronages.PatronageStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {

	// Serialisation Identifier 
	private static final long	serialVersionUID	= 1L;

	// Attributes
	
	int									totalNumberOfComponents;
	private transient Map<Pair<String, String>, Double>	averageRetailPriceOfComponentsByTechnologyAndCurrency;
	private transient Map<Pair<String, String>, Double>	deviationRetailPriceOfComponentsByTechnologyAndCurrency;
	private transient Map<Pair<String, String>, Double>	minimumRetailPriceOfComponentsByTechnologyAndCurrency;
	private transient Map<Pair<String, String>, Double>	maximumRetailPriceOfComponentsByTechnologyAndCurrency;
	int									totalNumberOfTools;
	private Map<String, Double>					averageRetailPriceOfToolsByCurrency;
	private Map<String, Double>					deviationRetailPriceOfToolsByCurrency;
	private Map<String, Double>					minimumRetailPriceOfToolsByCurrency;
	private Map<String, Double>					maximumRetailPriceOfToolsByCurrency;
	private Map<PatronageStatus, Integer>		totalNumberOfPatronagesByStatus;
	private Map<PatronageStatus, Double>		averagePatronagesBudgetByStats;
	private Map<PatronageStatus, Double>		deviationPatronagesBudgetByStats;
	private Map<PatronageStatus, Double>		minimumPatronagesBudgetByStats;
	private Map<PatronageStatus, Double>		maximumPatronagesBudgetByStats;
	private Map<String, Integer>					ratioOfArtifacts;
	private Map<String, Double>					averageOfArtifactsByCurrency;
	private Map<String, Double>					deviationOfArtifactsByCurrency;
	private Map<String, Double>				minimumArtifactsByCurrency;
	private Map<String, Double>				maximumArtifactsByCurrency;
	
	
	
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
	
	



}
