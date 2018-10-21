package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Sets an occupants status to inactive if they become inactive (sleep)
 */

public class OccupantInactiveCommand implements Command {

	private ModelService model;

	public OccupantInactiveCommand(ModelService model){
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

