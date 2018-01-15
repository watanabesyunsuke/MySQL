package graphm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	// JDBCドライバの登録
    String driver;
    // データベースの指定
    String server, dbname, url, user, password;
    Connection con;
    Statement stmt;
    ResultSet rs;

  public MySQL() {    
    this.driver  = "org.gjt.mm.mysql.Driver";
    this.server  = "ms000.sist.ac.jp";      // MySQLサーバ ( IP または ホスト名 );
    this.dbname  = "java2017";         // データベース名;
    this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
    this.user = "java2017";         // データベース作成ユーザ名;
    this.password  = "java2017";     // データベース作成ユーザパスワード;
  
    try {
		this.con = DriverManager.getConnection(url, user, password);
		this.stmt = con.createStatement ();	
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void close() {
	  try {
		  rs.close();
		  stmt.close();
		  con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public ResultSet selectAll() {
	  String sql = "SELECT * FROM `50616048`";
	  ResultSet rs = null;
	 
	  try {
		rs = stmt.executeQuery (sql);
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	  return rs;

  }
  
}