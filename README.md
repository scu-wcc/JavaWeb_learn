# JavaWeb_learn
记录本人JavaWeb学习过程

Web前端结构: HTML(结构)+CSS(表现)+JS(动作与交互)

HTML：超文本标记语言。
	
	-标签不区分大小写
	-属性值可用单引号和双引号
	-语法较为松散

img中src路径分为绝对路径/相对路径

	-绝对路径: 绝对磁盘路径/绝对网络路径(需要联网)。
	-相对路径: 相对于当前文件夹路径。
	
CSS引入方式:
	
	1.行内引入。只控制当个标签。
	2.内嵌引入。只控制本文件中标签，一般定义在head标签中。
	3.外联引入。在外部css文件中定义样式，由link引入。
	
在标签中可以添加id、class来分类标签，一般id值唯一，而class可以相同。

通过使用不同的选择器，指定修改的标签。优先级:id选择器 > 类选择器 > 元素选择器
	
	元素选择器: 元素{   }
	类选择器: .类名{   }
	id选择器: #id值{   }	
	
超链接:<a href="跳转路径" target="是否在新页面打开"></a>；可以通过css设置超链接样式。	

盒子模型:将页面内元素看成一个盒子，更好操作。相关标签<div>\<span>

相关内容: content-padding-border-> margin外边距，不属于盒子。

	样式设计:
	        div {
            width: 200px; //盒子宽度
            height: 200px; //盒子高度
            box-sizing: border-box; //上述宽高作用的范围，当前是对border级别生效

            padding: 20px;//设置盒子的内边距区域
            border: 50px solid gold; //设置盒子的边框
            margin: 30px;  //设置外边界区域(盒子外部区域的上右下左)

        }
	
表格标签:

	<table border:表格边框  cellspacing:单元格的间隔  width:表格宽度> 
		<tr>//表行
			<th>表头单元格</th>
			
			<td>普通单元格</td>
			......
		</tr>
	</table>	
	
	
表单标签: form

	属性: action="数据提交到的URL"
	      method="提交数据的方式"
			get: 将表单数据接在url后，这样提交的数据长度(大小)有限制
			post: 将数据提交到post报文中，可以携带的数据量较大。
	
	表单项:
		input ：可以是输入框、单选、多选、时间列表、电子邮件、数字等等
			type: 控制输入的类型，如果是submit就会触发method提交数据
			name: 如果想要提交该项的内容，必须有name属性，用于标记返回的数据键值对：name1=value1&name2=value2
			value: 值	
		
		select:下拉列表
		textarea:文本域
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	