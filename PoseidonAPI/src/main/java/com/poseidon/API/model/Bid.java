package com.poseidon.API.model;


import java.sql.Timestamp;
import java.util.Objects;

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
	
	

	public Bid(int id, String account, String type, double bidQuantity, double askQuantity, double bid, double ask,
			String benchmark, Timestamp bidDate, String commentary, String security, String status, String trader,
			String book, String creationName, Timestamp creationDate, String revisionName, Timestamp revisionDate,
			String dealName, String dealType, String sourceListId, String side) {
		super();
		this.id = id;
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
		this.askQuantity = askQuantity;
		this.bid = bid;
		this.ask = ask;
		this.benchmark = benchmark;
		this.bidDate = bidDate;
		this.commentary = commentary;
		this.security = security;
		this.status = status;
		this.trader = trader;
		this.book = book;
		this.creationName = creationName;
		this.creationDate = creationDate;
		this.revisionName = revisionName;
		this.revisionDate = revisionDate;
		this.dealName = dealName;
		this.dealType = dealType;
		this.sourceListId = sourceListId;
		this.side = side;
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

	@Override
	public String toString() {
		return "BidList [Id=" + id + ", account=" + account + ", type=" + type + ", bidQuantity="
				+ bidQuantity + ", askQuantity=" + askQuantity + ", bid=" + bid + ", ask=" + ask + ", benchmark="
				+ benchmark + ", bidDate=" + bidDate + ", commentary=" + commentary + ", security=" + security
				+ ", status=" + status + ", trader=" + trader + ", book=" + book + ", creationName=" + creationName
				+ ", creationDate=" + creationDate + ", revisionName=" + revisionName + ", revisionDate=" + revisionDate
				+ ", dealName=" + dealName + ", dealType=" + dealType + ", sourceListId=" + sourceListId + ", side="
				+ side + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, ask, askQuantity, benchmark, bid, bidDate, id, bidQuantity, book,
				commentary, creationDate, creationName, dealName, dealType, revisionDate, revisionName, security, side,
				sourceListId, status, trader, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		return Objects.equals(account, other.account)
				&& Double.doubleToLongBits(ask) == Double.doubleToLongBits(other.ask)
				&& Double.doubleToLongBits(askQuantity) == Double.doubleToLongBits(other.askQuantity)
				&& Objects.equals(benchmark, other.benchmark)
				&& Double.doubleToLongBits(bid) == Double.doubleToLongBits(other.bid)
				&& Objects.equals(bidDate, other.bidDate) && id == other.id
				&& Double.doubleToLongBits(bidQuantity) == Double.doubleToLongBits(other.bidQuantity)
				&& Objects.equals(book, other.book) && Objects.equals(commentary, other.commentary)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(creationName, other.creationName)
				&& Objects.equals(dealName, other.dealName) && Objects.equals(dealType, other.dealType)
				&& Objects.equals(revisionDate, other.revisionDate) && Objects.equals(revisionName, other.revisionName)
				&& Objects.equals(security, other.security) && Objects.equals(side, other.side)
				&& Objects.equals(sourceListId, other.sourceListId) && Objects.equals(status, other.status)
				&& Objects.equals(trader, other.trader) && Objects.equals(type, other.type);
	}
	
	
	

	
}
