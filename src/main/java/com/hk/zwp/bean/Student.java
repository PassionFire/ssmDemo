package com.hk.zwp.bean;

public class Student {
	private Integer id;
	private String name;
	private Integer score;
	private String className;
	private String head;

	public Student() {
	}

	public Student(String name, Integer score, String className, String head) {
		this.name = name;
		this.score = score;
		this.className = className;
		this.head = head;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", score=" + score +
				", className='" + className + '\'' +
				", head='" + head + '\'' +
				'}';
	}
}
