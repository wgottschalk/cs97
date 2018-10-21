package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Turns on all of the lights in a room. If no lights are present
 * A message is logged stating that there are no lights.
 */

public class LightsOnCommand implements Command
{

	private ModelService model;

	public LightsOnCommand(ModelService model){
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

