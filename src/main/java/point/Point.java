package point;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Point {

	public static final void main(String[] args) {
		System.setProperty("drools.dateformat","yyyy-MM-dd");
		//System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss"); 
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("points");

			// go !
			PointDomain pointDomain = new PointDomain();  
            pointDomain.setUserName("hello kity");  
            pointDomain.setBackMondy(101d);  
            pointDomain.setBuyMoney(500d);  
            pointDomain.setBackNums(4);  
            pointDomain.setBuyNums(7);  
            pointDomain.setBillThisMonth(5);  
            pointDomain.setBirthDay(true);  
            pointDomain.setPoint(25);
            
            System.out.println("hello kity ��ԭʼ����Ϊ��"+pointDomain.getPoint());
			
			kSession.insert(pointDomain);
			kSession.fireAllRules();
			
			System.out.println("ִ�����BillThisMonth��"+pointDomain.getBillThisMonth());  
            System.out.println("ִ�����BuyMoney��"+pointDomain.getBuyMoney());  
            System.out.println("ִ�����BuyNums��"+pointDomain.getBuyNums());  
              
            System.out.println("ִ����Ϲ�������������ͻ��֣�"+pointDomain.getPoint());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static class PointDomain {
		// �û���
		private String userName;
		// �Ƿ�������
		private boolean birthDay;
		// ���ӻ�����Ŀ
		private long point;
		// ���¹������
		private int buyNums;
		// �����˻�����
		private int backNums;
		// ���¹����ܽ��
		private double buyMoney;
		// �����˻��ܽ��
		private double backMondy;
		// �������ÿ��������
		private int billThisMonth;

		/**
		 * ��¼���ַ�����ˮ����ֹ�ظ�����
		 * 
		 * @param userName
		 *            �û���
		 * @param type
		 *            ���ַ�������
		 */
		public void recordPointLog(String userName, String type, int scores) {
			System.out.println(userName + "�� ���ֲ�����¼����Ϊ" + type + "�����ָı�ֵΪ " + scores);
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String name) {
			this.userName = name;
		}

		public boolean getBirthday() {
			return birthDay;
		}

		public void setBirthDay(boolean isBirthday) {
			this.birthDay = isBirthday;
		}

		public long getPoint() {
			return point;
		}

		public void setPoint(long point) {
			this.point = point;
		}

		public int getBuyNums() {
			return buyNums;
		}

		public void setBuyNums(int t) {
			this.buyNums = t;
		}

		public int getBackNums() {
			return backNums;
		}

		public void setBackNums(int t) {
			this.backNums = t;
		}

		public double getBuyMoney() {
			return buyMoney;
		}

		public void setBuyMoney(double t) {
			this.buyMoney = t;
		}

		public double getBackMondy() {
			return backMondy;
		}

		public void setBackMondy(double t) {
			this.backMondy = t;
		}

		public int getBillThisMonth() {
			return billThisMonth;
		}

		public void setBillThisMonth(int t) {
			this.billThisMonth = t;
		}

	}
}
