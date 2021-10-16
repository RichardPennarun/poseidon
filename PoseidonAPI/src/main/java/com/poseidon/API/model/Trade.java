package com.poseidon.API.model;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "trades")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String account;
	private String type;
	@Column(name = "buy_quantity")
	private double buyQuantity;
	@Column(name = "sell_quantity")
	private double sellQuantity;
	@Column(name = "buy_price")
	private double buyPrice;
	@Column(name = "sell_price")
	private double sellPrice;
	@Column(name = "trade_date")
	private Timestamp tradeDate;
	private String security;
	private String status;
	private String trader;
	private String benchmark;
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

	public Trade() {
	}

	public Trade(int id, String account, String type, double buyQuantity, double sellQuantity, double buyPrice,
			double sellPrice, Timestamp tradeDate, String security, String status, String trader, String benchmark,
			String book, String creationName, Timestamp creationDate, String revisionName, Timestamp revisionDate,
			String dealName, String dealType, String sourceListId, String side) {
		super();
		this.id = id;
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
		this.sellQuantity = sellQuantity;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.tradeDate = tradeDate;
		this.security = security;
		this.status = status;
		this.trader = trader;
		this.benchmark = benchmark;
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

	public double getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(double buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	public double getSellQuantity() {
		return sellQuantity;
	}

	public void setSellQuantity(double sellQuantity) {
		this.sellQuantity = sellQuantity;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Timestamp getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Timestamp tradeDate) {
		this.tradeDate = tradeDate;
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

	public String getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
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
		return "Trade [id=" + id + ", account=" + account + ", type=" + type + ", buyQuantity=" + buyQuantity
				+ ", sellQuantity=" + sellQuantity + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice
				+ ", tradeDate=" + tradeDate + ", security=" + security + ", status=" + status + ", trader=" + trader
				+ ", benchmark=" + benchmark + ", book=" + book + ", creationName=" + creationName + ", creationDate="
				+ creationDate + ", revisionName=" + revisionName + ", revisionDate=" + revisionDate + ", dealName="
				+ dealName + ", dealType=" + dealType + ", sourceListId=" + sourceListId + ", side=" + side + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, benchmark, book, buyPrice, buyQuantity, creationDate, creationName, dealName,
				dealType, id, revisionDate, revisionName, security, sellPrice, sellQuantity, side, sourceListId, status,
				tradeDate, trader, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return Objects.equals(account, other.account) && Objects.equals(benchmark, other.benchmark)
				&& Objects.equals(book, other.book)
				&& Double.doubleToLongBits(buyPrice) == Double.doubleToLongBits(other.buyPrice)
				&& Double.doubleToLongBits(buyQuantity) == Double.doubleToLongBits(other.buyQuantity)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(creationName, other.creationName)
				&& Objects.equals(dealName, other.dealName) && Objects.equals(dealType, other.dealType)
				&& id == other.id && Objects.equals(revisionDate, other.revisionDate)
				&& Objects.equals(revisionName, other.revisionName) && Objects.equals(security, other.security)
				&& Double.doubleToLongBits(sellPrice) == Double.doubleToLongBits(other.sellPrice)
				&& Double.doubleToLongBits(sellQuantity) == Double.doubleToLongBits(other.sellQuantity)
				&& Objects.equals(side, other.side) && Objects.equals(sourceListId, other.sourceListId)
				&& Objects.equals(status, other.status) && Objects.equals(tradeDate, other.tradeDate)
				&& Objects.equals(trader, other.trader) && Objects.equals(type, other.type);
	}

	
	
}
