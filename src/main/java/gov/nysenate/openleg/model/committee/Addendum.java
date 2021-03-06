package gov.nysenate.openleg.model.committee;

import gov.nysenate.openleg.model.SenateObject;
import gov.nysenate.openleg.model.calendar.CalendarEntry;
import gov.nysenate.openleg.model.calendar.Section;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Cacheable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
@XmlRootElement
@Cacheable
public class Addendum  extends SenateObject implements Serializable
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 389622255665574925L;

	@Persistent 
	@PrimaryKey
	@Column(name="id", jdbcType="VARCHAR", length=100)
	private String id;
	

	@Persistent 
	@Column(name="addendum_id")
	private String addendumId; 
	
	@Persistent 
	@Column(name="week_of")
	private String weekOf;
	
	@Persistent 
	@Column(name="publication_date_time")
	private Date publicationDateTime;
	
	@Persistent(serialized = "false",defaultFetchGroup="true",mappedBy="addendums")
	@Join
	@Element(dependent = "true")  
	@Order(column="integer_idx")
	private List<Meeting> meetings;
	
	@Persistent(dependent = "false",defaultFetchGroup="true",mappedBy="addendums") 
	@XmlTransient
	private Agenda agenda;
	

	/**
	 * @return the id
	 */
	@XmlAttribute
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	

	/**
	 * @return the agenda
	 */
	@XmlTransient
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * @param agenda the agenda to set
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Addendum ()
	{
		
	}
	
	/**
	 * @return the addendumId
	 */
	@XmlAttribute
	public String getAddendumId() {
		return addendumId;
	}


	/**
	 * @param addendumId the addendumId to set
	 */
	public void setAddendumId(String addendumId) {
		this.addendumId = addendumId;
	}

	/**
	 * @return the weekOf
	 */
	@XmlAttribute
	public String getWeekOf() {
		return weekOf;
	}

	/**
	 * @param weekOf the weekOf to set
	 */
	public void setWeekOf(String weekOf) {
		this.weekOf = weekOf;
	}

	/**
	 * @return the publicationDateTime
	 */
	@XmlAttribute
	public Date getPublicationDateTime() {
		return publicationDateTime;
	}

	/**
	 * @param publicationDateTime the publicationDateTime to set
	 */
	public void setPublicationDateTime(Date publicationDateTime) {
		this.publicationDateTime = publicationDateTime;
	}

	/**
	 * @return the meetings
	 */
	@XmlElementWrapper(name = "meetings")
	@XmlElement(name = "meeting")
	public List<Meeting> getMeetings() {
		return meetings;
	}

	/**
	 * @param meetings the meetings to set
	 */
	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (obj != null && obj instanceof Addendum)
		{
			if ( ((Addendum)obj).getId().equals(this.getId()))
				return true;
		}
		
		return false;
	}

	
	
}
