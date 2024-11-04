package GSach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class XLSach implements ISach {

	@Override
	public Connection getCon() {
		String url = "jdbc:sqlserver://ADMIN;databaseName=SACH;" +
	            "user=sa;password=1234567890;encrypt=true;trustServerCertificate=true";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connect = DriverManager.getConnection(url);
			return connect;
		}
		catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public ArrayList getSA() {
		ArrayList<Sach> listsach = new ArrayList();
		try {
			Connection connect = getCon();
			
			String sql = "select * from tbSach";
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				int mas = rs.getInt(1);
				String tens = rs.getString(2);
				String nhaxb = rs.getString(3);
				int namsx = rs.getInt(4);
				float gia = rs.getFloat(5);
				
				Sach newsach = new Sach(mas, tens, nhaxb, namsx, gia);
				listsach.add(newsach);
			}
			return listsach;
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList getSAbyNXBGB(String nhaXb, float Gia) {
		ArrayList<Sach> listsach = new ArrayList();
		try {
			Connection connect = getCon();
			
			String sql = "select * from tbSach where nhaxb = N'"+nhaXb+"' and giaban = " + Gia;
			Statement state = connect.createStatement();
			ResultSet rs = state.executeQuery(sql);
			
			while(rs.next()) {
				int mas = rs.getInt(1);
				String tens = rs.getString(2);
				String nhaxb = rs.getString(3);
				int namsx = rs.getInt(4);
				float gia = rs.getFloat(5);
				
				Sach newsach = new Sach(mas, tens, nhaxb, namsx, gia);
				listsach.add(newsach);
			}
			return listsach;
		}
		catch(Exception e) {
			return null;
		}
	}

}
