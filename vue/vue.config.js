const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    // 代理
    proxy: {
      "/api": { // '/api/' 等同于 target 中的地址
        // 跨域的服务器地址
        target: "http://127.0.0.1:8083",
        // 是否允许跨域
        changeOrigin: true,
        pathRewrite: {
          // 正则--遇到有devApi开头替换成空---需要重写的路径
          "^/api": "", // ^/api 做替换
        },
      },
    }
  },
})

