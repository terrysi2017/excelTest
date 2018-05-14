package dao;
//ʵ�ֵײ㣨���ݷ��ʲ㣩�����Ա����ҵ��ӿ�
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import po.Tcustomer;
import po.Tmobiles;
import po.Tuser;

public class OperatorDAOImp implements IOperatorDAO{
	//	hibernate��SessionFactory������springע�룮
	private SessionFactory factory;

	//���ӿͻ�
	public Tcustomer addCustomer(Tcustomer customer) {
		Tcustomer mycustomer=null;
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(customer);
		ts.commit();
		Transaction ts1=session.beginTransaction();
		Query query=session.createQuery("from Tcustomer t where t.idNumber='"+customer.getIdNumber()+"'");
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			mycustomer=(Tcustomer)it.next();
		}
		ts1.commit();
		session.close();
		return mycustomer;
	}

	//�����ֻ��û�
	public boolean addUser(Tuser user) {
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(user);
		Tmobiles mobile=(Tmobiles) session.get(Tmobiles.class, user.getTmobiles().getMobileNumber());
		mobile.setIsAvailable("N");
		session.update(mobile);
		ts.commit();
		boolean isok=ts.wasCommitted();
		session.close();
		return isok;
	}

	//�жϿͻ��Ƿ����
	public Tcustomer isCustomerExist(Tcustomer customer) {
		Tcustomer mycustomer=null;
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Tcustomer t where t.idNumber='"+customer.getIdNumber()+"'");
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			mycustomer=(Tcustomer)it.next();
		}
		ts.commit();
		session.close();
		return mycustomer;
	}

	//�ж��ֻ����Ƿ����
	public Tmobiles isMobileCanUse(String mobile) {
		Tmobiles mymobile=null;
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Tmobiles t where t.mobileNumber='"+mobile+"' and t.isAvailable='Y'");
		List list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			mymobile=(Tmobiles)it.next();
		}
		ts.commit();
		session.close();
		return mymobile;
	}
	//	get/set������springע��ʱʹ��
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
