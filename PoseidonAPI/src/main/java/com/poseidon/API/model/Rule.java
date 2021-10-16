package com.poseidon.API.model;

import java.util.Objects;

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

	public Rule(int id, String name, String description, String json, String template, String sqlStr,
			String sqlPart) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
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

	@Override
	public String toString() {
		return "RuleName [id=" + id + ", name=" + name + ", description=" + description + ", json=" + json
				+ ", template=" + template + ", sqlStr=" + sqlStr + ", sqlPart=" + sqlPart + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, json, name, sqlPart, sqlStr, template);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(json, other.json)
				&& Objects.equals(name, other.name) && Objects.equals(sqlPart, other.sqlPart)
				&& Objects.equals(sqlStr, other.sqlStr) && Objects.equals(template, other.template);
	}
	
	

}
