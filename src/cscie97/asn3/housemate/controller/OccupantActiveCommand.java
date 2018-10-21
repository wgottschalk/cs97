package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Sets an occupants status to active if they become active
 */

public class OccupantActiveCommand implements Command
{

	private ModelService model;

	public OccupantActiveCommand(ModelService model){
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

