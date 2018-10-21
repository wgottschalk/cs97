package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;


/**
 * Closes a door in a given room.
 * Only one door in a room can be closed at a time.
 */

public class CloseDoorCommand implements Command
{
	private ModelService model;

	public CloseDoorCommand(ModelService model){
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

