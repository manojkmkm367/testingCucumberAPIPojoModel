package org.pojo;

import java.util.ArrayList;

/**
 * 
 * @author manoj
 * @description User can maintain the output parameters for getting search product response  
 * @date 26-09-2022
 *
 */

public class SearchProduct_Output_Pojo {
    private int status;
    private String message;
    private ArrayList<SearchDatum> data;
    private String currency;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<SearchDatum> getData() {
		return data;
	}
	public void setData(ArrayList<SearchDatum> data) {
		this.data = data;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
    

}
