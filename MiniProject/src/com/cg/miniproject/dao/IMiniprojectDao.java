package com.cg.miniproject.dao;

import java.util.ArrayList;

import com.cg.miniproject.bean.MacBean;
import com.cg.miniproject.bean.MiniprojectBean;

public interface IMiniprojectDao {

	int insertData(MiniprojectBean bean);

	String getProgramId();


	ArrayList<MacBean> allLogin(MacBean mac);

	ArrayList<MacBean> adminLogin(MacBean mac);

	String getId(String id);

	ArrayList<String> retrieveDetails();
}
