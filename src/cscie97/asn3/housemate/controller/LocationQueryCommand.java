package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Finds the location of an occupant via the knowledge graph
 * if no occupant is present, a message is logged.
 */

public class LocationQueryCommand implements Command
{

	private ModelService model;

	public LocationQueryCommand(ModelService model){
	    this.model = model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void execute() {
		// TODO implement me
	}

}

