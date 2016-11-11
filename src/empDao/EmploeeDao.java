package empDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import empEntity.Emploee;

/**
 * @author k570
 * ���ݽ�����
 *
 */
public class EmploeeDao {
	private static Map<Integer, Emploee> emp = new HashMap<Integer,Emploee>();
	//static��̬������г�ʼ��
	static{
		emp.put(001, new Emploee(001, "����", "�Ҹ�1", "�ʼ���ַ11"));
		emp.put(002, new Emploee(002, "����", "�Ҹ�2", "�ʼ���ַ12"));
		emp.put(003, new Emploee(003, "����", "�Ҹ�3", "�ʼ���ַ13"));
		emp.put(004, new Emploee(004, "����", "�Ҹ�4", "�ʼ���ַ14"));
		emp.put(005, new Emploee(005, "����", "�Ҹ�5", "�ʼ���ַ15"));
		
	}
	//��ȡEmploee
	public List<Emploee> getEmploee() {
		return new ArrayList<>(emp.values());
	}
	//ɾ��(��ôɾ������˵����ʲôɾ����idɾ������ô���id��)
	public void deleteEmploee(Integer id) {
		emp.remove(id);
	}
	//���� ������ʲô������Emploee���󰡡���
	public void saveEmploee(Emploee emploee) {
		long time = System.currentTimeMillis();
		//��empһ��id
		emploee.setId((int) time);
		//���浽map��
		emp.put(emploee.getId(), emploee);
		
	}
	
	public Emploee get(Integer id) {
		return emp.get(id);
	}
	
	//�޸�(��id�ģ�����emp����ԭ����id���䣬���ݱ������Եõ�ԭ��id������emp�������map��)
	public void updateEmploee(Emploee emploee) {
		emp.put(emploee.getId(), emploee);
	}
	
}
