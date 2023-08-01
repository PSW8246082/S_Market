package customer.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import customer.model.dao.CustomerDAO;
import customer.model.vo.Customer;


public class CustomerService {

	//연결생성 - 전역변수로 올려준다.
	private JDBCTemplate jdbcTemplate;
	private CustomerDAO mDao;
	
	
	public CustomerService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new CustomerDAO();
	}
	
	    //연결생성
		//DAO호출
		//커밋/롤백
	
	
	public Customer selectCheckLogin(Customer market) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출 (연결도 넘겨줘야함)
		Customer mOne = mDao.selectCheckLogin(conn, market);
		//커밋/롤백은 SELECT에서 안해줘도 된다. 할 필요가 없음 저장하고 롤백할 필요 없으니까
		return mOne;
	}

	public int insertCustomer(Customer customer) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출 (연결도 넘겨줘야함)
		int result = mDao.insertCustomer(conn, customer);
		//커밋/롤백
		if(result > 0) {
			//성공 = 커밋
			jdbcTemplate.comit(conn);
		} else {
			//실패 = 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	
	
	

	
}
