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

		    // ② 데이터베이스 connection 
		    conn=DriverManager.getConnection(url,"scott","tiger"); 
		    // ③ 쿼리(sql)문장을 실행하기 위한 객체 생성
		  
		    pstmt=conn.prepareStatement(sql);
		    // ④ 쿼리 실행

		    rs=pstmt.executeQuery();
		    // ⑤ 쿼리 실행의 결과값(int, ResultSet) 사용
		   
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