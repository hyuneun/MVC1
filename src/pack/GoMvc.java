package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GoMvc")
public class GoMvc extends HttpServlet {

	//컨트롤러 역활
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name,result= null, viewName= null;
		RequestDispatcher dispatcher = null;
		
		try {
			name = request.getParameter("name");
			
		} catch (Exception e) {
			name = null;
		}
		
		if(name == null || name.equals("")){
			result = "꺼지세요";	//Model을 수행했다고 가정
			viewName = "/view/gomvc_view1.jsp";
		}else if(name.equalsIgnoreCase("korea")){
			result = "두유노김치?";	//Model을 수행했다고 가정
			viewName = "/view/gomvc_view2.jsp";
		}else{
			result = name + "꺼지세요";	//Model을 수행했다고 가정
			viewName = "/view/gomvc_view3.jsp";
		}
		
		dispatcher = request.getRequestDispatcher(viewName);
		request.setAttribute("result", result);
		dispatcher.forward(request, response);
	}


}
