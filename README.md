# JavaWeb_learn
记录本人JavaWeb学习过程

Web前端结构: HTML(结构)+CSS(表现)+JS(动作与交互)

1.HTML：超文本标记语言。
	
	-标签不区分大小写
	-属性值可用单引号和双引号
	-语法较为松散

img中src路径分为绝对路径/相对路径

	-绝对路径: 绝对磁盘路径/绝对网络路径(需要联网)。
	-相对路径: 相对于当前文件夹路径。
	
2.CSS引入方式:
	
	1.行内引入。只控制单个标签。
	2.内嵌引入。只控制本文件中标签，一般定义在head标签中。
	3.外联引入。在外部css文件中定义样式，由link引入。
	
在标签中可以添加id、class来分类标签，一般id值唯一，而class可以相同。

通过使用不同的选择器，指定修改的标签。优先级:id选择器 > 类选择器 > 元素选择器
	
	元素选择器: 元素{   }
	类选择器: .类名{   }
	id选择器: #id值{   }	
	
超链接:<a href="跳转路径" target="是否在新页面打开"></a>；可以通过css设置超链接样式。	

3.盒子模型:将页面内元素看成一个盒子，更好操作。相关标签<div>\<span>

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
	
4.表格标签:

	<table border:表格边框  cellspacing:单元格的间隔  width:表格宽度> 
		<tr>//表行
			<th>表头单元格</th>
			
			<td>普通单元格</td>
			......
		</tr>
	</table>	
	
	
5.表单标签: form

	属性: action="数据提交到的URL"
	      method="提交数据的方式"
			get: 将表单数据接在url后，这样提交的数据长度(大小)有限制
			post: 将数据提交到post报文中，可以携带的数据量较大。
	
	表单项:
		input ：可以是输入框、单选、多选、时间列表、电子邮件、数字等等
			type: 控制输入的类型，如果是submit就会触发method提交数据
			name: 如果想要提交该项的内容，必须有name属性，用于标记返回的数据键值对：name1=value1&name2=value2
			value: 显示/提交的值	
		
		select:下拉列表
		textarea:文本域
	
6.JS：跨平台、面向对象的脚本语言；
脚本语言:不需要编译，由浏览器(解释器)直接解释。
	
	三种输出语句:
		    <!-- 方式1：弹窗警告 -->
    <script> window.alert('window.alert') </script>
    
    <!-- 方式2：输出在html页面 -->
     <script> document.write('document.write') </script>

    <!-- 方式3：输出在浏览器控制台 -->
     <script> console.log('console.log') </script>
	
变量:类似python，对变量赋值类型不做限制

		-var：作用域大，相当于全局变量，定义的变量可以跨{ }使用；并且var可以重复定义同名变量。
		-let：作用域小，类似于局部变量，无法跨{ }使用；
		-const：定义常量，该变量只能赋值一次，无法跨{ }使用。
	
	数据类型
		原始类型:number、string、boolean、null(空对象)、undefined(未初始化)；
		引用类型:对象
	
运算符:特殊的: ===：严格相等

	==：比较时先判断数据类型，类型不同则转换成相同的，然后再比较值。
	===:严格相等，当数据类型不同时直接返回false
	
类型转换:
	
	string->number: parseInt(s)/parseFloat(s)：返回s前面字符符合要求的数字，如果一位都没有，返回NaN
	其他类型-> boolean：0、NaN、空字符串""、null、undefined为false，其他为true
	
函数:
	
	定义方式:
		1.function functionName(参数1,参数2,......){
			函数体
		}
		
		2.var functionName = function(参数1,参数2,......){
			函数体
		}
		
		调用方式相同: functionName(参数1......)
		调用时传参可以传入不定参数，方法只会接收自己需要的前N个参数。
	
数组:类似Java中的集合，但比集合的限制更少
		
	1.长度可变。
	2.可以定义任意索引处的值，中间被跳过的索引处值为undefined。
	
	方法:forEach(方法):遍历有值的元素。
		 push(......)向数组末尾处添加元素。
		 splice(start, number)从指定索引处开始，删除number个元素。

箭头函数: (参数) => {方法体}	
	
字符串:与Java中类似。
		
	trim():去除开头与结尾的空格。
	s.indexOf("str"):该str在s中出现的首位索引。
	substring()、charAt()......
	
自定义对象:
	
	var user ={
            name: "Tom",
            age: 23,
            gender: "male",

			/*
			eat: function(){
                alert(user.name+"吃饭")
            } 
			*/
           eat(){
            alert(user.name+"正在吃饭")
           }
        }
		
        alert(user.name)
        user.eat()

JSON:本质上是一个字符串，格式与自定义对象类似，但key要使用双引号，最外层要使用单引号。
	
	var myJSON='{ "name": xxx, ......}'
	
	JSON.parse(JSON): 将json转换为对象；
	
	JSON.stringify(obj): 将对象转换为JSON；
	如果对象中有方法，则忽略方法。
<img height="350" src="img/JSON值的载体格式.png" width="300"/>	

BOM: 浏览器对象模型，由当前浏览器页面组成
    
    window对象:当前浏览器窗口对象。
        -属性history，location，navigator
        -方法
            1.alert:确认弹窗
            2.confirm:选择弹窗,返回false/true
            3.setInterval: 按照指定周期来调用函数
            4.setTimeout: 在指定毫秒数后调用某个函数。
        location：当前页面的导航栏
            location.href：获取/设置当前当前页面的url
            href=href，页面会进行跳转

DOM: 文件对象模型，将整个html页面视为document，标签为element
    
    1.每个标签有自己的属性和内容
    2.通过window.document.getBy[id | className | name | elementName]可以获取想要的标签
    3.对标签中的属性、内容进行处理。

事件监听: 给元素绑定一个事件，当事件触发是会执行相应的操作。

    绑定操作:
        1.在标签内部使用 事件名="函数名()"；
        2.在script中获取标签(元素)，通过元素.事件名= function(){
                                                        函数体
                                                        }
        
常见的事件:
<img height="300" src="img/常见的监听事件.png" width="600"/>
	
Vue框架: view-model-viewmodel模型。
	
	1.需要先导入vue.js
	2.在script中创建Vue对象，
	  指定
		el:"#id", 该Vue对象实际控制的区域
		data: {......}, 该Vue的数据模型
		methods: { ...... }, 该Vue的函数模型
	3. 插值表达式：{{ }}
	4.可以使用this.name来调用该Vue的data中的name数据。
		
常用指令:
	
	v-bind:属性="data"(:属性="data"); 绑定标签的属性如href\css样式，这样就可以使用Vue中data部分的属性作为属性值，从而达到动态修改。
	v-model="data"; 在表单/input等上创建双向绑定，表单上被修改的数据实时映射到Vue的data对应数据中。
	v-on:事件="method"(@事件="method"); 为这个标签绑定事件。 
	
	v-if-else-if="condition":判断为true,则会在页面上渲染，否则不渲染。
	v-show="condition": 无论判断是否为true都会渲染，通过display来控制是否展示。
	v-for="(item, index) in items"; items为data中的数组，item为临时变量，index可有可无，为索引。
	
	
Vue的生命周期:一共有八个阶段，每个生命周期都有其对应的自动执行的生命周期方法(钩子方法)

	生命周期方法与methods、data平级，在Vue到达相应的生命周期阶段时自动执行
	
7.Ajox-Axios：异步请求
	
	由于原生Ajox的繁琐性，已经被逐步淘汰，可以使用其封装类来简化操作
	-Axios: 需要导包
		完整写法:
			function name(){
			axios({
				method:"",
				url:""
				[data:"",]
				[confing:"",]
				
				//回调函数，用于处理得到的数据。result为返回的数据
			}).then(result =>{方法体})
			}
		简化写法:
		function name(){
			axios.get/delete/post/put(url [,data [,config]]).then(result => {方法体})   
		}  

前后端分离: 需求分析->API接口文档->并行开发->分离测试->联调测试	

8.使用Vue工程化开发。

创建的Vue项目具有热部署的性质: 修改的内容实时映射到浏览器页面上，不需要刷新页面。	

		1.配置NodeJS环境，导入vue/cli脚手架。
		2.创建vue项目(使用命令行/图像UI)
		3.在VSCode中导入创建好的Vue项目:
			node_modules: 项目依赖包
			public: 项目静态文件
			src: 项目源码
			package.json: 模型基本信息，项目模块，版本信息
			vue.config.js: vue配置
			......
		4.启动Vue项目

.vue文件:组件文件:
		 
	-template：模板，编写HTML代码。
	-style：控制CSS样式。
	-script：控制模板的数据来源与行为。
		使用export default{
				data: function(){
				return{
					message:"要返回的数据"
					}
				},
				method: {
				 方法
				}
			
			}

自己编写组件时要按照:PascalCase/kebab-case来命名，这样Vue才能正确识别并转换: ElementView->element-view	
自己编写的vue组件需要在根组件(APP.vue)中使用:<element-view></element-view>导入

9.完整创建一个Vue项目:
	
	1.在main.js中导入ElementUI组件
	2.在src/views中创建自己的组件。
	3.在src/router/index.js为自己创建的组件配置路由:
		{
			path: '/dept', //http://localhost:7000/#/dept; #:URL的哈希
			name: 'dept',  //该路由的名字
			component: () => import( '../views/tlias/EmpView.vue') //展示的组件
		}
		  
		{	//配置默认路由
			path: '/',   //当打开页面时展示根地址
			redirect: "/dept"  //将根地址重路由到上面定义过的某个地址
		}
	4.将根组件(APP.vue)中展示的内容改为:<router-view></router-view>;//根据路由地址展示页面
	5.为某个组件配置跳转超链接: <router-link to="/dept">xxxx</router-link>; 此时点击xxxx就会跳转到配置好的/dept组件。
	6.打包和部署:点击build打包当前vue项目到dist文件夹中，导入nginx的http文件夹中，运行nginx，在浏览器输入http://localhost:prot即可访问。
	
Vue路由:<img height="200" src="img/Vue路由.png" width="600"/>

10.Maven：管理和构建Java项目的工具。

Maven坐标:
	
	-groupId: 当前Maven项目隶属的组织名称
	-artifactId: 当前Maven项目名称
	-version: 当前项目的版本号
	
依赖管理(Maven核心)：

	1.依赖配置：引入依赖

		1.在pom文件中编写:<dependencies>标签，在这个标签中导入依赖；
		2.编写<dependency>标签，每个<dependency>都单独管理一个依赖；
		3.定义坐标的groupId、artifactlId、version；
		4.点击刷新，引入最新加入的坐标。
		
		<dependencies>
			<dependency>
				<groupId>ch.qos.logback</groupId>
				<artifactId>logback-classic</artifactId>
				<version>1.2.12</version>
			</dependency>
			......
		</dependencies>
		
	2.依赖传递: 直接依赖与间接依赖
		
		projectA引入依赖projectB时，会将B所依赖的配置projectC一起导入，此时A也依赖C，A对C是间接依赖，对B是直接依赖。
		如果不想引入C，此时需要排除依赖: exclusions
			1.找到引入projectB的<dependency>。
			2.在标签内部添加：
				<exclusions>
					<exclusion>
						<groupId></groupId>
						<artifactId><artifactId>
						//不需要指定版本号
					</exclusion>
					......
				</exclusions>

	3.依赖范围: 引入的依赖可以生效的范围:main文件夹内、test文件夹内、是否参与打包

			-在引入配置时添加<scope>compile(默认值)/test/provided/runtime</scope>标签设置该依赖的作用范围。

	4.生命周期: maven有3套不同的生命周期，每个生命周期都有自己的阶段。

		-clean:清理工作。
		 default: 核心工作,包括编译、测试、打包、安装(将当前Maven.jar安装到本地仓库)等。
		 site: 生成报告、发布站点等。
		
		※1.在同一套生命周期中执行后面的阶段时，前面的阶段会自动执行，而且是先执行。
		 2.在IDEA中使用Maven执行相应的生命周期指令(在控制台执行Maven指令同理)时，实际上调用的是相应绑定的插件。
	
11.SpringBoot	
	
	-controller:请求处理类: @RestController标识
	
	-绑定请求路径与请求方法: @RequestMapping(path); 绑定路径与方法
	
HTTP数据格式:

	-请求数据格式：
		-请求行: 请求方式、请求路径、协议。
		-请求头: 资源信息，以键值对key: value 形式传递。
		-请求体: POST发起请求时，存放请求参数。
		
	-响应数据格式:
		-响应行: 协议版本、状态码(200\404\500最为常见)、描述
		-响应头: 资源信息，以键值对key：value 形式传递。
		-响应体: 存放响应的数据。
		
Web服务器(一个软件程序)：对HTTP协议的封装，可以处理和响应客户端发来的请求，使得后端不需要在重复定义服务器类。	

著名的Web服务器:Tomcat：轻量级Web服务器，支持Servlet/JSP等少量的JavaEE规范

SpringBoot的起步依赖内嵌了Tomcat服务器

12.使用sprintboot接收请求参数
		
	1.简单参数:
		-在对应的方法中添加与参数同名的变量即可接收，并且进行自动的类型转换。
			GET方法:{
			http://localhost:8080/simplePara?name=Tom&age=23
			
			@RequestMapping("/simplePara")
			public String getPare(String name, int age)
			}
			
			POST方法{
			在请求体中使用键值对传递参数
			
			@RequestMapping("/simplePara")
			public String getPare(String name, int age)
			}
		当传递参数与形参名不一致，可以使用@RequestParam映射
		public String getPare(@RequestParam("name", required = false) String username, Integer age)
			-将"name"映射到username上，同时修改required的值为false: 该"user"参数可以不传递。
	
	
	2.实体参数:使用对象接收参数(以User user为例)
		1.无嵌套关系接收:对象的成员变量与请求参数名一一对应即可。
		2.嵌套参数接收:如address.province\address.city
			-在User类中添加Address类变量address。
			-创建Address类并添加province和city两个参数
			
	3.数组参数:使用数组/集合接收请求参数
		当传递的请求参数中包含一个key对应多个value时，可以使用同名数组/集合接收
		{
		public String getArray(String[] hobby)
		或者
		public String getArray(@RequestParam List<String> hobby):使用集合接收时@RequestParam(绑定参数关系)是必须的！
		}
	
	4.时间参数:请求参数为某个格式的时间
		public String getTime(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime newTime)
			@DateTimeFormat(pattern = "指定时间格式，只能接收这个格式的时间参数")。
			newTime：与请求参数同名。
	
	5.JSON参数:请求体为JSON数据，使用POJO实体参数接收
		public String getJSON(@RequestBody User user)
			@RequestBody:将JSON的数据封装到User中
			User中的成员变量要与JSON中Key同名，具体要求与实体参数相同。

	6.路径参数:参数是路径的一部分。
		@RequestMapping("/path/{id}/{name}")
		public String getPath(@PathVariable Integer id, @PathVariable String name)
			1.输入的参数必须满足....../path/id/name才会被映射到getPath方法。
			2.{id}/{name}都是可变参数，可以随着请求路径的改变而改变。
			3.@PathVariable:将路径参数与方法形参绑定，必须同名。

响应注解:ResponseBody: 作用在Controller类/方法上，将返回值作为响应数据返回给请求端。
		
	@RestController = @Controller + @ResponseBody
	返回结果：String -> String
			  对象/数组/集合 -> JSON格式

统一响应结果:将要返回的信息封装到同一个类中，统一返回该类对象。

	public class Result {
		private int code;
		private String msg;
		private Object data;
		......
		
		public static Result success/error(){
		return new Result(code,msg,data);
		}
	}
	
	
员工数据案例

	前端:定义整个HTML界面，使用Vue组件定义mounted方法，在页面挂件加载完成后触发axios，传递listEmp访问路径
		mounted(){
            axios.get('/listEmp').then(res=>{
                if(res.data.code){
                    this.tableData = res.data.data;
                }
            });
        },
	
	后端: 在请求处理类中定义方法接收前端的请求
		@RequestMapping("/listEmp")
		public Result getEmp(){
		 ......
		 return Result.success(list)
		}
	
13.SpringBoot的项目的单一职责原则

    三层架构: 将后端接收-响应分为三层处理
		
		1.Controller: 控制层。负责接收数据、响应数据。
		2.Service: 业务逻辑层。负责处理具体的业务逻辑。
		3.Dao: 数据访问层。负责对数据进行访问操作(包括curd)。
	
	分层解耦：高内聚低耦合
		IOC：控制反转，对象的创建权由程序自身 -> 外部容器(IOC容器)
		DI: 依赖注入，IOC容器根据自己管理的类自动为程序创建合适的类对象，
		Bean对象: 交给IOC容器管理的类。
		
		实现:@Component和@Autowired
	
			-@Component：标记类，表示将这个类交给IOC容器管理。
				衍生: 以下三个注解都可以声明一个Bean
				1.@Controller 声明控制器对象。在spring boot集成Web开发中，只能用@Controller声明控制器。
				2.@Service 声明Service对象
				3.@Repository 声明Dao对象
			细节:	
				1.@Component("xxx")可以指定Bean对象名，默认为: 类名首字母小写: ServiceB -> serviceB
				2.需要扫描才能生效: @ComponentScan：对范围内的@Component进行扫描，并将其加入IOC容器中。默认范围：当前类包及其子包。
				3.启动类的@SpringBootApplication已经包含@ComponentScan，可以扫描启动类所在包以及子包。
				4.手动添加(破环默认范围)@ComponentScan({"path1", "path2, ......})
					
			-Autowired: 标记对象，当程序运行时自动在容器中选择合适的类创建对象，并赋值。
				@Autowired
				Service service //= new ServiceImplB;
				自动创建的类对象甚至会覆盖原程序中定义的类对象(ServiceImplB)
			细节：
				1.当IOC容器中存在多个符合条件的Bean对象会报错。
				2.使用如下三种注解来解决：
					-@Primary: 注解冲突类的某一个，表示使用该类。
					-@Qualifier("Bean对象名"): 与@Autowired一起使用，表示使用该类Bean对象。
					-@Resource(name="Bean对象名"): 单独使用，不需要@Autowired，表示使用该类Bean对象。
				经过测试:优先级 @Resource>@Qualifier>@Primary			
					
				@Qualifier与@Resource区别:
					1.前者spring框架提供的注解，后者是JDK提供的注解。
					2.前者默认是按照类型注入，后者默认是按照名称注入。
					

		
		
	
	
	
	
	
	
	
	
	