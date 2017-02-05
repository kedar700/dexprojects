package model.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import model.Address;

public class AddressDAO  extends Dao{

	public Address getAddress(Integer userId){
		Address address = null; 
		try {
			String sql= "select * from addresses where user_Id = " + userId ;
			rs = executeFetchQuery(sql);			

			if (rs.next()){	
				address = new Address();
				address.setAddressId(Integer.parseInt(rs.getString("address_id")));
				address.setAddressline1(rs.getString("address_line1"));
				address.setAddressline2(rs.getString("address_line2"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));	
				address.setZip(rs.getString("zip_code"));
				address.setPhone(rs.getString("phone"));
				address.setUserId(rs.getInt("user_id"));
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return address;
	}

	public ArrayList<Address> getAllAddresses(){	
		Address address = null;
		ArrayList <Address> list = new ArrayList<Address>();
		try {
			String sql= "select * from addresses" ;
			rs = executeFetchQuery (sql);			

			while (rs.next()){	
				address =  new Address();
				address.setAddressId(Integer.parseInt(rs.getString("address_id")));
				address.setAddressline1(rs.getString("address_line1"));
				address.setAddressline2(rs.getString("address_line2"));
				address.setState(rs.getString("city"));
				address.setState(rs.getString("state"));	
				address.setState(rs.getString("zip_code"));
				address.setPhone(rs.getString("phone"));
				address.setUserId(rs.getInt("user_id"));
				list.add(address);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;		
	}


	public void addAddress(Address address){
		try {
			String sql= "INSERT into addresses(address_line1,address_line2,city,state,zip_code,phone,user_id) values('" 
					+	 address.getAddressline1() + "','" + address.getAddressline2() + "','" + address.getCity() +
					"','" +	address.getState() + "','" + address.getZip() + "','" + address.getPhone() + "'," + address.getUserId() + ")";
			executeModifySelectQuery(sql);			

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateAddress(Address address){
		try {
			String sql= "UPDATE addresses SET  address_line1 = '" + address.getAddressline1() + "',address_line2='" + address.getAddressline2() +
					"', zip_code='" + address.getZip() + "', city='"+ address.getCity() + "',phone='" + address.getPhone() + "', state='"  + address.getState() + "'";
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteAddress(Address address){
		try {
			String sql= "DELETE FROM addresses WHERE address_id = " + address.getAddressId();
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
