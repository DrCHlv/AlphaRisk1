<div class="layui-fluid">
  <div class="layui-row">
    <div class="layui-col-xs12">
      <div class="layui-card">
        <div class="layui-card-body">
          <div class="layui-card-header">
            <a href="#/member/all/edit" class="layui-btn layui-btn-xs">
              <i class="layui-icon">&#xe654;</i>
              <span>新增</span>
            </a>
            <a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="search_hash">
              <i class="layui-icon">&#xe615;</i>
            </a>
          </div>
          <div class="layui-card-body">
          	<input type="txt" value=0 id="totalRows"/>
            <table id="demo_hash" lay-filter="test"></table>
            <script type="text/html" id="barDemo_hash">
              <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
              <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
              <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/html" id="search_tpl_hash">
  <form class="layui-form" action="">
    <div class="layui-form-item">
      <label class="layui-form-label">用户名</label>
      <div class="layui-input-block">
        <input type="text" name="title" placeholder="请输入用户名.." autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">城市</label>
      <div class="layui-input-block">
        <select name="city">
          <option value=""></option>
          <option value="0">北京</option>
          <option value="1">上海</option>
          <option value="2">广州</option>
          <option value="3">深圳</option>
          <option value="4">杭州</option>
        </select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">是否禁用</label>
      <div class="layui-input-block">
        <input type="checkbox" name="switch" lay-skin="switch">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">性别</label>
      <div class="layui-input-block">
        <input type="radio" name="sex" value="男" title="男">
        <input type="radio" name="sex" value="女" title="女" checked>
      </div>
    </div>
    <div class="layui-form-item">
      <div class="layui-input-block">
        <button class="layui-btn" lay-submit lay-filter="formDemo_hash"><i class="layui-icon">&#xe615;</i> 搜索</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
      </div>
    </div>
  </form>
</script>

<script>
  layui.config({
    base: '/src/js/'
  }).use(['jquery', 'mockjs', 'table', 'sidebar', 'form'], function () {
    var $ = layui.jquery,
      layer = layui.layer,
      table = layui.table,
      sidebar = layui.sidebar,
      form = layui.form;

    //第一个实例
    table.render({
      //method: 'post',
      size: 'sm',
      limit: 10,
      elem: '#demo_hash',
      height: 'full-235',
      url: 'userManager/queryUser.do?totalRows='+$("#totalRows").val(), //数据接口
      page: true, //开启分页
      cols: [[ //表头
          {field: 'id',      title:'ID',  width: '10%',sort: true,fixed: 'left'}, 
          {field: 'userName',title: '用户名',width: '20%'}, 
          {field: 'passWord',title: '密码',width: '20%',sort: true}, 
          {field: 'idcard',title: '身份证',width: '40%'}, 
          {field: 'isEffective',title: '是否有效',width: '10%'}
        ]],
        done:function (res) {
        	$("#totalRows").val(res.count)
        }
    });

    $('#search_hash').on('click', function () {
      var that = this;
      sidebar.render({
        elem: that,
        content: $('#search_tpl_hash').html(),
        title: '搜索',
        shade: true,
        width: '50%', //可以设置百分比和px
        done: function () {
          console.log('ccc');
          form.render();

          //监听提交
          form.on('submit(formDemo_hash)', function (data) {
            // layer.msg(JSON.stringify(data.field));
            table.reload('demo_hash', {
              where: data.field
            });
            return false;
          });
        }
      });
    });
  });
</script>

<style scoped>

</style>