package business;
//ʵ��ҵ������Ա��¼ϵͳ�ӿ�
import dao.ILoginDAO;
import po.Toperator;

public class LoginImp implements ILogin{
	//���ݷ��ʲ����Ա��¼����,��springע��(�й�)
	private ILoginDAO login;
	
	//�ж��û��Ƿ����,����û�����,�򷵻��û�
	public Toperator isOperator(String operatorName, String operatorPwd) {
		return login.isOperator(operatorName, operatorPwd);
	}
	
	//	get/set������springע��ʱʹ��
	public ILoginDAO getLogin() {
		return login;
	}
	
	public void setLogin(ILoginDAO login) {
		this.login = login;
	}
}
