package com.programmingfree.springservice.domain;

import java.io.Serializable;

public class PodsAddress implements Serializable{
	
	private String Rawaddr_id;
	private String Rawaddr_hash_ky;
	private String Location_nm;
	private String Location_addr1_tx;
	private String Location_addr2_tx;
	private String Location_city_nm;
	private String Location_state_cd;
	private String Location_zip_cd;	
	private String Location_country_cd;
	private String Location_state_nm;
	private String Location_contact_nm;
	private String Location_phone_nr;
	
	public String getRawaddr_id() {
		return Rawaddr_id;
	}
	public void setRawaddr_id(String rawaddr_id) {
		Rawaddr_id = rawaddr_id;
	}
	public String getRawaddr_hash_ky() {
		return Rawaddr_hash_ky;
	}
	public void setRawaddr_hash_ky(String rawaddr_hash_ky) {
		Rawaddr_hash_ky = rawaddr_hash_ky;
	}
	public String getLocation_nm() {
		return Location_nm;
	}
	public void setLocation_nm(String location_nm) {
		Location_nm = location_nm;
	}
	public String getLocation_addr1_tx() {
		return Location_addr1_tx;
	}
	public void setLocation_addr1_tx(String location_addr1_tx) {
		Location_addr1_tx = location_addr1_tx;
	}
	public String getLocation_addr2_tx() {
		return Location_addr2_tx;
	}
	public void setLocation_addr2_tx(String location_addr2_tx) {
		Location_addr2_tx = location_addr2_tx;
	}
	public String getLocation_city_nm() {
		return Location_city_nm;
	}
	public void setLocation_city_nm(String location_city_nm) {
		Location_city_nm = location_city_nm;
	}
	public String getLocation_state_cd() {
		return Location_state_cd;
	}
	public void setLocation_state_cd(String location_state_cd) {
		Location_state_cd = location_state_cd;
	}
	public String getLocation_zip_cd() {
		return Location_zip_cd;
	}
	public void setLocation_zip_cd(String location_zip_cd) {
		Location_zip_cd = location_zip_cd;
	}
	public String getLocation_country_cd() {
		return Location_country_cd;
	}
	public void setLocation_country_cd(String location_country_cd) {
		Location_country_cd = location_country_cd;
	}
	public String getLocation_state_nm() {
		return Location_state_nm;
	}
	public void setLocation_state_nm(String location_state_nm) {
		Location_state_nm = location_state_nm;
	}
	public String getLocation_contact_nm() {
		return Location_contact_nm;
	}
	public void setLocation_contact_nm(String location_contact_nm) {
		Location_contact_nm = location_contact_nm;
	}
	public String getLocation_phone_nr() {
		return Location_phone_nr;
	}
	public void setLocation_phone_nr(String location_phone_nr) {
		Location_phone_nr = location_phone_nr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Location_addr1_tx == null) ? 0 : Location_addr1_tx.hashCode());
		result = prime * result + ((Location_addr2_tx == null) ? 0 : Location_addr2_tx.hashCode());
		result = prime * result + ((Location_city_nm == null) ? 0 : Location_city_nm.hashCode());
		result = prime * result + ((Location_contact_nm == null) ? 0 : Location_contact_nm.hashCode());
		result = prime * result + ((Location_country_cd == null) ? 0 : Location_country_cd.hashCode());
		result = prime * result + ((Location_nm == null) ? 0 : Location_nm.hashCode());
		result = prime * result + ((Location_phone_nr == null) ? 0 : Location_phone_nr.hashCode());
		result = prime * result + ((Location_state_cd == null) ? 0 : Location_state_cd.hashCode());
		result = prime * result + ((Location_state_nm == null) ? 0 : Location_state_nm.hashCode());
		result = prime * result + ((Location_zip_cd == null) ? 0 : Location_zip_cd.hashCode());
		result = prime * result + ((Rawaddr_hash_ky == null) ? 0 : Rawaddr_hash_ky.hashCode());
		result = prime * result + ((Rawaddr_id == null) ? 0 : Rawaddr_id.hashCode());
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
		PodsAddress other = (PodsAddress) obj;
		if (Location_addr1_tx == null) {
			if (other.Location_addr1_tx != null)
				return false;
		} else if (!Location_addr1_tx.equals(other.Location_addr1_tx))
			return false;
		if (Location_addr2_tx == null) {
			if (other.Location_addr2_tx != null)
				return false;
		} else if (!Location_addr2_tx.equals(other.Location_addr2_tx))
			return false;
		if (Location_city_nm == null) {
			if (other.Location_city_nm != null)
				return false;
		} else if (!Location_city_nm.equals(other.Location_city_nm))
			return false;
		if (Location_contact_nm == null) {
			if (other.Location_contact_nm != null)
				return false;
		} else if (!Location_contact_nm.equals(other.Location_contact_nm))
			return false;
		if (Location_country_cd == null) {
			if (other.Location_country_cd != null)
				return false;
		} else if (!Location_country_cd.equals(other.Location_country_cd))
			return false;
		if (Location_nm == null) {
			if (other.Location_nm != null)
				return false;
		} else if (!Location_nm.equals(other.Location_nm))
			return false;
		if (Location_phone_nr == null) {
			if (other.Location_phone_nr != null)
				return false;
		} else if (!Location_phone_nr.equals(other.Location_phone_nr))
			return false;
		if (Location_state_cd == null) {
			if (other.Location_state_cd != null)
				return false;
		} else if (!Location_state_cd.equals(other.Location_state_cd))
			return false;
		if (Location_state_nm == null) {
			if (other.Location_state_nm != null)
				return false;
		} else if (!Location_state_nm.equals(other.Location_state_nm))
			return false;
		if (Location_zip_cd == null) {
			if (other.Location_zip_cd != null)
				return false;
		} else if (!Location_zip_cd.equals(other.Location_zip_cd))
			return false;
		if (Rawaddr_hash_ky == null) {
			if (other.Rawaddr_hash_ky != null)
				return false;
		} else if (!Rawaddr_hash_ky.equals(other.Rawaddr_hash_ky))
			return false;
		if (Rawaddr_id == null) {
			if (other.Rawaddr_id != null)
				return false;
		} else if (!Rawaddr_id.equals(other.Rawaddr_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SerialNumber [Rawaddr_id=" + Rawaddr_id + ", Rawaddr_hash_ky=" + Rawaddr_hash_ky + ", Location_nm="
				+ Location_nm + ", Location_addr1_tx=" + Location_addr1_tx + ", Location_addr2_tx=" + Location_addr2_tx
				+ ", Location_city_nm=" + Location_city_nm + ", Location_state_cd=" + Location_state_cd
				+ ", Location_zip_cd=" + Location_zip_cd + ", Location_country_cd=" + Location_country_cd
				+ ", Location_state_nm=" + Location_state_nm + ", Location_contact_nm=" + Location_contact_nm
				+ ", Location_phone_nr=" + Location_phone_nr + "]";
	}
	
	
	

}
