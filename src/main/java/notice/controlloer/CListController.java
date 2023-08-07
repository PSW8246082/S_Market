package notice.controlloer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/notice/clist.do")
public class CListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		
//		NoticeService service = new NoticeService();
//		PageData pd = service.selectNoticeList(currentPage);
//		List<Notice> nList = pd.getnList();
//		
//		request.setAttribute("nList", nList);
//		request.setAttribute("pageNavi", pd.getPageNavi());
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/customerCenter.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
