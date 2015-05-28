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
@Table(name="supplier")
public class Supplier implements ModelInterface{
	
	@Transient
	private static final String itemTable = "Supplier";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
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
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="supplier")
	private List<SingleOrder> singleOrders = new ArrayList<SingleOrder>();
	
	public Supplier() {
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
		return name;
	}




	
	
}
