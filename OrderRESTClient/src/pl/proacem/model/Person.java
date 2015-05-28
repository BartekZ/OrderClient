package pl.proacem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Person implements ModelInterface{

	public static final String itemTable = "Person";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "login", length = 255)
	private String login;

	@Column(name = "pass", length = 255)
	private String pass;

	@Column(name = "email", length = 255)
	private String email;

	@Column(name = "phone", length = 255)
	private String phone;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "notes", length = 255)
	private String notes;

	@Column(name = "authority", length = 255)
	private String authority;

	@Column(name = "stat")
	private int status;

	@Column(name = "created", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="createdPerson")
	private List<SingleOrder> singleOrders_created = new ArrayList<SingleOrder>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="createdPerson")
	private List<MainOrder> mainOrders_created = new ArrayList<MainOrder>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="createdPerson")
	private List<Supplier> suppliers_created = new ArrayList<Supplier>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="createdPerson")
	private List<Investor> investors_created = new ArrayList<Investor>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="updatedPerson")
	private List<SingleOrder> singleOrders_updated = new ArrayList<SingleOrder>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="updatedPerson")
	private List<MainOrder> mainOrders_updated = new ArrayList<MainOrder>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="updatedPerson")
	private List<Supplier> suppliers_updated = new ArrayList<Supplier>();;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="updatedPerson")
	private List<Investor> investors_updated = new ArrayList<Investor>();;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="leader")
	private List<MainOrder> leaders = new ArrayList<MainOrder>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="contracting")
	private List<SingleOrder> contractors = new ArrayList<SingleOrder>();
	
	public Person() {
	}

	
	public List<MainOrder> getLeaders() {
		return leaders;
	}


	public void setLeaders(List<MainOrder> leaders) {
		this.leaders = leaders;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
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


	public List<SingleOrder> getSingleOrders_created() {
		return singleOrders_created;
	}


	public void setSingleOrders_created(List<SingleOrder> singleOrders_created) {
		this.singleOrders_created = singleOrders_created;
	}


	public List<MainOrder> getMainOrders_created() {
		return mainOrders_created;
	}


	public void setMainOrders_created(List<MainOrder> mainOrders_created) {
		this.mainOrders_created = mainOrders_created;
	}


	public List<Supplier> getSuppliers_created() {
		return suppliers_created;
	}


	public void setSuppliers_created(List<Supplier> suppliers_created) {
		this.suppliers_created = suppliers_created;
	}


	public List<Investor> getInvestors_created() {
		return investors_created;
	}


	public void setInvestors_created(List<Investor> investors_created) {
		this.investors_created = investors_created;
	}


	public List<SingleOrder> getSingleOrders_updated() {
		return singleOrders_updated;
	}


	public void setSingleOrders_updated(List<SingleOrder> singleOrders_updated) {
		this.singleOrders_updated = singleOrders_updated;
	}


	public List<MainOrder> getMainOrders_updated() {
		return mainOrders_updated;
	}


	public void setMainOrders_updated(List<MainOrder> mainOrders_updated) {
		this.mainOrders_updated = mainOrders_updated;
	}


	public List<Supplier> getSuppliers_updated() {
		return suppliers_updated;
	}


	public void setSuppliers_updated(List<Supplier> suppliers_updated) {
		this.suppliers_updated = suppliers_updated;
	}


	public List<Investor> getInvestors_updated() {
		return investors_updated;
	}


	public void setInvestors_updated(List<Investor> investors_updated) {
		this.investors_updated = investors_updated;
	}


	public List<SingleOrder> getContractors() {
		return contractors;
	}


	public void setContractors(List<SingleOrder> contractors) {
		this.contractors = contractors;
	}

	
	@Override
	public String toString() {
		return name;
	}


}
