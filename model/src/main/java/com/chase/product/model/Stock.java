package com.chase.product.model;

import java.math.BigDecimal;
import java.util.Date;

public class Stock {
	
	private int stockID;
	private String stockName;
	private BigDecimal stockPrice;
	private Date currentDate;
	private String stockExchangeName;
	
	public Stock(int stockID, String stockName, String stockExchangeName, BigDecimal stockPrice, Date currentDate) {
		super();
		this.stockID = stockID;
		this.stockName = stockName;
		this.stockPrice = stockPrice;
		this.currentDate = currentDate;
		this.stockExchangeName = stockExchangeName;
	}
	public Stock(){}
	
	public int getStockID() {
		return stockID;
	}
	
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public BigDecimal getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public String getStockExchangeName() {
		return stockExchangeName;
	}
	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentDate == null) ? 0 : currentDate.hashCode());
		result = prime * result + ((stockExchangeName == null) ? 0 : stockExchangeName.hashCode());
		result = prime * result + stockID;
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + ((stockPrice == null) ? 0 : stockPrice.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (currentDate == null) {
			if (other.currentDate != null)
				return false;
		} else if (!currentDate.equals(other.currentDate))
			return false;
		if (stockExchangeName == null) {
			if (other.stockExchangeName != null)
				return false;
		} else if (!stockExchangeName.equals(other.stockExchangeName))
			return false;
		if (stockID != other.stockID)
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (stockPrice == null) {
			if (other.stockPrice != null)
				return false;
		} else if (!stockPrice.equals(other.stockPrice))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [stockID=").append(stockID).append(", stockName=").append(stockName)
				.append(", stockPrice=").append(stockPrice).append(", currentDate=").append(currentDate)
				.append(", stockExchangeName=").append(stockExchangeName).append("]");
		return builder.toString();
	}
	
}
