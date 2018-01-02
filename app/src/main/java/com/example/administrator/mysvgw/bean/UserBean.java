package com.example.administrator.mysvgw.bean;

import java.io.Serializable;

/**
 * Created by whq on 2017/12/27.
 */

public class UserBean implements Serializable {

    /**
     * code : 0000
     * msg : 成功
     * data : {"userName":"13161312285","email":"13161312285@mob.com","phoneMob":"13161312285","realName":"测试","sex":1,"birthday":null,"imQq":null,"imMsn":null}
     */
        /**
         * userName : 13161312285
         * email : 13161312285@mob.com
         * phoneMob : 13161312285
         * realName : 测试
         * sex : 1
         * birthday : null
         * imQq : null
         * imMsn : null
         */

        private String userName;
        private String email;
        private String phoneMob;
        private String realName;
        private int sex;
        public String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        private Object birthday;
        private Object imQq;
        private Object imMsn;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneMob() {
            return phoneMob;
        }

        public void setPhoneMob(String phoneMob) {
            this.phoneMob = phoneMob;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getImQq() {
            return imQq;
        }

        public void setImQq(Object imQq) {
            this.imQq = imQq;
        }

        public Object getImMsn() {
            return imMsn;
        }

        public void setImMsn(Object imMsn) {
            this.imMsn = imMsn;
        }
}
