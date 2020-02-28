<#assign basePath=request.contextPath>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base id="base" href="${basePath}">
    <meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>AlphaRisk</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/Resources/CSS/login/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/Resources/CSS/login/demo.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/Resources/CSS/login/component.css" />
    <link rel="stylesheet" type="text/css" href="${basePath}/Resources/CSS/layui.css" />
    <script type="text/javascript" src="${basePath}/Resources/JS/lay/modules/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}/Resources/JS/layui.js"></script>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎你</h3>
                <form action="${basePath}/login.do" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="userName" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                        
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="passWord" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                    </div>
					<div class="mb2">
					<button class="layui-btn layui-btn-fluid layui-btn-radius layui-btn-normal">登录</button>
					<#if loginMsg??><i class="layui-icon layui-icon-tips" style="font-size: 15px; color: #FF5722;">${loginMsg}</i></#if>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="${basePath}/Resources/JS/login/TweenLite.min.js"></script>
<script src="${basePath}/Resources/JS/login/EasePack.min.js"></script>
<script src="${basePath}/Resources/JS/login/rAF.js"></script>
<script src="${basePath}/Resources/JS/login/demo-1.js"></script>
</body>
</html>