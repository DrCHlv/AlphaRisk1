if (layui === undefined) {
  console.error('请先引用layui.js文件.');
} else {

  var modules = {
    admin: '../../../Resources/JS/lay/kit_modules/admin',
    axios: '../../../Resources/JS/lay/kit_modules/axios',
    lodash: '../../../Resources/JS/lay/kit_modules/lodash',
    menu: '../../../Resources/JS/lay/kit_modules/menu',
    mockjs: '../../../Resources/JS/lay/kit_modules/mockjs',
    mockjsbase: '../../../Resources/JS/lay/kit_modules/mockjsbase',
    route: '../../../Resources/JS/lay/kit_modules/route',
    tabs: '../../../Resources/JS/lay/kit_modules/tabs',
    utils: '../../../Resources/JS/lay/kit_modules/utils',
    component:'../../../Resources/JS/lay/kit_modules/component',
    nprogress:'../../../Resources/JS/lay/kit_modules/nprogress',
    kit:'../../../Resources/JS/lay/kit_modules/kit',
    sidebar:'../../../Resources/JS/lay/kit_modules/sidebar',
    select:'../../../Resources/JS/lay/kit_modules/select',
    echarts:'../../../Resources/JS/lay/kit_modules/echarts'
  };

  layui.injectModules(modules);
}