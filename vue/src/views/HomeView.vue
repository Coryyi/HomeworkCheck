<template>
  <div class="home">
    <div class="image_1">
      <div class="word">
        与肝胆人共事，无字句处读书 --周恩来
      </div>
    </div>

    <div class="bg">轻量级作业检查网页</div>

    <div class="image_2">
      <div class="word">
        生如夏花之绚烂，死如秋叶之静美 --泰戈尔

      </div>
    </div>

    <div class="bg">简单、高效、快捷</div>

    <div class="image_3">
      <div class="word">
        陪伴是最长情的告白，而守护是最沉默的陪伴 --耀一

      </div>
    </div>

    <div class="bg">支持上传文件以及拍照上传</div>

    <div class="image_4">
      <div class="word">
        我要在窗子上，全蒙上帷幔，让所有习惯光明的眼睛，都习惯黑暗 --余华
      </div>
    </div>

    <div class="bg">可跨平台使用的web</div>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/login">sign in</router-link> |
      <router-link to="/register">sign up</router-link>

    </nav>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
<style scoped>
*{
  padding: 0;
  margin: 0;
}

nav {
  padding: 20px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
.image_1{
  background-image: url("../assets/bg/bg1.jpg");
  background-position: 0 0;
  background-attachment: fixed;
  background-size: cover;
  height: 980px;
  width: 100%;

}
.image_2{
  background-image: url("../assets/bg/bg2.jpg");
  background-position: 0 0;
  background-attachment: fixed;
  background-size: cover;
  height: 980px;
  width: 100%;

}
.image_3{
  background-image: url("../assets/bg/bg3.jpg");
  background-position: 0 0;
  background-attachment: fixed;
  background-size: cover;
  height: 980px;
  width: 100%;

}
.image_4{
  background-image: url("../assets/bg/bg4.jpg");
  background-position: 0 0;
  background-attachment: fixed;
  background-size: cover;
  height: 980px;
  width: 100%;

}
.word{
  position: relative;
  top: 480px;
  font-size: 55px;
  color: white;
  text-align: center;
  font-weight: bolder;
}
.bg{
  text-align: center;
  font-size: 46px;
  font-weight: bolder;
  height: 220px;
  line-height: 220px;
  background-color: rgb(166,168,240);
  color:white;
}
</style>
