package org.comstudy.saram.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.saram.model.ProductDAO;
import org.comstudy.saram.model.ProductDTO;

public class SelectOneAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "/product/detail.jsp";
		
		int code = Integer.parseInt(req.getParameter("code"));
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductDTO pDto = pDao.selectOne(code);
		
		req.setAttribute("detailP",pDto);
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
