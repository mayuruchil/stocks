package com.chase.product.config;

public class AppConstants {
	
	public enum  Exchange { 
		lse("london", "london-stock-exchange"), 
		nyse("newYork", "new-york-stock-exchange"), 
		nse("india", "national-stock-exchange") ;
		
		// declaring private variable for getting values 
	    private String countryName;
	    private String registeredServiceName;
	  
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
