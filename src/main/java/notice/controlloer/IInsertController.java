package notice.controlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class IInsertController
 */
@WebServlet("/notice/iinsert.do")
public class IInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/inquireInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String noticeWriter = request.getParameter("writer");
		String noticeSebject = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		Notice notice = new Notice(noticeSebject, noticeContent, noticeWriter);
		
		NoticeService service = new NoticeService();
		int result = service.insertNotice(notice);
		
		if(result > 0) {
			//성공 -> 공지사항 리스트로 이동
			response.sendRedirect("/notice/ilist.do");
		} else {
			//실패 -> 실패메세지 출력
			request.setAttribute("msg", "공지사항 등록이 완료되지 않았습니다");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFail.jsp");
			view.forward(request, response);
		}
	}

}
