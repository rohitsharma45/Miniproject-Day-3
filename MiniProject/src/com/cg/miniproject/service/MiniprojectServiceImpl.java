package com.cg.miniproject.service;

import java.util.ArrayList;

import com.cg.miniproject.bean.MacBean;
import com.cg.miniproject.bean.MiniprojectBean;
import com.cg.miniproject.dao.IMiniprojectDao;
import com.cg.miniproject.dao.MiniprojectDaoImpl;

public class MiniprojectServiceImpl implements IMiniprojectService {

	IMiniprojectDao dao=null;
	public int insertData(MiniprojectBean bean) {
		 dao=new MiniprojectDaoImpl();
		return dao.insertData(bean);
	}
	public String getProgramId() {
		dao=new MiniprojectDaoImpl();
			return dao.getProgramId();
	}
	@Override
	public boolean checkLogin(MacBean mac) {
		dao=new MiniprojectDaoImpl();
		ArrayList<MacBean> list = null;
		list = dao.allLogin(mac);
		
		int flag = 0;
		for(MacBean b:list)
		{
		
			if((b.getLoginId().equals(mac.getLoginId())) && (b.getPassword().equals(mac.getPassword()))){
				flag = 1;
				break;
			}
				
		}
		
		if(flag == 1){
			return true;
		}
		else return false;
		
	}
	@Override
	public boolean checkAdminLogin(MacBean mac) {
		dao=new MiniprojectDaoImpl();
		ArrayList<MacBean> list = null;
		list = dao.adminLogin(mac);
		
		int flag = 0;
		for(MacBean b:list)
		{
			//System.out.println(b);
			
			if((b.getLoginId().equals(mac.getLoginId())) && (b.getPassword().equals(mac.getPassword()))){
				flag = 1;
				break;
			}
				
		}
		
		if(flag == 1){
			return true;
		}
		else return false;
		
	
	}
	@Override
	public String getId(String id) {
		// TODO Auto-generated method stub
		dao=new MiniprojectDaoImpl();
		return dao.getId(id);
	}
	@Override
	public ArrayList<String> retrieveDetails() {
		dao=new MiniprojectDaoImpl();
		return dao.retrieveDetails();
	}

}

