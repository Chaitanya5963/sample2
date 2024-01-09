package com.demoJDBC.demo;

import java.util.ArrayList;
import java.util.HashMap;

class Database {
	String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
class TableData {
	String name;
	HashMap<String, String> column = new HashMap<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getColumn() {
		return column;
	}
	public void setColumn(HashMap<String, String> column) {
		this.column = column;
	}
}
//class InsertData {
//	String name;
//	ArrayList<String> column = new ArrayList<>();
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public ArrayList<String> getColumn() {
//		return column;
//	}
//	public void setColumn(ArrayList<String> column) {
//		this.column = column;
//	}
//}
class InsertData {
	int id;
	String name;
	String tableName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}