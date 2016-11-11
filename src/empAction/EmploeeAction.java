package empAction;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import empDao.EmploeeDao;
import empEntity.Emploee;

/**
 * @author k570
 *
 */
public class EmploeeAction extends ActionSupport implements RequestAware,ModelDriven<Emploee>,Preparable {

	private static final long serialVersionUID = 1L;
	//需要在当前EmploeeAction中重新定义emploeeId的属性以请求参数
	private EmploeeDao empdao = new EmploeeDao();
	private Emploee emploee;
	
	//因为要根据id判断emploee的状态所以单拿出来
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String update() {
		empdao.updateEmploee(emploee);		
		return "seccess";
	}
	public void prepareUpdate() {
		emploee = new Emploee();
	}
	public String edit() {
		//1.获取employeeId
		
		//2.从id获取到employee对象
//		Emploee emp = empdao.get(emploee.getId());//修改后的对象
		//3.把employee对象放入值栈栈顶
//		emploee.setFirstName(emp.getFirstName());
//		emploee.setLastName(emp.getLastName());
//		emploee.setEmail(emp.getEmail());
		//不能直接写employee = empdao.get(emploee.getId())这个是新建的对象和栈顶对象没关系		
		return "edit";
	}
	public void prepareEdit() {
		emploee = empdao.get(id);
	}
	
	public String delete(){
		empdao.deleteEmploee(emploee.getId());
		//返回delete时候要重新载入列表，重定向action
		//返回结果类型为：redirectAction
		//也可以是chain，但是chain没有必要，因为不需要在下个actin中保留当前action状态
		//若使用chain，达到目标页面后地址栏依然显示的是删除的链接，刷新时会重复提交
		return "success";
		
	}
	public String save() {
		//逻辑
		//1.获取请求参数---通过对应属性的方式--getset方法
		//2.调用dao的save方法		
		empdao.saveEmploee(emploee);
		//3.通过redirect方式返回emp-list		
		return "success";
	}
	public void prepareSave() {
		emploee = new Emploee();
	}
	
	public String list() {
		request.put("emps",empdao.getEmploee());
		return "list";
	}
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		
		this.request = arg0;
		
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 * 判断是create的还是edit的
	 * 如果是创建的则emploee=new Emploee();
	 * 如果是编辑的则employee = empdao.get(emploee.getId())
	 * 判断标准为请求参数（id）
	 * 如果通过id判断则要在model driven拦截器之前执行一个param拦截器
	 * 这可以通过paramsPrepareParamsStack拦截器栈实现
	 */
	@Override
	public Emploee getModel() {
		
		return emploee;
	}
	
	
	//prepare方法的主要作用：为modeldeiven准备model
	@Override
	public void prepare() throws Exception {

		System.out.println("prepare............");
	}
	
	
	
}
