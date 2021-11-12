package com.poseidon.API.model;


import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "bids")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String account;
	private String type;
	@Column(name = "bid_quantity")
	private double bidQuantity;
	@Column(name = "ask_quantity")
	private double askQuantity;
	private double bid;
	private double ask;
	private String benchmark;
	@Column(name = "bid_date")
	private Timestamp bidDate;
	private String commentary;
	private String security;
	private String status;
	private String trader;
	private String book;
	@Column(name = "creation_name")
	private String creationName;
	@Column(name = "creation_date")
	private Timestamp creationDate;
	@Column(name = "revision_name")
	private String revisionName;
	@Column(name = "revision_date")
	private Timestamp revisionDate;
	@Column(name = "deal_name")
	private String dealName;
	@Column(name = "deal_type")
	private String dealType;
	@Column(name = "source_list_id")
	private String sourceListId;
	private String side;
	
	public Bid() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBidQuantity() {
		return bidQuantity;
	}

	public void setBidQuantity(double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}

	public double getAskQuantity() {
		return askQuantity;
	}

	public void setAskQuantity(double askQuantity) {
		this.askQuantity = askQuantity;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public String getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public Timestamp getBidDate() {
		return bidDate;
	}

	public void setBidDate(Timestamp bidDate) {
		this.bidDate = bidDate;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getCreationName() {
		return creationName;
	}

	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getRevisionName() {
		return revisionName;
	}

	public void setRevisionName(String revisionName) {
		this.revisionName = revisionName;
	}

	public Timestamp getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(Timestamp revisionDate) {
		this.revisionDate = revisionDate;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getSourceListId() {
		return sourceListId;
	}

	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}
}
