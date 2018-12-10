package com.pg.util;

public class Util {
//Util클래스에서 화살표 출력 기능 구현
//usebean은 객체를 저장하고 꺼내는 객체에 사용
//&nbsp;&nbsp;&nbsp;&nbsp;+ -> 글제목 (제목은 화면에서 더해준다.)

	private String arrowNbsp;

	public String getArrowNbsp() { //<jsp:getProperty가 호출해줌
		return arrowNbsp;
	}

	public void setArrowNbsp(String depth) { //<jsp:setProperty> 가 호출해줌. (usebean을 사용하려면 클래스가 DTO 형식으로 되어있어야 한다.)
		String nbsp = "";
		int depthInt = Integer.parseInt(depth); // for문을 사용하기 위해서 Int로 바꿔준다.
		for(int i=0; i < depthInt; i++) {
			nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;";
			
		}
		//depth가 0이면 새글이기 때문에 0보다 큰 경우만 출력
		this.arrowNbsp=(depthInt>0?nbsp+"<img src='img/arrow.png' alt='답글' />":"");
	}
	
}
