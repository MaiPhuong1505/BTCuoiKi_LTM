package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.History;

public class History_DAO {

	public ArrayList<History> getHistory(int id) {
		String sql = "select * from ck_ltm.history where id=?";

		try (PreparedStatement statement = createConnection().prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			ArrayList<History> res = new ArrayList<History>();
			while (result.next()) {
				int function = result.getInt(2);
				int input = result.getInt(3);
				int input2 = result.getInt(4);
				String output = result.getString(5);
				History h = new History(function, input, input2, output);
				res.add(h);
			}
			return res;

		} catch (Exception e) {
			System.out.println("Fail1");
		}
		return null;
	}

	public boolean addHistory1(int id, int function, int input) {
		String sql = "INSERT INTO ck_ltm.history (id, `function`, input, input2) VALUES (?,?,?,0)";

		try (PreparedStatement statement = createConnection().prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.setInt(2, function);
			statement.setInt(3, input);
			int r = statement.executeUpdate();
			if(r > 0)
				return true;
		} catch (Exception e) {
			System.out.println("addHis 1" + e);
		}
		return false;
	}

	public boolean addHistory2(int id, int function, int input, int input2) {
		String sql = "INSERT INTO ck_ltm.history (id, `function`, input, input2) VALUES (?,?,?,?)";

		try (PreparedStatement statement = createConnection().prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.setInt(2, function);
			statement.setInt(3, input);
			statement.setInt(4, input2);
			int r = statement.executeUpdate();
			if (r > 0)
				return true;
		} catch (Exception e) {
			System.out.println("addHis2 "+ e);
		}
		return false;
	}

	public boolean setResult1(int id, int function, int input,String output) {
		String sql = "update ck_ltm.history set output = ? where (id,`function`,input)  = (?,?,?)";

		try (PreparedStatement statement = createConnection().prepareStatement(sql)) {
			statement.setString(1, output);
			statement.setInt(2, id);
			statement.setInt(3, function);
			statement.setInt(4, input);
			int r = statement.executeUpdate();
			if(r > 0)
				return true;
		} catch (Exception e) {
			System.out.println("Fail2");
		}
		return false;
	}

	public boolean setResult2(int id, int function, int input, int input2, String output) {
		String sql = "update ck_ltm.history set output = ? where (id,`function`,input,input2)  = (?,?,?,?)";

		try (PreparedStatement statement = createConnection().prepareStatement(sql)) {
			statement.setString(1, output);
			statement.setInt(2, id);
			statement.setInt(3, function);
			statement.setInt(4, input);
			statement.setInt(5, input2);
			int r = statement.executeUpdate();
			if(r > 0)
				return true;
		} catch (Exception e) {
			System.out.println("set res 2 :" + e);
		}
		return false;
	}
	public boolean deleteHistory(int id, int input, int input2) {
		String sql = "delete from ck_ltm.history where id=? and (input = ? and input2 = ?)";
		try (PreparedStatement statement = createConnection().prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.setInt(2, input);
			statement.setInt(3, input2);
			int r = statement.executeUpdate();
			if(r > 0)
				return true;
		} catch (Exception e) {
			System.out.println("set res 2 :" + e);
		}
		return false;
	}
	private Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:6033/ck_ltm", "root", "matkhausql1@");
		} catch (Exception e) {
			System.out.println("Create connect: " + e);
			return null;
		}
	}

}