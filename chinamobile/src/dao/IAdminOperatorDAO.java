package dao;
//�ײ㣨���ݷ��ʲ㣩�����Ա������Ա������ϵͳ�ӿ��ļ�
import po.Tcharge;
import po.TchargeRule;
import po.Tmobiles;
import po.Toperator;

public interface IAdminOperatorDAO {
	/*���Ӳ���Ա
	 *����:����ԱPO����
	 *����ֵ:boolean*/
	public boolean addOperator(Toperator operator);
	
	/*�жϲ���Ա�Ƿ����
	 *����:����ԱPO����
	 *����ֵ:boolean*/
	public boolean isOperatorExist(Toperator operator);
	
	/*�����ֻ�����
	 *����:�ֻ���PO����
	 *����ֵ:boolean*/
	public boolean addNumber(Tmobiles mobile);
	
	/*�ж��ֻ����Ƿ����
	 *����:�ֻ�����
	 *����ֵ:boolean*/
	public boolean isMobileExist(String mobilenumber);
	
	/*�ж��ֻ������Ƿ����
	 *����:�ֻ�����
	 *����ֵ:boolean*/
	public boolean isCardExist(String cardnumber);
	
	/*�����շ�ϸ��
	 *����:�շ�ϸ��PO����
	 *����ֵ:boolean*/
	public boolean setMoney(Tcharge charge);
	
	/*����ҵ���շ�
	 *����:ҵ��PO����
	 *����ֵ:boolean*/
	public boolean addChargeRule(TchargeRule rule);
	
	/*ɾ��ԭ��ҵ���շ�
	 *����:ҵ������
	 *����ֵ:boolean*/
	public boolean delAllChargeRule(String business);
}
