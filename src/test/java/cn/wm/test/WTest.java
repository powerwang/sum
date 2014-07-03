package cn.wm.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class WTest  {

	public static List<Permission> list = new ArrayList<Permission>();
	
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
	
	@Test
	public void shui() {
		
		
		boolean flg =false;
		Map map =this.getMap();
		Permission tou =new Permission();
		tou = (Permission) map.get("tou");
		List<Permission> list = (List<Permission>) map.get(tou.getId()+"");
//		List<Permission> p = new ArrayList<Permission>();
//		tou.setList(list);
		System.out.println("list"+list.size());
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission permission =it.next();
			Long id = permission.getId();
			this.tab(map, id+"");
//			List<Permission> per = (List<Permission>) map.get(id);
//			if(per != null && !per.isEmpty() ){
//				// 还有子集
//				permission.setList(per);
//				this.tab(map,);
//			}
//			p.add(permission);
		}
//		tou.setList(p);
		tou = (Permission) map.get("tou");
		System.out.println("=======================");
	}
	
	
	
	public void tab(Map map,String keyId){
		
		
		boolean flg =false;
		List<Permission> list = (List<Permission>) map.get(keyId);
		List<Permission> p = new ArrayList<Permission>();
		if(list != null && !list.isEmpty()){
			for(Iterator<Permission> it=list.iterator();it.hasNext();){
				Permission permission =it.next();
				Long id = permission.getId();
				List<Permission> per = (List<Permission>) map.get(id+"");
				if(per != null && !per.isEmpty() ){
					// 还有子集
					flg =true;
					for(Iterator<Permission> pl=per.iterator();pl.hasNext();){
						this.tab(map, pl.next().getId()+"");
					}
					permission.setList(per);
				}
				p.add(permission);
			}
			map.put(keyId, p);
		}
	}
	
	public void tab2(Map map,String keyId){
		
		
		boolean flg =false;
		List<Permission> list = (List<Permission>) map.get(keyId);
		List<Permission> p = new ArrayList<Permission>();
		for(Iterator<Permission> it=list.iterator();it.hasNext();){
			Permission permission =it.next();
			Long id = permission.getId();
			List<Permission> per = (List<Permission>) map.get(id+"");
			if(per != null && !per.isEmpty() ){
				// 还有子集
				flg =true;
				for(Iterator<Permission> pl=per.iterator();pl.hasNext();){
					this.tab(map, pl.next().getId()+"");
				}
				permission.setList(per);
			}
//			while(flg){
//				this.tab(map);
//			}
			p.add(permission);
		}
		map.put(keyId, p);
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
