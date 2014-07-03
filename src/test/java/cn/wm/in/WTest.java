package cn.wm.in;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;





public class WTest  {

	public static List<Permission> list = new ArrayList<Permission>();
	//all child of list
	public static List<Permission> childlist = new ArrayList<Permission>();
	
//	public static Permission tou =new Permission();
	
	static {
		Permission p = new Permission();
		p.setId(1L);
		p.setName("wang");
		list.add(p);
		
		Permission p1 = new Permission();
		p1.setId(2L);
		p1.setName("shui");
		p1.setParentId(1L);
		list.add(p1);
		
		Permission p3 = new Permission();
		p3.setId(4L);
		p3.setName("tian");
		p3.setParentId(1L);
		list.add(p3);
		
		Permission p2 = new Permission();
		p2.setId(3L);
		p2.setName("min");
		p2.setParentId(2L);
		list.add(p2);
		
		Permission p4 = new Permission();
		p4.setId(5L);
		p4.setName("xia");
		p4.setParentId(2L);
		list.add(p4);
		
		
		Permission p5 = new Permission();
		p5.setId(6L);
		p5.setName("su");
		p5.setParentId(3L);
		list.add(p5);
		
		Permission p6 = new Permission();
		p6.setId(7L);
		p6.setName("aa");
		p6.setParentId(3L);
		list.add(p6);
		
	}
	
	public static void main(String[] args) {
	
		
		Permission permission = new Permission();
		permission.setId(1L);
		permission.setName("wang");
		permission.setList(childlist);
		
		WTest test = new WTest();
//		test.shui(permission.getId());
//		if(childlist.size() > 0)
//		{
//			for (int i = 0; i < childlist.size(); i++) {
//				System.out.println(childlist.get(i).getId());
//			}
//		}
		
		test.tab(permission);
		System.out.println(permission);
		
		
		
	}
	/**
	 *  iteration get all child from list
	 */
	public void shui(long id) {
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission permission =it.next();
			//find this list all item , which id = pid , add in childlist ,continue;
			if(id == permission.getId()){
				this.getById(id);
				break;
			}
		}
	}
	//���ȫ����ֱ�Ӻ��
	public void getById(long pid){
		//all pid = 1
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission p = (Permission)it.next();
			if(p.getParentId() !=null && pid == (p.getParentId())){
				childlist.add(p);
				this.shui(p.getId());
			}
		}
	}
	
	
	
	/**
	 * ά���㼶��ϵ
	 * ͨ��idֵ���ҵ�ȫ�������νṹ
	 * 
	 * �ܵ���һ�� list ������
	 * @param map
	 * @param keyId
	 */
	public void tab(Permission permission){
		//all pid = 1
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission p = (Permission)it.next();
			if(p.getParentId() !=null && permission.getId() == (p.getParentId())){
				if(permission.getList()==null){
					permission.setList(new ArrayList<Permission>());
				}
				permission.getList().add(p);
				this.tab(p);
			}
		}
	}
	
	
	public Map getMap(){
		Map map = new HashMap();
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission permission =it.next();
			long id = permission.getId();
//			System.out.println(id);
			Long parentId =permission.getParentId();
//			System.out.println(parentId);
			if(parentId != null && parentId != 0){
				List<Permission> per =(List<Permission>) map.get(parentId+"");
				if(per != null && !per.isEmpty()){
					per.add(permission);
					map.put(parentId+"", per);
				}else {
					List<Permission> permissions = new ArrayList<Permission>();
					permissions.add(permission);
					map.put(parentId+"", permissions);
				}
			}else {
			   map.put("tou", permission);	
			}
		}
		return map;
	}
	
//	@Test
//	public void wang() {
//		
//	
//		Map map = new HashMap();
//		for(Iterator<Permission> it=list.iterator();it.hasNext();){
//			Permission permission =it.next();
//			long id = permission.getId();
//			System.out.println(id);
//			Long parentId =permission.getParentId();
////			System.out.println(parentId);
//			if(parentId != null && parentId != 0){
//				List<Permission> per =(List<Permission>) map.get(parentId+"");
//				if(per != null && !per.isEmpty()){
//					per.add(permission);
//					map.put(parentId+"", per);
//				}else {
//					List<Permission> permissions = new ArrayList<Permission>();
//					permissions.add(permission);
//					map.put(parentId+"", permissions);
//				}
//			}else {
//			   map.put("tou", permission);	
//			}
//		}
//		
//		
//		System.out.println("==============================");
//		Set set = map.keySet();
//		for(Iterator it = set.iterator();it.hasNext();){
//			System.out.println(it.next());
//		}
//		
//		Permission tou =new Permission();
//		tou = (Permission) map.get("tou");
//		for(Iterator<Permission> it=list.iterator();it.hasNext();){
//			
//			Permission permission =it.next();
//		}
//	}

	
}
