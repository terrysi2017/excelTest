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
import struts.form.ResourceForm;

/** 
 * 功能:资源配置(增加可用手机号)
 * 作者:赵昌峻
 * Creation date: 11-02-2006
 * 
 * XDoclet definition:
 * @struts.action path="/resource" name="resourceForm" input="/web/Resource.jsp" scope="request" validate="true"
 * @struts.action-forward name="success" path="/web/saveInfo.jsp" redirect="true"
 */
public class ResourceAction extends Action {
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
		ResourceForm resourceForm = (ResourceForm) form;// TODO Auto-generated method stub
		//		在AddCustomerAction里有相关注释
		ApplicationContext context=new FileSystemXmlApplicationContext("C:\\eclipse\\workspace\\chinamobile\\src\\applicationContext.xml");
		IAdminOperator admin=(IAdminOperator)context.getBean("adminservice");
		//		调用业务层的方法设置业务收费增加可用手机号
		String message=admin.addNumber(resourceForm.getNbtype(), resourceForm.getStartMobile(), resourceForm.getEndMobile());
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