package com.thymeleaf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String password;

	/*
	 * Berikut adalah jenis jpa relations one to one association. Pada hubungan
	 * bidirectional kita harus menentukan anotasi @OneToOne di kedua entitas.
	 */

	/*
	 * fetch, Mendefinisikan strategi untuk mengambil data dari database. by default
	 * adalah FetchType.EAGER.
	 */

	/*
	 * cascade, Mendefinisikan sekumpulan operasi berjenjang yang diterapkan ke
	 * entitas terkait. CascadeType.ALL berarti menerapkan semua operasi cascading
	 * ke entitas terkait. Operasi berjenjang diterapkan saat Anda menghapus atau
	 * memperbarui entitas induk.
	 */

	/*
	 * mappedBy, Mendefinisikan entitas yang memiliki hubungan yang merupakan entitas
	 * Address.
	 */

	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;

	public Users() {
	}

	public Users(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Users(Long id, String name, String email, String password, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
