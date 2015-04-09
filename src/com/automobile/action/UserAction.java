package com.automobile.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.automobile.model.User;
import com.automobile.service.IUserService;
import com.automobile.util.SystemConst;
import com.automobile.util.SystemUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户action
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private IUserService userService;
	private JSONObject resultObject;
	
	public String checkLogin() {
		HttpServletRequest request =  ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return "ok";
		}
		if (null==username && username.trim().equals("") && null == password && password.trim().equals("")) {
			return "input";
		}
		if (!userService.isExits(username)) {
			return "input";
		}
		User u = userService.login(username, password);
		if (u!=null) {
			session.setAttribute("user", u);
			return "ok";
		}else {
			return "input";
		}
	}
	
	public String userInfoManage() {
		
		return "ok";
	}
	
	public void addUserInfo() {
		String msg ="";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("html/text;charset=UTF-8");
		PrintWriter out = null;
		try{
		out = response.getWriter();
		String type = request.getParameter("type");
		System.out.println("type====>"+ type);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role_id = request.getParameter("role_id");
		String  telephone = request.getParameter("telephone");
		String  nickname = request.getParameter("nickname");
		String  email = request.getParameter("email");
		String  des = request.getParameter("des");
		String  remark = request.getParameter("remark");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole_id(Integer.parseInt(role_id));
		user.setCreatetime(SystemUtil.getSysCurentTime());
		System.out.println("[=========="+username+"============="+password+"==="+nickname);
		user.setNickname(nickname);
		user.setTelephone(telephone);
		user.setEmail(email);
		user.setDescription(des);
		user.setRemark(remark);
		if("edit".equals(type))  {			
			String  user_id = request.getParameter("user_id");
			user.setUser_id(Integer.parseInt(user_id));
			userService.update(user);
			msg = "修改用户信息成功！修改的用户名是："+ username;
		}else {
	
			userService.save(user);
			msg = "添加用户成功！添加的新用户名是："+ username;
		}
		}catch(Exception e ){
			msg = "操作失败!";
		}
		out.print(msg);
		out.flush();
		out.close();
	}
	
	public void delUserInfo(){
		String msg ="";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("html/text;charset=UTF-8");
		PrintWriter out = null;

		try{
		String user_id = request.getParameter("user_id");
		User user = userService.findUserById(Integer.parseInt(user_id));
		out = response.getWriter();
		System.out.println("[=========="+user.getUser_id()+"============="+user.getUsername());
		userService.delete(user);
		msg = "删除用户成功！删除的用户名是："+ user.getUsername();
		}catch(Exception e ){
			msg = "删除用户失败!";
		}
		out.print(msg);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public String showUserListAll(){
		List<User> userList = userService.showUserListAll();
		Map  map = new HashMap();
		List listMap = new ArrayList();
		for (int i = 0; i < userList.size(); i++) {
			Map<String,String> m =new HashMap();
			m.put("user_id", userList.get(i).getUser_id().toString());
			m.put("username",userList.get(i).getUsername());
			m.put("password",userList.get(i).getPassword());
			
			if (userList.get(i).getNickname()!=null) {
				m.put("nickname",userList.get(i).getNickname());
			}else{
				m.put("nickname","");
			}
			if(userList.get(i).getRole_id()!=null) {
				m.put("role_id",userList.get(i).getRole_id().toString());
			}else{
				m.put("role_id","");
			}
			if(userList.get(i).getTelephone()!=null) {
				m.put("telephone",userList.get(i).getTelephone());
			}else {
				m.put("telephone","");
			}
			if (userList.get(i).getEmail()!=null) {
				m.put("email",userList.get(i).getEmail());
			}else {
				m.put("email","");
			}
			if (userList.get(i).getCreatetime()!=null) {
				m.put("createtime",SystemUtil.formatDate(userList.get(i).getCreatetime()));
			}else {
				m.put("createtime","");
			}
			if(userList.get(i).getDescription()!=null) {
				m.put("description",userList.get(i).getDescription());
			}else {
				m.put("description","");
			}
			if(userList.get(i).getRemark()!=null) {
				m.put("remark",userList.get(i).getRemark());
			}
			listMap.add(m);
		}
		map.put("total", userList.size());
		map.put("rows", listMap);
		resultObject = JSONObject.fromObject(map);
		System.out.println(resultObject);
			return SUCCESS;
	}
	
	
//	public void getUserAllList() {
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("html/text;charset=UTF-8");
//		Map  map = new HashMap();
//		List listMap = new ArrayList();
//		for (int i = 0; i < 3; i++) {
//			Map<String,String> m =new HashMap();
//			m.put("itemid",i+"item");
//			m.put("productid","productid"+i);
//			listMap.add(m);
//		}
//		map.put("rows", listMap);
//		resultObject = JSONArray.fromObject(map);
//		System.out.println(resultObject);
//		try {
//			PrintWriter out = response.getWriter();
//			out.print(resultObject.toString());
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	@JSON(serialize=false)
//	public IUserService getUserService() {
//		return userService;
//	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	public JSONObject getResultObject() {
		return resultObject;
	}
	
//	public void setResultObject(JSONObject resultObject) {
//		this.resultObject = resultObject;
//	}

	

		

	
	
}
