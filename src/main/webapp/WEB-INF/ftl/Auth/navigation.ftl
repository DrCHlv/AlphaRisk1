<#assign basePath=request.contextPath>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>AlphaRisk</title>
  <link rel="stylesheet" href="${basePath}/Resources/CSS/layui.css" id="layui">
  <link rel="stylesheet" href="${basePath}/Resources/CSS/theme/default.css" id="theme">
  <link rel="stylesheet" href="${basePath}/Resources/CSS/kitadmin.css" id="kitadmin">
  <script src="${basePath}/Resources/JS/lay/modules/jquery.min.js"></script>
  <script src="${basePath}/Resources/JS/lay/modules/jquery.js"></script>
</head>

<body class="layui-layout-body kit-theme-default">
  <div class="layui-layout layui-layout-admin">
    <!-- header -->
    <div class="layui-header">
      <div class="layui-logo">
        <div class="layui-logo-toggle" kit-toggle="side" data-toggle="on"><i class="layui-icon">&#xe65a;</i></div>
        <div class="layui-logo-brand"><a href="#/">AlphaRisk 1.0</a></div>
      </div>
      <div class="layui-layout-left"></div>
      <div class="layui-layout-right">
        <ul class="kit-nav" lay-filter="header_right">
          <li class="kit-item" kit-target="help"><a href="javascript:;"><i class="layui-icon">&#xe607;</i><span>帮助</span></a></li>
          <li class="kit-item" id="ccleft"><a href="javascript:;"><i class="layui-icon">&#xe60e;</i></a></li>
          <li class="kit-item" id="cc"><a href="javascript:;"><i class="layui-icon">&#xe64c;</i></a></li>
          <li class="kit-item">
          	<a href="javascript:;">
          		<span>
          			<img src="${basePath}/Resources/Image/userImage/${user.id}.jpg" class="layui-nav-img">${user.userName}
          		</span>
          	</a>
            <ul class="kit-nav-child kit-nav-right">
              <li class="kit-item"><a href="#/user/my"><i class="layui-icon">&#xe612;</i><span>个人中心</span></a></li>
              <li class="kit-item" kit-target="setting"><a href="javascript:;"><i class="layui-icon">&#xe614;</i><span>设置</span></a></li>
              <li class="kit-nav-line"></li>
              <li class="kit-item">
              	<a href="javascript:;" onclick="menu2Controller('logout.do')">
              		<i class="layui-icon">&#x1006;</i>
              		<span>注销</span>
              	</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
    
    <!-- silds -->
    <div class="layui-side" kit-side="true">
      <div class="layui-side-scroll">
        <div id="menu-box">
		
		<#if resource??>
		<#list resource?sort_by("id") as resource1>
			<ul class="kit-menu">
				<li class="kit-menu-item">
					<a href="javascript:;">
						<i class="layui-icon"></i>
						<span>${resource1.resourceName}</span>
					</a>
					<#if resource1.child??>
					<#list resource1.child?sort_by("id") as resource2>
						<ul class="kit-menu-child layui-anim layui-anim-upbit">
							<li class="kit-menu-item">
								<a href="javascript:;">
									<i class="layui-icon"></i>
									<span>${resource2.resourceName}</span>
								</a>
								<#if resource2.child??>
								<#list resource2.child?sort_by("id") as resource3>
									<ul class="kit-menu-child layui-anim layui-anim-upbit">
										<li class="kit-menu-item">
											<a href="javascript:;" onclick="menu2Page('${resource3.URL!}')">
												<i class="layui-icon">&#xe62e;</i>
												<span>${resource3.resourceName}</span>
											</a>
										</li>
									</ul>
								</#list>
								</#if>
							</li>
						</ul>
					</#list>
					</#if>	
				</li>
			</ul>
		</#list>
		</#if>
      </div>
    </div>
  </div>
  
    <!-- main -->
	<div id="content" class="layui-body" kit-body="true">
		<router-view></router-view>
	</div>
    <!-- footer -->
    <div class="layui-footer" kit-footer="true">2019 © wondersgroup 内部使用
      <div style="width:400px; height:400px;" class="load-container load1">
        <div class="loader">Loading...</div>
      </div>
    </div>
  </div>
  <script src="${basePath}/Resources/JS/polyfill.min.js"></script>
  <script src="${basePath}/Resources/JS/layui.js"></script>
  <script src="${basePath}/Resources/JS/kitadmin.js"></script>
  <script src="${basePath}/Resources/JS/mockjs-config.js"></script>
  <script src="${basePath}/Resources/JS/echarts.min.js"></script>
  <script src="${basePath}/Resources/JS/AlphaRisk.js"></script>
  <script>layui.use("admin");</script>
</body>
</html>