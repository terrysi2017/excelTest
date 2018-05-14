package business;
//ʵ��ҵ������Ա����ҵ��ӿ�
import dao.IOperatorDAO;
import po.Tcustomer;
import po.Tmobiles;
import po.Tuser;

public class OperatorImp implements IOperator{
	//���ݷ��ʲ����Ա����ҵ�����,��springע��(�й�)
	private IOperatorDAO operator;

	//���ӿͻ�
	public Tcustomer addCustomer(Tcustomer customer) {
		Tcustomer mycustomer=null;
		if(operator.isCustomerExist(customer)==null){
			mycustomer=operator.addCustomer(customer);
		}
		return mycustomer;
	}

	//�����ֻ��û�
	public String addUser(Tuser user) {
		String message="";
		//���ж��û����Ƿ����
		if(operator.isMobileCanUse(user.getTmobiles().getMobileNumber())!=null){
			if(operator.addUser(user)){//�����ֻ��û�
				message="����û��ɹ�!";
			}else{
				message="����û�ʧ��!�������²���!";
			}
		}else{
			message="����û�ʧ��!���ֻ����ѱ�ռ��!";
		}
		return message;
	}

	//�жϿͻ��Ƿ����
	public Tcustomer isCustomerExist(Tcustomer customer) {
		return operator.isCustomerExist(customer);
	}
	
	//�ж��ֻ����Ƿ����
	public Tmobiles isMobileCanUse(String mnb) {
		System.out.println(mnb);
		return operator.isMobileCanUse(mnb);
	}

	//get/set������springע��ʱʹ��
	public IOperatorDAO getOperator() {
		return operator;
	}

	public void setOperator(IOperatorDAO operator) {
		this.operator = operator;
	}
}
