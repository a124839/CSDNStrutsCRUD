package empDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import empEntity.Emploee;

/**
 * @author k570
 * 数据交互层
 *
 */
public class EmploeeDao {
	private static Map<Integer, Emploee> emp = new HashMap<Integer,Emploee>();
	//static静态代码块中初始化
	static{
		emp.put(001, new Emploee(001, "张三", "幸福1", "邮件地址11"));
		emp.put(002, new Emploee(002, "王五", "幸福2", "邮件地址12"));
		emp.put(003, new Emploee(003, "李四", "幸福3", "邮件地址13"));
		emp.put(004, new Emploee(004, "找刘", "幸福4", "邮件地址14"));
		emp.put(005, new Emploee(005, "闷气", "幸福5", "邮件地址15"));
		
	}
	//获取Emploee
	public List<Emploee> getEmploee() {
		return new ArrayList<>(emp.values());
	}
	//删除(怎么删？或者说按照什么删？按id删除，你得传个id吧)
	public void deleteEmploee(Integer id) {
		emp.remove(id);
	}
	//保存 （保存什么进来？Emploee对象啊。）
	public void saveEmploee(Emploee emploee) {
		long time = System.currentTimeMillis();
		//给emp一个id
		emploee.setId((int) time);
		//保存到map中
		emp.put(emploee.getId(), emploee);
		
	}
	
	public Emploee get(Integer id) {
		return emp.get(id);
	}
	
	//修改(用id改，传入emp对象。原来的id不变，内容变了所以得到原来id，并把emp对象放入map中)
	public void updateEmploee(Emploee emploee) {
		emp.put(emploee.getId(), emploee);
	}
	
}
