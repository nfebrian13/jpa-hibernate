package com.registration.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Payment {

	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(strategy = "uuid", name = "uuid2")
	private String id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_billing")
	private Billing billing;

	@NotNull
	private LocalDateTime paymentDate;

	@NotEmpty
	private String reference;

	public Payment() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
