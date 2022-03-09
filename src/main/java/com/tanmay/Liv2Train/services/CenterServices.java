package com.tanmay.Liv2Train.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanmay.Liv2Train.dto.Address;
import com.tanmay.Liv2Train.dto.CenterDto;
import com.tanmay.Liv2Train.models.Center;
import com.tanmay.Liv2Train.repositories.CenterRepository;
import com.tanmay.Liv2Train.response.CenterResponse;

@Service
public class CenterServices {
	@Autowired
	private CenterRepository centerRepo;
	
	public CenterResponse getCenter() {
		CenterResponse resp = new CenterResponse();
		List<Center> list = new ArrayList();
		list = centerRepo.findAll();
		resp.setCenter(list);
		resp.setSuccess(true);
		return resp;
	}

	public CenterResponse  saveCenter(CenterDto centerDto) {
		Center center = new Center();
		String temp1 = validateUser(centerDto);
		CenterResponse resp = new CenterResponse();
		if (temp1.equals("valid")) {
			center.setAddress(centerDto.getAddress());
			center.setCenterName(centerDto.getCenterName());
			center.setCenterCode(centerDto.getCenterCode());
			center.setStudentCapacity(centerDto.getStudentCapacity());
			center.setCoursesOffered(centerDto.getCoursesOffered());
			center.setContactPhone(centerDto.getContactPhone());
			center.setContactEmail(centerDto.getContactEmail());
			long currentTimestamp = System.currentTimeMillis();
			String temp = String.valueOf(currentTimestamp);
			center.setCreatedOn(currentTimestamp);
			centerRepo.save(center);
			List<Center> list = new ArrayList();
			list.add(center);
			resp.setCenter(list);
			resp.setSuccess(true);
			return resp;
		}
		resp.setSuccess(false);
		resp.setResponsemsg(temp1);
		return resp;
	}

	public String validateUser(CenterDto centerDto) {
		if (centerDto.getCenterCode().length() != 12 || centerDto.getCenterCode().isEmpty()) {
			return "invalid center code";
		} else if (centerDto.getCenterName().length() >= 40 || centerDto.getCenterName().isEmpty()) {
			return "invalid name";
		} 
		else if (isValidAddress(centerDto.getAddress())) {
			return "invalid address";
		}
	    else if (centerDto.getStudentCapacity().isEmpty()) {
			return "invalid student capacity";
		} else if (centerDto.getCoursesOffered().isEmpty()) {
			return "invalid courses offered";
		} else if (centerDto.getContactPhone().length() != 10) {
			return "invalid phone nu.";
		} else if (isValid(centerDto.getContactEmail())) {
			return "invalid email";
		}
		return "valid";
	}

	public static boolean isValidAddress(Address address) {
		if(address.getCity().isEmpty()||address.getCity()==null) {
			return true;
		}else if(address.getDetailedAddress().isEmpty()||address.getDetailedAddress()==null) {
			return true;
		}else if(address.getPinCode().isEmpty()||address.getPinCode()==null) {
			return true;
		}else if(address.getState().isEmpty()||address.getState()==null) {
			return true;
		}
			
		return false;
	}

	public static boolean isValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
