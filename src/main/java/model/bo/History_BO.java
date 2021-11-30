package model.bo;

import java.util.ArrayList;

import model.bean.History;
import model.dao.History_DAO;

public class History_BO {
	History_DAO history_dao = new History_DAO();
	
	public ArrayList<History> getAllHistory(int id){
		return history_dao.getHistory(id);
	}
	
	public boolean addHistory(int id, int function, int input, int input2)
	{
		switch (function) {
		case 1: 
			return history_dao.addHistory1(id, function, input);
		case 2:
			return history_dao.addHistory2(id, function, input, input2);
	}
		return false;
	}
	
	public boolean setResult(int id, int function, int input, int input2, String output) {
		switch (function) {
			case 1: 
				return history_dao.setResult1(id, function, input, output);
			case 2:
				return history_dao.setResult2(id, function, input, input2, output);
		}
		return false;
	}
	public boolean deleteHistory(int id, int input, int input2) {
		return history_dao.deleteHistory(id, input, input2);
	}
}
