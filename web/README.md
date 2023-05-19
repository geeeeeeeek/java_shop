### 学习文档


#### 部署步骤

1. 修改constants.ts中的BASE_URL
2. vite build
3. 将dist部署到nginx


#### 配置解释

1. env.development 开发环境配置
2. eslintrc.js 代码规范化提示
3. vite.config.js vite 开发服务器配置

#### 常见问题

##### 变量
https://blog.csdn.net/qq_41636947/article/details/117907448

##### antd的css引入方式
在index.html里面引入的cdn

##### cdn
https://cdn.jsdelivr.net/npm/ant-design-vue@3.2.20/dist/
https://cdn.staticfile.org/ant-design-vue/3.2.20/antd.min.css

#### public文件夹内容在build后会自动打到dist中
