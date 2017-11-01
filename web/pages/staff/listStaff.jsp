<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="condition()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="${pageContext.request.contextPath}/addStaff.action">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
 <%--session.setAttribute("crmStaffs",crmStaffs);--%>
 <%--session.setAttribute("crmDepartments",crmDepartments);--%>
 <%--session.setAttribute("crmPosts",crmPosts);--%>
<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/findStaff.action" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">

			<%--我把this去拉 要不然点击高级查询第一次查询不出来 --%>
			<s:select list="#session.crmDepartments"
					  name="crmPost.crmDepartment.depId"
					  listKey="depId" listValue="depName"
					  headerKey="" headerValue="--请选择部门--"
					  onchange="showPost()"
			>
			</s:select>
	    	<%--<select id="depart" name="crmPost.crmDepartment.depId" onchange="showPost(this)">--%>
			    <%--<option value="-1">--请选择部门--</option>--%>
				<%--<s:iterator value="#session.crmDepartments" var="depart">--%>
					<%--<option value="${depart.depId}">${depart.depName}</option>--%>
				<%--</s:iterator>--%>
			    <%--&lt;%&ndash;<option value="ee050687bd1a4455a153d7bbb7000001">教学部</option>&ndash;%&gt;--%>
			    <%--&lt;%&ndash;<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>&ndash;%&gt;--%>
			<%--</select>--%>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
			<s:select id="post" list="#session.crmPosts"
					  name="crmPost.postId"
					  listKey="postId" listValue="postName"
					  headerKey="" headerValue="--请选择职务--"
			>
			</s:select>

	    	<%--<select id="post" name="crmPost.postId" >--%>
			    <%--<option value="-1">--请选择职务--</option>--%>
			    <%--&lt;%&ndash;<option value="ee050687bd1a4455a153d7bbb7000003">总监</option>&ndash;%&gt;--%>
			    <%--&lt;%&ndash;<option value="ee050687bd1a4455a153d7bbb7000004">讲师</option>&ndash;%&gt;--%>
			    <%--&lt;%&ndash;<option value="ee050687bd1a4455a153d7bbb7000005">主管</option>&ndash;%&gt;--%>
			<%--</select>--%>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>

	<s:iterator value="#session.crmStaffs1">
		<tr class="tabtd1">
			<td align="center"><s:property value="staffName"/> </td>
			<td align="center"><s:property value="gender"/> </td>
			<td align="center"><s:property value="onDutyDate" /> </td>
			<td align="center"><s:property value="crmPost.crmDepartment.depName"/> </td>
			<td align="center"><s:property value="crmPost.postName"/> </td>
			<td width="7%" align="center">
             <%--staffId 就是当前点击编辑的员工id--%>
				<s:a href="editStaff.action?staffId=%{staffId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></s:a>
			</td>
		</tr>
	</s:iterator>

    <%----%>
	  <%--<tr class="tabtd1"> --%>
	    <%--<td align="center">管理员</td>--%>
	    <%--<td align="center"></td>--%>
	    <%--<td align="center"></td>--%>
	    <%--<td align="center"></td>--%>
	    <%--<td align="center"></td>--%>
	  	<%--<td width="7%" align="center">--%>
	  		<%----%>
	  		<%--<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	--%>
	  	<%--</td>--%>
	  	<%----%>
	  <%--</tr>--%>
    <%----%>
	  <%--<tr class="tabtd2"> --%>
	    <%--<td align="center">赵六</td>--%>
	    <%--<td align="center">男</td>--%>
	    <%--<td align="center">2012-02-12</td>--%>
	    <%--<td align="center">咨询部</td>--%>
	    <%--<td align="center">主管</td>--%>
	  	<%--<td width="7%" align="center">--%>
	  		<%----%>
	  		<%--<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	--%>
	  	<%--</td>--%>
	  <%--</tr>--%>
</table>




<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>


<script type="text/javascript">
    function condition() {

        document.getElementById("conditionFormId").submit();

    }
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
                postSelect.innerHTML="<option >---请选择---</option>";
                //6.4 遍历json数据集合,添加下拉选项
                for (var i=0; i<jsonData.length;i++){
                    var id = jsonData[i].postId;//职务id
                    var pname = jsonData[i].postName;
//                    alert(id + pname)
                    postSelect.innerHTML +="<option value='"+id+"'>"+pname+"</option>";


                }



            }

        }


    function refresh() {
            window.location.reload();

    }

    }
</script>
</html>
