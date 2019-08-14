<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>微信公众号管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/wx/wxMp/">微信公众号列表</a></li>
		<shiro:hasPermission name="wx:wxMp:edit"><li><a href="${ctx}/wx/wxMp/form">微信公众号添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="wxMp" action="${ctx}/wx/wxMp/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>微信公众号：</label>
				<form:input path="mpname" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('wx_mp_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>开发者ID：</label>
				<form:input path="appid" htmlEscape="false" maxlength="18" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>微信公众号</th>
				<th>登陆账户</th>
				<th>状态</th>
				<th>开发者ID</th>
				<th>开发者密码</th>
				<th>code地址</th>
				<th>订阅提示信息</th>
				<th>已订阅提示信息</th>
				<th>公众号联系人</th>
				<th>联系号码</th>
				<shiro:hasPermission name="wx:wxMp:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="wxMp">
			<tr>
				<td><a href="${ctx}/wx/wxMp/form?id=${wxMp.id}">
					${wxMp.mpname}
				</a></td>
				<td>
					${wxMp.appname}
				</td>
				<td>
					${fns:getDictLabel(wxMp.status, 'wx_mp_status', '')}
				</td>
				<td>
					${wxMp.appid}
				</td>
				<td>
					${wxMp.appsecret}
				</td>
				<td>
					${wxMp.codeurl}
				</td>
				<td>
					${wxMp.subrespmsg}
				</td>
				<td>
					${wxMp.inmpmsg}
				</td>
				<td>
					${wxMp.username}
				</td>
				<td>
					${wxMp.mobile}
				</td>
				<shiro:hasPermission name="wx:wxMp:edit"><td>
    				<a href="${ctx}/wx/wxMp/form?id=${wxMp.id}">修改</a>
					<a href="${ctx}/wx/wxMp/delete?id=${wxMp.id}" onclick="return confirmx('确认要删除该微信公众号吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>