## 前后端分离项目模版

包含基本的登录、注册、密码重置等等功能，可以二次开发编写具体场景下的应用程序。

* 登录功能（支持用户名、邮箱登录）
* 注册用户（通过邮箱注册）
* 重置密码（通过邮箱重置密码）

登录功能：
1. 用户登录成之后，才能访问index路径下的页面
2. 用户如果没有登录，那么会自动跳转到登录界面
3. 如果用户请求的是一个压根就不存在的页面，依然强制回到登录界面，如果已经登录，那么回到index首页

登录解决方案
1. 无论是否已经登录，直接向后端请求用户信息
2. 如果请求成功，那么说明肯定是已经登录了
3. 如果请求失败，那么说明没有登录，跳转到登录界面


部署步骤：
- 后端：
  1. 修改 application.yml 为本机配置
  2. 配置好本地redis数据库与mysql数据库，并启动
  ```shell
    #redis启动
    ./redis-server.exe redis.windows.conf
    ./redis-cli.exe 
  ```
  3. 加载maven依赖
- 前端：
  1. 进入cet-frontend，运行命令安装相关依赖
  ```sh
  npm install
  ```
运行步骤：
1. 在后端编译好spring boot application，然后启动项目
2. 在前端启动vue项目
```shell
  npm run dev
```

⭐已存在的账号：
**student**:
- admin 1262426565@qq.com 123456

**teacher**:
- 杨飓风 zhangshuui@gmail 123456

⚠️可能遇到的Bug：
1. 注意运行npm指令时当前terminal是否为管理员权限
2. 注意pom包中是否同时含有`spring-boot-starter-data-jdbc`与`mysql-connector-j`,否则可能出现无法加载JDBC对象的错误（另外，修改dependency后请记得随时刷新maven依赖）
3. ...
