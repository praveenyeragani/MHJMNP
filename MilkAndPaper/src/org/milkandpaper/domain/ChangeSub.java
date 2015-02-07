package org.milkandpaper.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "change_subscription")
public class ChangeSub {
	
	@Id @GeneratedValue
	@Column(name = "change_sub_id", unique = true, nullable = false)
	private int changeSubId;
	
	public int getChangeSubId() {
		return changeSubId;
	}

	public void setChangeSubId(int changeSubId) {
		this.changeSubId = changeSubId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Users user;
	
	@Column(name="from_date",nullable = false)
	private Date from;
	
	@Column(name="to_date",nullable = false)
	private Date to;
	
	@Column(name="create_time")
	private Date createTime=new Date();
	
	@Column(name="update_time")
	private Date updateTime=new Date();
	
	@Column(name="stop_req_type",nullable = false)
	private String stopReqType;
	
	public String getStopReqType() {
		return stopReqType;
	}

	public void setStopReqType(String stopReqType) {
		this.stopReqType = stopReqType;
	}

	@Column(name="description",nullable = false)
	private String description;

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(String from) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
		Date date = formatter.parse(from);
		this.from = date;
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public Date getTo() {
		return to;
	}

	public void setTo(String to) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
		Date date = formatter.parse(to);
		this.to = date;
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
