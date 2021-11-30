package model.bo;

import model.dao.Account_DAO;

public class Account_BO {
	Account_DAO account_DAO = new Account_DAO();
	
	public int getID(String username, String password) {
		return account_DAO.getID(username, password);
	}
}
