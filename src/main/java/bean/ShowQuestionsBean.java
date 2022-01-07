package bean;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import dataAccess.HibernateDataAccess;
import org.primefaces.event.SelectEvent;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import domain.Event;
import domain.Question;

import javax.faces.context.FacesContext;

public class ShowQuestionsBean {
	BLFacade facadeBL;
	private Date date;
	private List<Event> events;


	public void ShowQuestionsBean() {
		facadeBL = FacadeBean.getBusinessLogic();
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void getEventsOnDate(SelectEvent event) {
		this.date = (Date) event.getObject();
		this.events = facadeBL.getEvents(this.date);
	}


}
