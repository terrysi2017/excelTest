package dao;

import po.Tcustomer;
import po.Tmobiles;
import po.Tuser;
//�ײ㣨���ݷ��ʲ㣩�����Ա����ҵ��ӿ��ļ�
public interface IOperatorDAO {
	/*�жϿͻ��Ƿ����
	 *����:�ͻ�PO����
	 *����ֵ:�ͻ�PO����*/
	public Tcustomer isCustomerExist(Tcustomer customer);
	
	/*���ӿͻ�
	 *����:�ͻ�PO����
	 *����ֵ:�ͻ�PO����*/
	public Tcustomer addCustomer(Tcustomer customer);
	
	/*�ж��ֻ����Ƿ����
	 *����:�ֻ���
	 *����ֵ:�ֻ�PO����*/
	public Tmobiles isMobileCanUse(String mnb);
	
	/*�����ֻ��û�
	 *����:�ֻ��û�PO����
	 *����ֵ:boolean*/
	public boolean addUser(Tuser user);
}
