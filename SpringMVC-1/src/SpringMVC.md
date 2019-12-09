# SpringMVC
## 作用
接受浏览器的请求，对数据进行处理后，返回页面进行显示。
## 执行流程
* 1.用户发送请求到前端控制器(DispatcherServlet)
* 2.DispatcherServlet 请求处理器映射器(HandlerMapping)查找处理器(Handler)
* 3.HandlerMapping 向 DispatcherServlet 返回查找到 Handler
* 4.DispatcherServlet 再调用处理器适配器(HandlerAdapter)去执行 Handler
* 5.Handler 执行完成后，给 HandlerAdapter 返回 ModelAndView
* 6.HandlerAdapter 再把 ModelAndView 返回给 DispatcherServlet
* 7.DispatcherServlet 请求视图解析器(ViewResolver)对 ModelAndView 进行视图解析
* 8.ViewResolver 解析完成后向 DispatcherServlet 返回视图
* 9.DispatcherServlet 进行视图渲染
* 10.DispatcherServlet 向用户响应结果
## 解析
* 1.Spring的Web框架围绕着DispatcherServlet设计。用户发出请求(HttpServletRequest request)后，DispatcherServlet接收并拦截请求，请求以url的形式出现
     假设请求的url为 http://localhost:8080/SpringMVC/hello  
     如上url拆分成三部分：  
     http://localhost:8080 表示服务器域名和端口号  
     SpringMVC 表示部署在服务器上的web站点，也就发布的时候指定的项目名  
     hello 表示控制器  
     如上url表示为：请求位于localhost:8080上的 SpringMVC 站点的 hello 控制器
* 2.DispatcherServlet 会请求 HandlerMapping 根据拦截到的请求(url)查找处理器(Handler)
* 3.HandlerMapping 会把请求映射为 HandlerExecutionChain 类型的 handler 对象
* 4.DispatcherServlet 再从所有 HandlerAdapter 中找到可以处理我们获得的 handler 的 HandlerAdapter 对象，调用方法执行该 handler 后返回一个ModelAndView
* 5.HandlerAdapter 将 ModelAndView 传递给 DispatcherServlet
* 6.DispatcherServlet 调用视图解析器去解析
* 7.视图解析器将解析的结果返回给 DispatcherServlet
* 8.DispatcherServlet 根据结果调用具体的视图，渲染页面并响应用户

