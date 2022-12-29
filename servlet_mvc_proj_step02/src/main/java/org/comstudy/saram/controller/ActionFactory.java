package org.comstudy.saram.controller;

import org.comstudy.saram.controller.action.Action;
import org.comstudy.saram.controller.action.SelectAllAction;
import org.comstudy.saram.controller.action.SelectOneAction;

public class ActionFactory {	// 액션 객체를 생성하는 클래스

	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("selectAll")) {	// 전체 조회
			action = new SelectAllAction();	
		}else if(command.equals("detail")) {
			action = new SelectOneAction();
		}
		
		return action;
	}
}
