package br.com.cwi.crescer.lavanderia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "serverzinho", urlPatterns = { "/serverzinho" })
public class ServerzinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String mensagem = "Qualquer mensagem";
		
		//response.getWriter().append("<html><h1> Um titulo </h1></html>");
		
		request.setAttribute("mensagem", mensagem);
		
		request.getRequestDispatcher("saida.jsp")
		.forward(request, response);
	}

}
