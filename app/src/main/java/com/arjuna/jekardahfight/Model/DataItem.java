package com.arjuna.jekardahfight.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DataItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("lng")
	private double lng;

	@SerializedName("phone")
	private String phone;

	@SerializedName("login_terakhir")
	private String loginTerakhir;

	@SerializedName("jabatan")
	private String jabatan;

	@SerializedName("wilayah")
	private String wilayah;

	@SerializedName("userid")
	private int userid;

	@SerializedName("lat")
	private double lat;

	@SerializedName("alamat")
	private String alamat;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setLoginTerakhir(String loginTerakhir){
		this.loginTerakhir = loginTerakhir;
	}

	public String getLoginTerakhir(){
		return loginTerakhir;
	}

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	public void setWilayah(String wilayah){
		this.wilayah = wilayah;
	}

	public String getWilayah(){
		return wilayah;
	}

	public void setUserid(int userid){
		this.userid = userid;
	}

	public int getUserid(){
		return userid;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"nama = '" + nama + '\'' + 
			",lng = '" + lng + '\'' + 
			",phone = '" + phone + '\'' + 
			",login_terakhir = '" + loginTerakhir + '\'' + 
			",jabatan = '" + jabatan + '\'' + 
			",wilayah = '" + wilayah + '\'' + 
			",userid = '" + userid + '\'' + 
			",lat = '" + lat + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}