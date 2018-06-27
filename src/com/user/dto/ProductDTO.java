package com.user.dto;

import java.io.Serializable;
import java.util.Date;



public class ProductDTO implements Serializable{
	
		private int prodId;
		private String prodName;
		private int prodPrice;
		private Date orderedDate;     
                                                   
		
		public int getProdId() {
			return prodId;
		}
		public void setProdId(int prodId) {
			this.prodId = prodId;
		}

		
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		public int getProdPrice() {
			return prodPrice;
		}
		public void setProdPrice(int prodPrice) {
			this.prodPrice = prodPrice;
		}

		
		public Date getOrderedDate() {
			return orderedDate;
		}
		public void setOrderedDate(Date orderedDate) {
			this.orderedDate = orderedDate;
		}

}
