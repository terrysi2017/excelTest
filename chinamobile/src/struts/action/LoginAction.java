/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import po.Toperator;

import business.ILogin;

import struts.form.LoginForm;

/** 
 * 功能:用户登录
 * 作者:赵昌峻
 * Creation date: 11-01-2006
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" input="/index.html" scope="request" validate="true"
 * @struts.action-forward name="success" path="/web/main.jsp" redirect="true"
 */
public class LoginAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		String operatorName=loginForm.getName();
		String operatorPwd=loginForm.getPassword();
		//		在AddCustomerAction里有相关注释
		ApplicationContext context=new FileSystemXmlApplicationContext("C:\\eclipse\\workspace\\chinamobile\\src\\applicationContext.xml");
		ILogin login=(ILogin)context.getBean("loginservice");
		//		调用业务层的方法判断是否是合法用户
		Toperator operator=login.isOperator(operatorName, operatorPwd);
		if(operator!=null){
			session.setAttribute("operator", operator);
			return mapping.findForward("success");
		}else{
			return mapping.getInputForward();
		}
		
	}
}