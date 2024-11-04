package GSach;

import java.sql.Connection;
import java.util.ArrayList;

public interface ISach {
	public Connection getCon();
	public ArrayList getSA();
	public ArrayList getSAbyNXBGB(String Nhaxb, float Gia);
}
