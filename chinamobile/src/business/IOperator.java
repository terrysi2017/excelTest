package business;
//ҵ������Ա����ҵ��ӿ��ļ�
import po.*;

public interface IOperator {
	/*�жϿͻ��Ƿ����
	 *����:�ͻ�PO����
	 *����ֵ:�ͻ�PO����*/
	public Tcustomer isCustomerExist(Tcustomer customer);
	
	/*���ӿͻ�
	 *����:�ͻ�PO����
	 *����ֵ:�ͻ�PO����*/
	public Tcustomer addCustomer(Tcustomer customer);
	
	/*�ж��ֻ����Ƿ����
	 *����:�ֻ�����
	 *����ֵ:�ֻ�PO����*/
	public Tmobiles isMobileCanUse(String mnb);
	
	/*�����ֻ��û�
	 *����:�ֻ��û�PO����
	 *����ֵ:�����ɹ������Ϣ*/
	public String addUser(Tuser user);
}
