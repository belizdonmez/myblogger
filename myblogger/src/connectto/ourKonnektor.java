package connectto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ourKonnektor {
	ArrayList<datamodel> dataContainer;
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


	public ourKonnektor() {
		
		dataContainer=new ArrayList<datamodel>();
		try{
		Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                        .getConnection("jdbc:mysql://localhost/myblog?"
                                        + "user=root");
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
	}
	public void insertItem(String topic, String content)
	{
		 PreparedStatement preparedStatement = null;
		  try {
			preparedStatement = connect
			          .prepareStatement("insert into myblog values (default, ?, ?)");
			 preparedStatement.setString(1, topic);
			 preparedStatement.setString(2, content);
			 preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//insertitem
	public ArrayList<datamodel> getitems()
	{
		ArrayList<datamodel>dummy=new ArrayList<datamodel>();
		PreparedStatement preparedStatement2;
		try {
			preparedStatement2 = connect
			          .prepareStatement("select * from myblog");
			ResultSet results=preparedStatement2.executeQuery();
			while(results.next())
			{
				datamodel d=new datamodel();
				d.setTopic(results.getString("topic"));
				d.setContent(results.getString("content"));
				dummy.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dummy;
		
		
	}
}
