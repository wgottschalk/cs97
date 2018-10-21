package cscie97.asn3.housemate.controller;


import cscie97.asn2.housemate.model.ModelService;

/**
 * This command will ask the user if they would like their beer
 * restocked if it gets low.
 */

public class BeerRestockCommand implements Command
{

	private ModelService model;

	public BeerRestockCommand(ModelService model){
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

