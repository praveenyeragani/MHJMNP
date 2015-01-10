package org.milkandpaper.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "subscription"/*, catalog = "spring_social_db" */)
public class Subscription {
	
	
	
	
//	@ManyToOne
	public MilkSubscription milksub;
	
	@Transient
	public MilkSubscription getMilksub() {
		return milksub;
	}

	public void setMilksub(MilkSubscription milksub) {
		this.milksub = milksub;
	}

//	@ManyToOne
	public PaperSubscription papersub;
	@Transient
	public PaperSubscription getPapersub() {
		return papersub;
	}

	public void setPapersub(PaperSubscription papersub) {
		this.papersub = papersub;
	}
	
	

	

}
