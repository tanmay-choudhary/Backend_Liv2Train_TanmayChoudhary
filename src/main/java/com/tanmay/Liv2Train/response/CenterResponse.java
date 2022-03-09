package com.tanmay.Liv2Train.response;
import java.util.List;

import com.tanmay.Liv2Train.models.Center;

public class CenterResponse {

	private List<Center> center;
	private boolean success;
	private String responsemsg;
	
	public List<Center> getCenter() {
		return center;
	}
	public void setCenter(List<Center> center) {
		this.center = center;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getResponsemsg() {
		return responsemsg;
	}
	public void setResponsemsg(String responsemsg) {
		this.responsemsg = responsemsg;
	}
	
}
