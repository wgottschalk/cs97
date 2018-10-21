package cscie97.asn3.housemate.controller;
import cscie97.asn2.housemate.model.ModelService;



/**
 * This command turns off all of the lights in a given room.
 * If no light are present then nothing happens.
 */

public class LightsOffCommand implements Command
{
	private ModelService model;

	public LightsOffCommand(ModelService model){
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

