package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
//import dao.AccessBean;

import po.Toperator;

/**
 * @author �Բ���
 * 
 * TODO �ж��û��Ƿ��ǹ���Ա
 */
public class SecondFilter implements Filter {

	public void init(FilterConfig cong) {
//		do nothing
	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) {

		try {
			HttpServletRequest requst = (HttpServletRequest) srequest;
			HttpServletResponse response = (HttpServletResponse) sresponse;
			HttpSession session = requst.getSession();
			//��session��ȡ�ò���Ա
			Toperator operator = (Toperator) session.getAttribute("operator");
			String ad=operator.getIsAdmin().toString();
			//�������ͨҵ��Ա,���޴˲���Ȩ��
			if (operator == null || ad.equals("0")) {
				
					response.sendRedirect("/chinamobile/web/main.jsp");
				
			} else {
				chain.doFilter(srequest, sresponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		//do nothing
	}

}