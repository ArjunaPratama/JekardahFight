package com.arjuna.jekardahfight.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseJakFight{

	@SerializedName("Dinas")
	private String dinas;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("count")
	private int count;

	@SerializedName("status")
	private String status;

	public void setDinas(String dinas){
		this.dinas = dinas;
	}

	public String getDinas(){
		return dinas;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseJakFight{" + 
			"dinas = '" + dinas + '\'' + 
			",data = '" + data + '\'' + 
			",count = '" + count + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}