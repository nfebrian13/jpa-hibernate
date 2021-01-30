package com.registration.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "invoiceNumber") })
public class Billing {

	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(strategy = "uuid", name = "uuid2")
	private String id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_register")
	private Register register;

	@NotNull
	@NotEmpty
	private String invoiceNumber;

	@NotNull
	@NotEmpty
	private String bank;

	@NotNull
	@NotEmpty
	private String rekeningNumber;

	@NotNull
	@NotEmpty
	private String rekeningName;
	private String description;

	@NotNull
	private LocalDateTime registrationDate = LocalDateTime.now();

	@NotNull
	private LocalDateTime dueDate = LocalDateTime.now().plusMonths(1);

	@NotNull
	private Boolean paidOff = false;

	public Billing() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getRekeningNumber() {
		return rekeningNumber;
	}

	public void setRekeningNumber(String rekeningNumber) {
		this.rekeningNumber = rekeningNumber;
	}

	public String getRekeningName() {
		return rekeningName;
	}

	public void setRekeningName(String rekeningName) {
		this.rekeningName = rekeningName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getPaidOff() {
		return paidOff;
	}

	public void setPaidOff(Boolean paidOff) {
		this.paidOff = paidOff;
	}
}
