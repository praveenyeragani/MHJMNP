package org.milkandpaper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "papersubscription"/*, catalog = "spring_social_db"*/)
public class PaperSubscription {
	
	@Id @GeneratedValue
	@Column(name = "paperid", unique = true, nullable = false)
	private int paperid;
	
	
	public int getId() {
		return paperid;
	}

	public void setId(int paperid) {
		this.paperid = paperid;
	}

	@Column(name = "papername", /*unique = true,*/ nullable = false, length = 45)
	private String papername;

	
	public String getPapername() {
		return papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
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
}
