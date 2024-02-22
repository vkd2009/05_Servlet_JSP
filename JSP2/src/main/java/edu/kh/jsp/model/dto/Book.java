package edu.kh.jsp.model.dto;

public class Book {

	// 필드(== 멤버 변수)
	// 캡슐화 웹으로 부터의 직접 접근을 막기 위해
	private String title;
	private String writer;
	private int price;

	// 기본 생성자
	// 생성자 == 객체가 생성될 때 실행되는 것
	public Book() {
	}

	// 매개 변수 생성자
	// 생성된 객체의 필드를 초기화 해준다
	public Book(String title, String writer, int pirce) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Book [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}

	
	
}
