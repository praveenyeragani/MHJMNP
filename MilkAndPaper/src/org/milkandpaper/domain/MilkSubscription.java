package org.milkandpaper.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "milksubscription"/*, catalog = "spring_social_db"*/)
public class MilkSubscription {

	@Id @GeneratedValue
	@Column(name = "milkid", unique = true, nullable = false)
	private int milkid;
	
	public int getMilkid() {
		return milkid;
	}

	public void setMilkid(int milkid) {
		this.milkid = milkid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	private Users user;
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Column(name = "milkname", /*unique = true,*/ nullable = false, length = 45)
	private String milkname;
	
	public String getMilkname() {
		return milkname;
	}

	public void setMilkname(String milkname) {
		this.milkname = milkname;
	}

	@Column(name = "quantity", /*unique = true,*/ nullable = false, length = 45)
	private String quantity;
	

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
	

}
