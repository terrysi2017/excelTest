package business;
//ʵ��ҵ������Ա������Ա������ϵͳ�ӿ�

import org.apache.commons.lang.RandomStringUtils;

import dao.IAdminOperatorDAO;
import po.*;

public class AdminOperatorImp implements IAdminOperator {
	//	���ݷ��ʲ����Ա������Ա���������,��springע��(�й�)
	private IAdminOperatorDAO adminoperator;
	
	//���ӺŶ�
	public String addNumber(String nbtype,String StartMobile, String endMobile) {
		String message="";
		//��ȡ���ֻ��Ŷε�ǰ�����ַ�
		String before=StartMobile.substring(0,2);
		//����9���ַ�תΪ��ֵ��
		int a1=Integer.parseInt(StartMobile.substring(2,11));
		int a2=Integer.parseInt(endMobile.substring(2,11));
		int all=0;//����ͳ�����ɺ������
		for(int i=a1;i<=a2;i++){//ѭ�������ֻ�����
			if(!adminoperator.isMobileExist(before+i)){
				//���ɿ���
				String cardnumber=RandomStringUtils.randomNumeric(20);
				while(adminoperator.isCardExist(cardnumber)){//��������Ѵ��ڣ���������
					cardnumber=RandomStringUtils.randomNumeric(20);
				}
				//�����ֻ��������
				Tmobiles mobile=new Tmobiles();
				mobile.setCardNumber(cardnumber);
				mobile.setMobileType(nbtype);
				mobile.setIsAvailable("Y");
				mobile.setMobileNumber(before+i);
				if(adminoperator.addNumber(mobile)){//���õײ㷽�������ֻ���
					all++;//���ӳɹ�������1
				}
			}
		}
		message="������ֻ���"+all+"��!";
		return message;
	}

	//���Ӳ���Ա
	public String addOperator(Toperator operator) {
		String message="";
		if(!adminoperator.isOperatorExist(operator)){//���в������Ƿ����
			if(adminoperator.addOperator(operator)){//���Ӳ���Ա
				message="��������Ա�ɹ�!";
			}else{
				message="��������Աʧ��!������������!";
			}
		}else{
			message="�������ӵĲ���Ա�Ѵ���!";
		}
		return message;
	}

	//ҵ���շ�����
	public String editChargeRule(String rule,String[] chargestr) {
		String message="";
		if(adminoperator.delAllChargeRule(rule)){//���ҵ��ǰ��ɾ��ԭ��ҵ��
			
			for(int i=0;i<chargestr.length;i++){//ѭ������ҵ���շ�ϸ��
				TchargeRule myrule=new TchargeRule();
				TchargeRuleId id=new TchargeRuleId();
				Tcharge charge=new Tcharge();
				charge.setChargeCode(chargestr[i]);
				id.setFuncId(rule);
				id.setFuncName("����");
				id.setTcharge(charge);
				myrule.setId(id);
				myrule.setTcharge(charge);
				//System.out.println(chargestr[i]);
				if(!adminoperator.addChargeRule(myrule)){//�����շ���Ŀ
					message="ҵ���շ�����ʧ��";
				}else{
					message="ҵ���շ����óɹ�";
				}
			}
		}else{
			message="ɾ��ԭ��¼�����г��ִ���!";
		}
		return message;
	}

	//����ϸ�����
	public String setMoney(Tcharge charge) {
		String message="";
		if(adminoperator.setMoney(charge)){//�����շ�ϸ��
			message="�շ�ϸ�����óɹ�!";
		}else{
			message="�շ�ϸ������ʧ��!����������!";
		}
		return message;
	}
	
	//	get/set������springע��ʱʹ��
	public IAdminOperatorDAO getAdminoperator() {
		return adminoperator;
	}

	public void setAdminoperator(IAdminOperatorDAO adminoperator) {
		this.adminoperator = adminoperator;
	}

}
