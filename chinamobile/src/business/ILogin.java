package business;

//ҵ������Ա��¼ϵͳ�ӿ��ļ�


import po.Toperator;

public interface ILogin {
	/*�ж��û��Ƿ����,����û�����,�򷵻��û�
	 *����:�û���,����
	 *����ֵ:����ԱPO����*/
	public Toperator isOperator(String operatorName,String operatorPwd);	
}
