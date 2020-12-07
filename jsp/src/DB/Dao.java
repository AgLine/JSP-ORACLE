package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DTO;

public class Dao {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";  
	String sql = "select ename, job from emp ";

	Connection conn;

	PreparedStatement pstmt;

	ResultSet rs;
	List<DTO> dto = new ArrayList<>();
	DTO dt;
	
	@SuppressWarnings("unchecked")
	public List<DTO> selectid() throws ClassNotFoundException, SQLException {
			
		 Class.forName(driver);

		    // �� �����ͺ��̽� connection 
		    conn=DriverManager.getConnection(url,"scott","tiger"); 
		    // �� ����(sql)������ �����ϱ� ���� ��ü ����
		  
		    pstmt=conn.prepareStatement(sql);
		    // �� ���� ����

		    rs=pstmt.executeQuery();
		    // �� ���� ������ �����(int, ResultSet) ���
		   
		    while(rs.next()){
		    	
		    	dt = new DTO();
		    	
		    	dt.setEname(rs.getString("ename"));
		    	dt.setJob(rs.getString("job"));
		    	
		    	dto.add(dt);
		    }
		   
		    rs.close();
		    pstmt.close();
		    conn.close();
		    
			return dto;
	}
}