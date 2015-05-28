package pl.proacem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="mainorder")
public class MainOrder  implements ModelInterface{

	@Transient
	private static final String itemTable = "Mainorder";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(name = "mainNumber", length=255)
	private String mainNumber;
	
	@Column(name = "topic", length=255)
	private String topic;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="leader")
	private Person leader;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="investor")
	private Investor investor;
	
	@Column(name = "stat")
	private int status;
	
	@Column(name = "created", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="createdPerson")
	private Person createdPerson;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="updatedPerson")
	private Person updatedPerson;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="owner")
	private List<SingleOrder> singleOrders = new ArrayList<SingleOrder>();;
	
	
	
	
	public MainOrder() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMainNumber() {
		return mainNumber;
	}

	public void setMainNumber(String mainNumber) {
		this.mainNumber = mainNumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Person getLeader() {
		return leader;
	}

	public void setLeader(Person leader) {
		this.leader = leader;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Person getCreatedPerson() {
		return createdPerson;
	}

	public void setCreatedPerson(Person createdPerson) {
		this.createdPerson = createdPerson;
	}

	public Person getUpdatedPerson() {
		return updatedPerson;
	}

	public void setUpdatedPerson(Person updatedPerson) {
		this.updatedPerson = updatedPerson;
	}

	
	@Override
	public String toString() {
		return mainNumber;
	}



	
	
}
