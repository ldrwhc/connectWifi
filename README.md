# myWork

#### 介绍
配合filter抓包软件抓取post接口参数，实现一键连校园网wifi(NJUPT)

#### 使用说明

1.  连接WiFi，在弹出wifi登录确认窗口时，打开filter抓包，设置单步执行断点
2.  输入账号和密码，然后在filter里把抓取到的包稍加解析，截取其中的"upass"""0MKKey""DDDDD"三个字段的值
3.  用Java，将参数值连接到url上，post发包
4.  可以用taskkill来关闭自动弹出浏览器

