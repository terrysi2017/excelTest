package dao;
//�ײ㣨���ݷ��ʲ㣩�����Ա��¼ϵͳ�ӿ��ļ�
import po.Toperator;

public interface ILoginDAO {
	/*�ж��ǲ���Ա�Ƿ����
	 *����:�û���������
	 *����ֵ:������PO����*/
	public Toperator isOperator(String operatorName,String operatorPwd);
}
