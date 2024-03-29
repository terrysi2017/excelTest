/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import business.IAdminOperator;

import po.Tcharge;
import struts.form.EditChargeForm;

/** 
 * 功能:设置收费项目
 * 作者:赵昌峻
 * Creation date: 11-02-2006
 * 
 * XDoclet definition:
 * @struts.action path="/editCharge" name="editChargeForm" input="/web/Charge.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/web/saveInfo.jsp" redirect="true"
 */
public class EditChargeAction extends Action {
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
		EditChargeForm editChargeForm = (EditChargeForm) form;// TODO Auto-generated method stub
		Tcharge charge=new Tcharge();
		
		charge.setCharge(Double.valueOf(editChargeForm.getCharge()));
		charge.setChargeCode(editChargeForm.getChargeCode());
		//		在AddCustomerAction里有相关注释
		ApplicationContext context=new FileSystemXmlApplicationContext("C:\\eclipse\\workspace\\chinamobile\\src\\applicationContext.xml");
		IAdminOperator admin=(IAdminOperator)context.getBean("adminservice");
		//System.out.println("hello!");
		//调用业务层方法设置收费细项
		String message=admin.setMoney(charge);
		System.out.println(message);
		if(!message.equals("")){
			request.setAttribute("message", message);
			return mapping.findForward("success");
		}
		else{
			return mapping.getInputForward();
		}
	}
}