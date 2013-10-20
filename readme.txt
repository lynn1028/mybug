mybug是一个小小的bug管理系统
=====================================
主要功能：
	用户管理
		增、删、改、查
		每个用户拥有0个或多个bug
	Bug管理	
		增、删、改、查
		一个bug只能是属于一个用户
=====================================		
数据库：mysql 5.5以上
大概的数据结构:
	user表:
		id
		username
		password
	bug表:
		id
		title
		content
		status
		createDate
		user_id
=====================================
整体架构：
	jsp + servlet + service + jdbc
	很简单的结构，页面是jsp， 处理请求是servlet，业务逻辑是在service这一层，为简单起见，在service层里直接操作数据库。
	没有spring, 没有struts，没有hibernate，用的都是原始的一些技术，对熟悉java的基本应用很有帮助。并且，可以在这个简单的版本上，逐步地重构,
    比如加入一些常用的框架等。这是一个循序渐进的过程。		
				
		