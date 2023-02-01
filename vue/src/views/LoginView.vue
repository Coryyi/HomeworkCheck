<template>
  <div class="login-container">
    <div class="box">
      <div class="left"></div>
      <div class="right">
        <h4>登 录</h4>
        <form action="">
          <input class="acc" type="text" v-model="loginForm.username" placeholder="用户名" id="username">
          <input class="acc" type="password" v-model="loginForm.password" placeholder="密码" id="password">
          <input class="submit" type="submit" @click="login"  value="Login">
        </form>
        <div class="fn">
          <a @click = toRegister>注册账号</a>
          <a @click = toFind>找回密码</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import router from "@/router";
import axios from "axios";

export default {
  name: "LoginView",
  data(){
    return{
      loginForm:{
        username:"",
        password:""
      },
      responseResult:[]
    }
  },
  methods:{
    toRegister(){
      router.push("register")
    },
    toFind(){
      router.push("find")
    },
    login () {
      console.log("username"+this.loginForm.username+"password:"+this.loginForm.password)
      axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              router.replace({path: '/index'})
            }
          })
          .catch(failResponse => {
          })
    }
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.login-container {


  background: linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%) no-repeat;
}

.login-container::before {
  content: '';

  width: 100%;
  height: 100%;
  position: fixed;
  top: 0px;
  left: 0px;
  z-index: -1;
  background: linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%) no-repeat;
}

::selection {
  color: #fff;
  background-color: rgb(144,129,241);

}


.box {
  display: flex;
  overflow: hidden;
  width: 900px;
  height: 550px;
  background-color: rgba(255,255,255,60%);
  border-radius: 15px;
  margin: 10% auto;
  box-shadow: 0 0 10px 2px rgb(0 0 0 / 10%);
}

.box .left {
  position: relative;
  width: 35%;
  height: 100%;
  background-color:skyblue;
}

.box .left::before {
  content: '';
  position: absolute;
  width: 100%;
  margin-left: -157.5px;
  height: 100%;
  background-image: url(../assets/left.png);
  background-size: cover;
  opacity: 80%;
}

.box .right {
  display: flex;
  width: 65%;
  flex-direction: column;
  align-items: center;
}

.box .right h4{
  color: rgb(144,129,241);
  font-size: 30px;
  margin-top: 50px;
}

.box .right form {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.box .right form .acc {
  outline: none;
  width: 80%;
  height: 50px;
  font-size: 16px;
  margin-top: 50px;
  padding: 10px 0 0 16px;
  border: none;
  border-bottom:1px solid rgb(144,129,241) ;
  color: rgb(144,129,241);
  background-color: rgba(0,0,0,0);
}

.right form .acc:focus {
  outline: none;
  color: rgb(144,129,241);
  padding: 10px 0 0 16px;
}

.right .submit {
  width: 60%;
  height: 50px;
  color: #f6f6f6;
  background-image: linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%);
  font-size: 14px;
  border: none;
  border-radius: 5px;
  margin: 60px 0 0 50%;
  transform: translateX(-50%);
}

.right .submit:hover {
  box-shadow: 0 0 20px -5px rgb(0 0 0 / 15%);
}

.right .fn {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
  width: 70%;
}

.right .fn a {
  font-size: 13px;
  margin-top: 50px;
  padding: 10px 20px;
  color: #666;
}

.right .fn a:hover {
  color: rgb(144,129,241);
}

</style>