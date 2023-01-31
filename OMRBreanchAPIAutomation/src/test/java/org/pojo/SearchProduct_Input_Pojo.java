package org.pojo;
/**
 * 
 * @author manoj
 * @description User can maintain the input parameters for search product
 * @date 26-09-2022
 *
 */
public class SearchProduct_Input_Pojo {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SearchProduct_Input_Pojo(String text) {
		super();
		this.text = text;
	}
	
	
	
}
