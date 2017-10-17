package com.cg.miniproject.service;

import java.util.ArrayList;

import com.cg.miniproject.bean.MacBean;
import com.cg.miniproject.bean.MiniprojectBean;

public interface IMiniprojectService {

	int insertData(MiniprojectBean bean);

	String getProgramId();

	boolean checkLogin(MacBean mac);

	boolean checkAdminLogin(MacBean mac);

	String getId(String string);

	ArrayList<String> retrieveDetails();

	//boolean validateUser(ArrayList<MacBean> list);

}
