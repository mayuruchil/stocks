package com.chase.product.service;

public class AppConstants {
	public enum  Exchange { 
		london("london", "london-stock-exchange"), 
		newYork("newYork", "new-york-stock-exchange"), 
		india("india", "national-stock-exchange") ;
		
		// declaring private variable for getting values 
	    String countryName;
	    String registeredServiceName;
	  
	    // getter method 
	    public String getRegisteredServiceName() 
	    { 
	        return this.registeredServiceName; 
	    } 
	    
	    public String getCountryName() 
	    { 
	        return this.countryName; 
	    }
	
		private Exchange(String countryName, String registeredServiceName ) 
	    { 
	        this.countryName = countryName; 
	        this.registeredServiceName = registeredServiceName;
	    } 
		
	}

}

