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
            
            System.out.println("hello kity 的原始积分为："+pointDomain.getPoint());
			
			kSession.insert(pointDomain);
			kSession.fireAllRules();
			
			System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());  
            System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());  
            System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());  
              
            System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static class PointDomain {
		// 用户名
		private String userName;
		// 是否当日生日
		private boolean birthDay;
		// 增加积分数目
		private long point;
		// 当月购物次数
		private int buyNums;
		// 当月退货次数
		private int backNums;
		// 当月购物总金额
		private double buyMoney;
		// 当月退货总金额
		private double backMondy;
		// 当月信用卡还款次数
		private int billThisMonth;

		/**
		 * 记录积分发送流水，防止重复发放
		 * 
		 * @param userName
		 *            用户名
		 * @param type
		 *            积分发放类型
		 */
		public void recordPointLog(String userName, String type, int scores) {
			System.out.println(userName + "： 积分操作记录类型为" + type + "，积分改变值为 " + scores);
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
