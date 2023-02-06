<template>
  <div class="login-container">
    <div class="box">
      <div class="left"></div>
      <div class="right">
        <h4>注 册</h4>
        <form action="">
          <input class="acc" v-model="registerFrom.username" type="text" placeholder="用户名">
          <input class="acc" v-model="registerFrom.password" type="password" placeholder="密码">
          <input class="acc" v-model="registerFrom.pwd" type="password" placeholder="请再次输入密码">
          <input class="submit" type="button" @click="register" value="Register">
        </form>
        <div class="fn">
          <a @click = toLogin>已有账号</a>
          <a @click=toFind>找回密码</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "RegisterView",
  data(){
    return{
      registerFrom:{
        username:"",
        password:"",
        pwd:""
      },
      responseResult:[]
    }
  },
  methods:{
    toLogin(){
      router.push("login")
    },
    toFind(){
      router.push("find")
    },
    register(){
      if(this.registerFrom.username.length<5||this.registerFrom.username.length>20){
        alert(this.registerFrom.username.length)
        alert("用户名不能少于5字符或多余20字符")

        return;
      }
      if(this.registerFrom.password.length <8||this.registerFrom.password.length>15){
        alert("密码不能少于8位或多余15位")
        return;
      }
      if(this.registerFrom.password !== this.registerFrom.pwd){
        alert("两次密码不同")
        return;
      }



      this.$axios
          .post('/register', {
            username: this.registerFrom.username,
            password: this.registerFrom.password
          })
          .then(successResponse => {
            if (successResponse.data.code===200) {
              router.replace("login")

            }else {
              alert("注册失败")
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
  margin-top: 30px;
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
  margin-top: 30px;
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
