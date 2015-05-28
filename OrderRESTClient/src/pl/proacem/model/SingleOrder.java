package pl.proacem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="ordersingle")
public class SingleOrder implements ModelInterface{

	@Transient
	private static final String itemTable = "Singleorder";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	@Column(name = "orderNumber", length = 255)
	private String orderNumber;

	@Column(name = "offerNumber", length = 255)
	private String offerNumber;

	@Column(name = "requestDate")
	private Date requestDate;

	@Column(name = "expectedDate")
	private Date expectedDate;

	@Column(name = "specification", length = 255)
	private String specification;

	@Column(name = "quantity", length = 255)
	private String quantity;

	@Column(name = "valuePln")
	private String valuePln;

	@Column(name = "valueEur")
	private String valueEur;

	@Column(name = "other", length = 255)
	private String other;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="supplier")
	private Supplier supplier;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="contracting")
	private Person contracting;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="owner")
	private MainOrder owner;

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
	
	public SingleOrder() {
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOfferNumber() {
		return offerNumber;
	}

	public void setOfferNumber(String offerNumber) {
		this.offerNumber = offerNumber;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getValuePln() {
		return valuePln;
	}

	public void setValuePln(String valuePln) {
		this.valuePln = valuePln;
	}

	public String getValueEur() {
		return valueEur;
	}

	public void setValueEur(String valueEur) {
		this.valueEur = valueEur;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Person getContracting() {
		return contracting;
	}

	public void setContracting(Person contracting) {
		this.contracting = contracting;
	}

	public MainOrder getOwner() {
		return owner;
	}

	public void setOwner(MainOrder owner) {
		this.owner = owner;
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
		return orderNumber;
	}

	
}
