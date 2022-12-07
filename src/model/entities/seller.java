package model.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class seller implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private Date date;
	private Double baseSalary;

	private departments dept;

	public seller() {
	}

	public seller(Integer id, String name, String email, Date date, Double baseSalary, departments dept) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
		this.baseSalary = baseSalary;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public departments getDept() {
		return dept;
	}

	public void setDept(departments dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		seller other = (seller) obj;
		return Objects.equals(id, other.id);
	}

	

	@Override
	public String toString() {
		return "seller: \n" + "id = " + id + "\n" + "name = " + name + "\n" + "email = " + email + "\n" + "date = "
				+ date + "\n" + "baseSalary = " + String.format("%.2f", baseSalary) + "\n\n" + dept;
	}

}
