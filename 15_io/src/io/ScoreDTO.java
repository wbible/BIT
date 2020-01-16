package io;

import java.io.Serializable;
import java.util.Vector;

public class ScoreDTO implements Comparable<ScoreDTO>, Serializable{
	private String hak, name;
	private int kor, eng, math, tot;
	private double avg;
	private Vector<String> vec;;
	
	public ScoreDTO() {
		
	}
	
	public Vector<String> getVec() {
		vec = new Vector<String>();
		vec.add(hak);
		vec.add(name);
		vec.add(kor+"");
		vec.add(eng+"");
		vec.add(math+"");
		vec.add(tot+"");
		vec.add(avg+"");
		
		return vec;
	}

	public ScoreDTO(String hak, String name, int kor, int eng, int math) {
		super();
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		calc();
	}
	
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.0;
	}

	public String getHak() {
		return hak;
	}

	public void setHak(String hak) {
		this.hak = hak;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	public String getDataByIndex(int c) {
		if(c == 0) return hak;
		else if(c == 1) return name;
		else if(c == 2) return kor+"";
		else if(c == 3) return eng+"";
		else if(c == 4) return math+"";
		else if(c == 5) return tot+"";
		else return String.format("%.2f", avg);
	}
	
	public void setDataByIndex(Object obj, int c) {
		if(c == 1) hak = (String) obj;
		else if(c == 2) name = (String) obj;
		else if(c == 3) kor = (int) obj;
		else if(c == 4) eng =(int) obj;
		else if(c == 5) math =(int) obj;
		else if(c == 6) tot = (int) obj;
		else avg = (double) obj;
	}

	@Override
	public int compareTo(ScoreDTO o) {
		return tot > o.getTot() ? -1 : 1;
	}
	
}
