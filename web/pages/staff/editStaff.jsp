<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<%--"crmDepartments",crmDepartments);--%>
<%--session.setAttribute("crmPosts"--%>
<s:form action="editReal" method="POST">
	<s:hidden name="staffId" value="%{staffId}"/>
	<s:textfield name="loginName" label="登录名"/>
	<s:textfield name="staffName" label="姓名"/>
	<s:password name="loginPwd" label="密码"  showPassword="true"/>
	<s:radio name="gender" list="%{#{'man':'男','woman':'女'}}" />
	<s:select list="#session.crmDepartments"  onchange="showPost(this)" name="crmPost.crmDepartment.depId" listKey="depId" listValue="depName" label="所属部门"/>
<%--回显问题 职务下拉列表--%>
	<%--不用 #session.crmPosts--%>
	<s:select list="crmPost.crmDepartment.posts" id="post" name="crmPost.postId" listKey="%{postId}" listValue="%{postName}" label="职务"/>
     <s:textfield label="入职时间" name="onDutyDate" readonly="true" onfocus="c.showMoreDay=true; c.show(this);"/>
</s:form>

<%--<form action="/crm2/staff/staffAction_edit.action" method="post">--%>
	<%----%>
	<%--<input type="hidden" name="staffId" value="2c9091c14c78e58b014c78e7ecd90007"/>--%>
	<%----%>
	<%--<table width="88%" border="0" class="emp_table" style="width:80%;">--%>
	 <%--<tr>--%>
	    <%--<td>登录名：</td>--%>
	    <%--<td><input type="text" name="loginName" value="赵六" /> </td>--%>
	    <%--<td>密码：</td>--%>
	    <%--<td><input type="password" name="loginPwd" value="54dfc11c8e9c49bab6068f473f913be9" /> </td>--%>
	  <%--</tr>--%>
	 <%--<tr>--%>
	    <%--<td>姓名：</td>--%>
	    <%--<td><input type="text" name="staffName" value="赵六" /> </td>--%>
	    <%--<td>性别：</td>--%>
	    <%--<td>--%>
	    	<%--<input type="radio" name="gender" checked="checked" value="男"/>男--%>
	    	<%--<input type="radio" name="gender" value="女"/>女--%>
	    <%--</td>--%>
	  <%--</tr>--%>
	 <%--<tr>--%>
	    <%--<td width="10%">所属部门：</td>--%>
	    <%--<td width="20%">--%>
	    	<%--<select name="crmPost.crmDepartment.depId"  onchange="changePost(this)">--%>
			    <%--<option value="">----请--选--择----</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000001" selected="selected">教学部</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
			<%--</select>--%>

	    <%--</td>--%>
	    <%--<td width="8%">职务：</td>--%>
	    <%--<td width="62%">--%>
	    	<%--<select name="crmPost.postId" id="postSelectId">--%>
			    <%--<option value="">----请--选--择----</option>--%>
			    <%--<option value="2c9091c14c78e58b014c78e6b34a0003">总监</option>--%>
			    <%--<option value="2c9091c14c78e58b014c78e6d4510004" selected="selected">讲师</option>--%>
			<%--</select>--%>
	    <%--</td>--%>
	  <%--</tr>--%>
	  <%--<tr>--%>
	    <%--<td width="10%">入职时间：</td>--%>
	    <%--<td width="20%">--%>
	    	<%--<input type="text" name="onDutyDate" value="2012-02-12" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>--%>
	    <%--</td>--%>
	    <%--<td width="8%"></td>--%>
	    <%--<td width="62%"></td>--%>
	  <%--</tr>--%>
	<%--</table>--%>
<%--</form>--%>

</body>
<script type="text/javascript">
    function createXMLHttpRequest() {
        try {
            return new XMLHttpRequest();
        } catch (e) {
            try {
                return new ActiveXObject("Msxml2.HTTP");
            } catch (e) {
                try {
                    return new ActiveXObject("Microsoft.HTTP");
                } catch (e) {
                    throw e;
                }
            }
        }
    }
    //根据部门选中状态发起职务查询的请求
    function showPost(obj) {
        //获得部门选中id
        var departId = obj.value;
        //1.创建ajax请求对象
        var httpRequest = createXMLHttpRequest();

        var url = "${pageContext.request.contextPath}/findPost.action";
        //2.打开一个url连接对象
        httpRequest.open("POST",url,true)
        //3.POST请求设置请求头
        httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        //4.发起请求 设置请求参数 部门id
        httpRequest.send("departId="+departId);
        //5.设置请求响应的监听器
        httpRequest.onreadystatechange = function () {
            if (httpRequest.readyState == 4 &&httpRequest.status==200){
                //6,成功响应 处理响应结果
                //6.1将响应数据转换为json格式解析
                var jsonData = eval("("+httpRequest.responseText+")");
                //6.2 根据组件id获得职务下拉列表对象
                var postSelect = document.getElementById("post");
                //6.3 添加请选择
                postSelect.innerHTML="<option value='-1'>---请选择---</option>";
                //6.4 遍历json数据集合,添加下拉选项
                for (var i=0; i<jsonData.length;i++){
                    var id = jsonData[i].postId;//职务id
                    var pname = jsonData[i].postName;
//                    alert(id + pname)
                    postSelect.innerHTML +="<option value='"+id+"'>"+pname+"</option>";

                }


            }

        }




    }
</script>
</html>
