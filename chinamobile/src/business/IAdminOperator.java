package business;
//ҵ������Ա������Ա������ϵͳ�ӿ��ļ�
import po.*;

public interface IAdminOperator {
	/*���Ӳ���Ա
	 *����:����ԱPO����
	 *����ֵ:�����ɹ������Ϣ*/
	public String addOperator(Toperator operator);
	/*���ӺŶ�
	 *����:��������,���뿪ʼ��,���������
	 *����ֵ:�����ɹ������Ϣ*/
	public String addNumber(String nbtype,String StartMobile,String endMobile);
	/*����ϸ�����
	 *����:ϸ�����PO����
	 *����ֵ:�����ɹ������Ϣ*/
	public String setMoney(Tcharge charge);
	/*ҵ���շ�����
	 *����:ҵ�����,�շ���Ŀ����
	 *����ֵ:�����ɹ������Ϣ*/
	public String editChargeRule(String rule,String[] charge);
}
