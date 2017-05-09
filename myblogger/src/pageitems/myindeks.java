package pageitems;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectto.datamodel;
import connectto.ourKonnektor;

/**
 * Servlet implementation class myindeks
 */
@WebServlet("/myindeks")
public class myindeks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myindeks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ourKonnektor o = new ourKonnektor();
		ArrayList<datamodel> mydata=o.getitems();
		PrintWriter out=response.getWriter();
		int articlenumber=0;
		String input=request.getParameter("ind");
		if(input.contains("null"))
		{
			articlenumber=0;
		}else
		{
			articlenumber=Integer.parseInt(input);
		}
		String context="<html> <head> <link rel=\"stylesheet\" type=\"text/css\" href=\"/nf.css\"></head><body>";
		context+="<div id=\"container\" > <div id=\"header\"> header content here";
		context+="</div> <div id=\"content\">" +mydata.get(articlenumber).getContent()+"main content here";
		context+="<div id=\"sidebar\">";
		context+="<ul>";
		for(datamodel d:mydata)
		{
			context+="<li>"+"<a href src=\"http://localhost:80/myblogger/myindeks?ind="+mydata.indexOf(d)+"\">"+d.getTopic()+"</li>";
		}
		context+="</ul>";
		context+="sidebar content here"+"</div>";
		context+="</div>";
		context+="<div id=\"footer\"> footer content here </div></div>";
		
		
		
		context+="</body></html>";
		out.print(context);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
