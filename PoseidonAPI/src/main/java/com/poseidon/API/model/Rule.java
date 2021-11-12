package com.poseidon.API.model;

import javax.persistence.*;

@Entity
@Table(name = "rules")
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String json;
	private String template;
	@Column(name = "sql_str")
	private String sqlStr;
	@Column(name = "sql_part")
	private String sqlPart;

	public Rule() {
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSqlStr() {
		return sqlStr;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getSqlPart() {
		return sqlPart;
	}

	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}
	

}
