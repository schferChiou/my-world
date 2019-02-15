import java.util.HashMap;
import java.util.Map;


public enum TestEnum {

		CODE_1A("各类专业、技术人员","1A"),
		CODE_1B("国家机关、党群组织、企事业单位的负责人","1B"),
		CODE_1C("办事人员和有关人员","1C"),
		CODE_1D("商业工作人员","1D"),
		CODE_1E("服务性工作人员","1E"),
		CODE_1F("农林牧渔劳动者","1F"),
		CODE_1G("生产工作，运输工作和部分体力劳动者","1G"),
		CODE_1H("不便分类的其他劳动者","1H"),
		CODE_1I("军人","1I"),
		CODE_2A("农、林、牧、渔业","2A"),
		CODE_2B("采矿业","2B"),
		CODE_2C("制造业","2C"),
		CODE_2D("电力、燃气及水的生产和供应业","2D"),
		CODE_2E("建筑业","2E"),
		CODE_2F("交通运输、仓储和邮政业","2F"),
		CODE_2G("信息传输、计算机服务和软件业","2G"),
		CODE_2H("批发和零售业","2H"),
		CODE_2I("住宿和餐饮业","2I"),
		CODE_2J("银行业","2J"),
		CODE_2K("房地产业","2K"),
		CODE_2L("租赁和商务服务业","2L"),
		CODE_2M("科学研究、技术服务和地址勘察业","2M"),
		CODE_2N("水利、环境和公共设施管理业","2N"),
		CODE_2O("居民服务和其他服务业","2O"),
		CODE_2P("教育","2P"),
		CODE_2Q("卫生、社会保障和社会福利业","2Q"),
		CODE_2R("文化、体育和娱乐业","2R"),
		CODE_2S("公共管理和社会组织","2S"),
		CODE_2T("国际组织","2T"),
		 ;

		  private String name;  
		  private String value; 
		    // 构造方法  
		    private TestEnum(String name,String value) {  
		        this.name = name;  
		        this.value=value;
		    }  
		  
		    // 普通方法  
		    public static String getName(String value) {  
		        for (TestEnum c : TestEnum.values()) {  
		            if (c.getValue().equals(value)) {  
		                return c.name;  
		            }  
		        }  
		        return "";  
		    }  
		    public String getValue() {
				return value;
			}
			public void setValue(String value) {
				this.value = value;
			}
			// get set 方法  
		    public String getName() {  
		        return name;  
		    }  
		    public void setName(String name) {  
		        this.name = name;  
		    }  
		  
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return this.value;
			} 
		public static void main(String[] args) {
			
			String enumdataString = TestEnum.CODE_1A.getName();
			
			
			System.out.println("enumData===="+enumdataString);
		}
	}
