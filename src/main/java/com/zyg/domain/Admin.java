package com.zyg.domain;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/29 18:58
 */
public class Admin {
   private String username;
   private String password;
   private String roles;
   private String token;
   private String avatar;

   public String getAvatar() {
      return avatar;
   }

   public void setAvatar(String avatar) {
      this.avatar = avatar;
   }

   @Override
   public String toString() {
      return "Admin{" +
              "username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", roles='" + roles + '\'' +
              ", token='" + token + '\'' +
              ", avatar='" + avatar + '\'' +
              '}';
   }

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
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

   public String getRoles() {
      return roles;
   }

   public void setRoles(String roles) {
      this.roles = roles;
   }
}
