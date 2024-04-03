package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IPcDao;
import dao.PcDaoImpl;
import metier.entities.Pcs;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	IPcDao metier;

	@Override
	public void init() throws ServletException {
		metier = new PcDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("Pc.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			PcsModele model = new PcsModele();
			model.setMotCle(motCle);
			List<Pcs> pcs = metier.PcssParMC(motCle);
			model.setPcss(pcs);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Pc.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisiePc.jsp").forward(request, response);
		}

		else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			String specs = request.getParameter("specs");
			Pcs p = metier.save(new Pcs(nom, prix, specs));
			request.setAttribute("Pc", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deletePcs(id);
			response.sendRedirect("chercher.do?motCle=");
		} 
		/**/
		else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Pcs p = metier.getPcs(id);
			request.setAttribute("Pc", p);
			request.getRequestDispatcher("editerPc.jsp").forward(request, response);
		} 
		
		else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			String specs = request.getParameter("Specs");
			Pcs p = new Pcs();
			p.setIdPcs(id);
			p.setNomPcs(nom);
			p.setPrix(prix);
			p.setSpecs(specs);
			metier.updatePcs(p);
			request.setAttribute("Pc", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}

		/**/
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}