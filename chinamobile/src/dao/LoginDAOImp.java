package dao;
//ʵ�ֵײ㣨���ݷ��ʲ㣩�����Ա��¼ϵͳ�ӿ�
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import po.Toperator;

public class LoginDAOImp implements ILoginDAO{
	//	hibernate��SessionFactory������springע�룮
	private SessionFactory factory;

	//	get/set������springע��ʱʹ��
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//�ж��ǲ���Ա�Ƿ����
	public Toperator isOperator(String operatorName, String operatorPwd) {
		Toperator operator=null;
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Toperator t where t.operatorName='"+operatorName+"' and t.operatorPwd='"+operatorPwd+"'");
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			operator=(Toperator)it.next();
		}
		ts.commit();
		session.close();
		return operator;
	}
}
