package bean;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class FacadeBean {

	private static FacadeBean singleton = new FacadeBean();
	private static BLFacade facadeInterface;

	public FacadeBean() {

	}

	public String init () {
		try {
			facadeInterface = new BLFacadeImplementation();
			facadeInterface.initializeBD();
		} catch (Exception e) {
			System.out.println("FacadeBean:  " + e.getMessage());
			return "error";
		}
		return "ok";
	}

	public static BLFacade getBusinessLogic() {
		return facadeInterface;
	}

}
