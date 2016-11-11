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
	//��Ҫ�ڵ�ǰEmploeeAction�����¶���emploeeId���������������
	private EmploeeDao empdao = new EmploeeDao();
	private Emploee emploee;
	
	//��ΪҪ����id�ж�emploee��״̬���Ե��ó���
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
		//1.��ȡemployeeId
		
		//2.��id��ȡ��employee����
//		Emploee emp = empdao.get(emploee.getId());//�޸ĺ�Ķ���
		//3.��employee�������ֵջջ��
//		emploee.setFirstName(emp.getFirstName());
//		emploee.setLastName(emp.getLastName());
//		emploee.setEmail(emp.getEmail());
		//����ֱ��дemployee = empdao.get(emploee.getId())������½��Ķ����ջ������û��ϵ		
		return "edit";
	}
	public void prepareEdit() {
		emploee = empdao.get(id);
	}
	
	public String delete(){
		empdao.deleteEmploee(emploee.getId());
		//����deleteʱ��Ҫ���������б��ض���action
		//���ؽ������Ϊ��redirectAction
		//Ҳ������chain������chainû�б�Ҫ����Ϊ����Ҫ���¸�actin�б�����ǰaction״̬
		//��ʹ��chain���ﵽĿ��ҳ����ַ����Ȼ��ʾ����ɾ�������ӣ�ˢ��ʱ���ظ��ύ
		return "success";
		
	}
	public String save() {
		//�߼�
		//1.��ȡ�������---ͨ����Ӧ���Եķ�ʽ--getset����
		//2.����dao��save����		
		empdao.saveEmploee(emploee);
		//3.ͨ��redirect��ʽ����emp-list		
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
	 * �ж���create�Ļ���edit��
	 * ����Ǵ�������emploee=new Emploee();
	 * ����Ǳ༭����employee = empdao.get(emploee.getId())
	 * �жϱ�׼Ϊ���������id��
	 * ���ͨ��id�ж���Ҫ��model driven������֮ǰִ��һ��param������
	 * �����ͨ��paramsPrepareParamsStack������ջʵ��
	 */
	@Override
	public Emploee getModel() {
		
		return emploee;
	}
	
	
	//prepare��������Ҫ���ã�Ϊmodeldeiven׼��model
	@Override
	public void prepare() throws Exception {

		System.out.println("prepare............");
	}
	
	
	
}
