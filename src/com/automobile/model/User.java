package com.automobile.model;

import java.util.Date;

public class User {
		
		private Integer user_id;  //�û�����
		private String username;  //�û���
		private String password; //����
		private String nickname;  //�û�����
		private Integer  role_id;  //�û���ɫ
		private String description; //ְλ����
		private String telephone; //��ϵ��ʽ
		private String email;
		private Date createtime; //����ʱ��	
		private String  remark;//��ע
		
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
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
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Integer getRole_id() {
			return role_id;
		}
		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
	
	
		
}
