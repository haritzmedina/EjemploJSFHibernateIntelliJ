package businessLogic;

import dataAccess.DataAccess;
import dataAccess.DataAccessInterface;
import dataAccess.HibernateDataAccess;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import jakarta.jws.WebMethod;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


/**
 * It implements the business logic as a web service.
 */
//@WebService(endpointInterface = "businessLogic.BLFacade")
public class BLFacadeImplementation  implements BLFacade {
	HibernateDataAccess dbManager;

	public BLFacadeImplementation()  {
		System.out.println("Creating BLFacadeImplementation instance");
		//ConfigXML c=ConfigXML.getInstance();

		//if (c.getDataBaseOpenMode().equals("initialize")) {
			//DataAccess dbManager=new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
		/*DataAccessInterface dbManager = new HibernateDataAccess();
			dbManager.initializeDB();
			System.out.println("ejecución de initialize");
			dbManager.close();*/
			}




	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 *
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
   @WebMethod
   public Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist{

	    //The minimum bed must be greater than 0
	    DataAccess dBManager=new DataAccess();
		Question qry=null;


		if(new Date().compareTo(event.getEventDate())>0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));


		 qry=dBManager.createQuestion(event,question,betMinimum);

		dBManager.close();

		return qry;
   };

	/**
	 * This method invokes the data access to retrieve the events of a given date
	 *
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
    @WebMethod
	public List<Event> getEvents(Date date)  {
		DataAccess dbManager=new DataAccess();
		List<Event>  events=dbManager.getEvents(date);
		dbManager.close();
		return events;
	}


	/**
	 * This method invokes the data access to retrieve the dates a month for which there are events
	 *
	 * @param date of the month for which days with events want to be retrieved
	 * @return collection of dates
	 */
	@WebMethod public List<Date> getEventsMonth(Date date) {
		DataAccess dbManager=new DataAccess();
		List<Date>  dates=dbManager.getEventsMonth(date);
		dbManager.close();
		return dates;
	}

	/**
	 * This method invokes the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */
    @WebMethod
	 public void initializeBD(){
		HibernateDataAccess dBManager= new HibernateDataAccess();
		dBManager.initializeDB();
		dBManager.close();
	}

}

