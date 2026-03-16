package oop.multi1;

//GalaxyS26은 휴대폰이면서 카메라이기도 하고, 게임기이도 하지만 GPS도구 이기도 하다. 결제와 NFC도 가능하다.
//-이 중에 가장 본질적인 요소는 '휴대폰'이고, 나머지는 부가적인 요소들이다. 
//-갤럭시S26은 휴대폰 중 하나이다. (메인속성을 판별하는 질문, is-a)
//-갤럭시S26에는 카메라 기능이 있다. (부가속성을 판별하는 질문, has-a)
//메인속성이 없을 수도 있고 부가 속성이 없을 수도 있다. 
//메인 속성은 하나만 가능, 부가속성을 여러개가 가능 

public class GalaxyS26 extends Phone implements Shootable, Controllable /*, GPS 결제, NFC*/ {

	@Override
	public void up() {
	}

	@Override
	public void down() {
	}

	@Override
	public void left() {
	}

	@Override
	public void right() {
	}

	@Override
	public void attack() {
	}

	@Override
	public void jump() {
	}

	@Override
	public void shoot() {
	}

	@Override
	public void call() {
	}

	@Override
	public void sms() {
	}

}
