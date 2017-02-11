package fr.epita.basnet.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.epita.basnet.datamodel.User_Identity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * this class is responsible to all data action with database
 * @author basnet
 *
 */
public class Dao {

	
	private Connection Concurrent;
	 
	/**
	 * this method is to establish the connection with derby databse through the jdbc
	 * @return connection 
	 * @throws SQLException
	 */
	private Connection getconnection() throws SQLException
	{
		String user="rohit";
		String pass="basnet";
		String connectionString = "jdbc:derby://localhost:1527/iam;create=true";
		this.Concurrent= DriverManager.getConnection(connectionString, user, pass);
		return this.Concurrent;
	}

   /**
    * this showall method get the all data from tbluser table 
    * @return it returns list where all the data are store
    * @throws SQLException
    */
	public ObservableList<User_Identity> ShowAll() throws SQLException {
		ObservableList<User_Identity>data;
		data=FXCollections.observableArrayList();
		Connection con=getconnection();
		String qry="select * from TUSER";
		PreparedStatement st=null;
		st=con.prepareStatement(qry);
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			data.add(new User_Identity(
			        
					rs.getString("fullname"),
				    
					rs.getLong("contact_no"),
					
					rs.getString("email"),
					rs.getInt("age"),
					rs.getInt("id")
					
					));
		}
		
		return data;
		
	}

/**
 * this insert method is to insert the data into tbluser
 * 
 * @param identity 
 * @throws SQLException
 */
	public void Insert(User_Identity identity) throws SQLException {
		Connection con=getconnection();
        String qry="Insert into TUSER(AGE,EMAIL,CONTACT_NO,FULLNAME,ID)values(?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(qry);
       st.setInt(1,identity.getAge());
       st.setString(2, identity.getEmail());
       st.setLong(3, identity.getNumber());
       st.setString(4, identity.getName());
       st.setInt(5,identity.getId());
       st.execute();
       
		
	}

/**
 * delet method is simply to delete the row from tbluser that user want
 * which delete row with the id
 * @param identity
 * @throws SQLException
 */
	public void delete(User_Identity identity) throws SQLException {
		Connection con=getconnection();
		String qry="DELETE FROM TUSER WHERE ID=?";
		PreparedStatement st=con.prepareStatement(qry);
		st.setInt(1, identity.getId());
		st.execute();
		
	}

/**
 * Update method is to update the user desire row from tbluser
 * with id 
 * @param identity
 * @throws SQLException
 */
	public void Update(User_Identity identity) throws SQLException {
		Connection con=getconnection();
		String qry="UPDATE TUSER SET AGE=?,EMAIL=?,CONTACT_NO=?,FULLNAME=? WHERE ID=? ";
		PreparedStatement st=con.prepareStatement(qry);
		st.setInt(1, identity.getAge());
		st.setString(2, identity.getEmail());
		st.setLong(3, identity.getNumber());
		st.setString(4, identity.getName());
		st.setInt(5, identity.getId());
		st.execute();
		
		
	}
	




	
	
	 
	
	
	
}
