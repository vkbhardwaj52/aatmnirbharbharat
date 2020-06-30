package com.vivek.myrestapifinal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.myrestapifinal.dao.ItemProfileDAO;
import com.vivek.myrestapifinal.model.ItemProfile;

@RestController
@RequestMapping("/item")
public class ItemProfileController {
	
	@Autowired
	ItemProfileDAO itemProfileDAO;	
	
	//To get all item
	@GetMapping("/getAllItems")
	public List<ItemProfile> getAllCategories()
	{
		return itemProfileDAO.findAll();
	}	
	
	//Get item by id
	@GetMapping("/getItemById/id/{id}")
	public ResponseEntity<ItemProfile> getEmployeeById(@PathVariable(value="id") String id){
		
		Long itemId = Long.parseLong(id);
		ItemProfile item=itemProfileDAO.findOne(itemId);
		
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(item);		
	}
	
	
	//Get item by sub categoies id
	@GetMapping("/getItemBySubCategoriesId/id/{id}")
	public List<ItemProfile> getItemBySubCategoriesId(@PathVariable(value="id") String id){
		
		Long subCategoriesId = Long.parseLong(id);		

		List<ItemProfile> retItemProfile = new ArrayList<ItemProfile>();
		
		List<ItemProfile> itemProfile = itemProfileDAO.findAll();
		
		for(int i=0;i<itemProfile.size();i++)
		{
			ItemProfile it = itemProfile.get(i);
			if(it.getSubCategoriesId() == subCategoriesId)
			{
				retItemProfile.add(it);
			}
		}
		
		return retItemProfile;
		
		/*Statement st = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");		
			conn=DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-01.cleardb.net:3306/heroku_9c7055a38f983e1","be5fdd00a0f7ad","edeffbc1");
			st = conn.createStatement();
			rs = st.executeQuery("select item_id, item_short_desc,item_long_desc,item_price,item_coo,item_image,sub_categories_id,create_tstamp from item_profile where sub_categories_id = "+subCategoriesId);
			while(rs.next())
			{
				ItemProfile a1 = new ItemProfile();
				
				a1.setItemId(Long.parseLong(rs.getString("item_id")));
				a1.setItemShortDesc(rs.getString("item_short_desc"));
				a1.setItemLongDesc(rs.getString("item_long_desc"));
				a1.setItemPrice(Integer.parseInt(rs.getString("item_price")));
				a1.setItemCoo(rs.getString("item_coo"));				
				a1.setItemImage(rs.getString("item_image"));
				a1.setSubCategoriesId(Long.parseLong(rs.getString("sub_categories_id")));				
				a1.setCreatedTstamp(new Date());
				
				itemProfile.add(a1);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(st != null && !st.isClosed())
				{
					st.close();
				}
				if(conn != null && !conn.isClosed())
				{
					conn.close();
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		return itemProfile;	
		*/
		
		
	}
	
	//Get item by sub item desc
	@GetMapping("/getItemByItemDesc/desc/{id}")
	public List<ItemProfile> getItemByItemDesc(@PathVariable(value="id") String id){
		
		List<ItemProfile> retItemProfile = new ArrayList<ItemProfile>();
		
		List<ItemProfile> itemProfile = itemProfileDAO.findAll();
		
		for(int i=0;i<itemProfile.size();i++)
		{
			ItemProfile it = itemProfile.get(i);
			if(it.getItemShortDesc().contains(id) || it.getItemLongDesc().contains(id) || it.getItemPrice() == Integer.parseInt(id))
			{
				retItemProfile.add(it);
			}
		}	
		return retItemProfile;
	}
		
	
	//Save an item
	@PostMapping("/saveItem")
	public ItemProfile createEmployee(@Valid @RequestBody ItemProfile emp)
	{
		return itemProfileDAO.save(emp);
	}	

	
	/*Update an item by id*/
	@PutMapping("/updateItemById/id/{id}")
	public ResponseEntity<ItemProfile> updateEmployee(@PathVariable(value="id") String id,@Valid @RequestBody ItemProfile item){
		
		Long itemId = Long.parseLong(id);
		ItemProfile itemProfile=itemProfileDAO.findOne(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}		
		item.setItemShortDesc(item.getItemShortDesc());
		item.setItemLongDesc(item.getItemLongDesc());
		item.setItemPrice(item.getItemPrice());
		item.setItemCoo(item.getItemCoo());
		item.setItemImage(item.getItemImage());
		item.setSubCategoriesId(item.getSubCategoriesId());
		item.setLink(item.getLink());
		ItemProfile updateEmployee=itemProfileDAO.save(itemProfile);
		return ResponseEntity.ok().body(updateEmployee);		
	}
	
	/*Delete an item by id*/
	@DeleteMapping("/deleteCategoriesById/id/{id}")
	public ResponseEntity<ItemProfile> deleteEmployee(@PathVariable(value="id") String id){
		
		Long itemId = Long.parseLong(id);
		ItemProfile item=itemProfileDAO.findOne(itemId);
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		itemProfileDAO.delete(item);		
		return ResponseEntity.ok().build();		
	}

}
