package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;


/**
 * This can arbitarily set the status on any device.
 * TODO: This command will trigger the notify observers event???
 */

public class SetDeviceStatusCommand implements Command
{
	private ModelService model;

	public SetDeviceStatusCommand(ModelService model){
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

