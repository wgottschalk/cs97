package cscie97.asn3.housemate.controller;

import cscie97.asn2.housemate.model.ModelService;

/**
 * Trigger a series of events when an occupant walks into a room
 * TODO: what are those events???
 */

public class OccupantDetectedCommand implements Command
{

	private ModelService model;

	public OccupantDetectedCommand(ModelService model){
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

