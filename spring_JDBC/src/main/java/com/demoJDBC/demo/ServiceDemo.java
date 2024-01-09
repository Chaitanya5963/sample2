package com.demoJDBC.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {
	
	@Autowired
	JdbcTemplate jt;
	
	@Autowired
	NamedParameterJdbcTemplate nj;

	
	public HashMap<Integer, String> createDB(Database ob) {
		HashMap<Integer, String> hm = new HashMap<>();
		try {
			jt.execute("drop database "+ob.getS());
			hm.put(1, "Success");
		}
		catch(Exception e) {
			hm.put(0, "Failed");
		}
		return hm;
	}
	
	public HashMap<Integer, String> dropDB(Database ob) {
		HashMap<Integer, String> hm = new HashMap<>();
		try {
			jt.execute("drop database "+ob.getS());
			hm.put(1, "Success");
		}
		catch(Exception e) {
			hm.put(0, "Failed");
		}
		return hm;
	}

	public HashMap<Integer, String> createTable(TableData ob) {
		HashMap<Integer, String> hm = new HashMap<>();
		HashMap<String, String> a = ob.getColumn();
		String sql = "create table "+ob.getName()+"(";	
		int asize = a.size();
		for(Map.Entry<String, String> m : a.entrySet()) {
			sql += m.getKey()+" "+m.getValue();
			if(asize-- > 1) {
				sql += ", ";
			}
		}
		sql += ")";
		try {
			jt.execute("use demo");
			jt.execute(sql);
			hm.put(1, "Success");
		}
		catch(Exception e) {
			hm.put(0, e.getMessage());
		}
		return hm;
	}

//	public HashMap<Integer, String> insertData(InsertData ob) {
//		HashMap<Integer, String> hm = new HashMap<>();
//		ArrayList<String> a = ob.getColumn();
//		String sql = "insert into "+ob.getName()+" values(";	
//		int asize = a.size();
//		Iterator it = a.iterator();
//		while(it.hasNext()) {
//			sql += "'"+it.next()+"'";
//			if(asize-- > 1) {
//				sql += ", ";
//			}
//		}
//		sql += ")";
//		try {
//			jt.execute("use demo");
//			jt.execute(sql);
//			hm.put(1, "Success");
//		}
//		catch(Exception e) {
//			hm.put(0, e.getMessage());
//		}
//		return hm;
//	}
	
	public HashMap<String, String> fun(demo ob) {
		return ob.hm;
	}

	public HashMap<Integer, String> insertData(InsertData ob) {
		HashMap<Integer, String> hm = new HashMap<>();
		int id = ob.getId();
		String name = ob.getName();
		String tableName = ob.getTableName();
		try {
			jt.execute("use demo");
			if(jt.update("insert into sampleTable values (?, ?)", name, id) > 0) {
				hm.put(1, "Inserted");
			}
			else {
				hm.put(2, "Not inserted");
			}
		}
		catch(Exception e) {
			hm.put(3, e.toString());
			e.printStackTrace();
		}
		return hm;
	}
	
//	public HashMap<Integer, String> insertData(InsertData ob) {
//		HashMap<Integer, String> hm = new HashMap<>();
//		int id = ob.getId();
//		String name = ob.getName();
//		String tableName = ob.getTableName();
//		try {
//			SqlParameterSource param = new MapSqlParameterSource()
//					.addValue("tname",tableName)
//					.addValue("name",name)
//					.addValue("id",id);
//			jt.execute("use demo");
//			if(nj.update("insert into sampleTable(name, id) values(:name, :id)", param) > 0) {
//				hm.put(1, "Inserted");
//			}
//			else {
//				hm.put(2, "Not inserted");
//			}
//		}
//		catch(Exception e) {
//			hm.put(3, e.toString());
//			e.printStackTrace();
//		}
//		return hm;
//	}
	
}