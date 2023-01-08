import Mock from 'mockjs'

// 生成数据列表
var dataList = []
for (let i = 0; i < Math.floor(Math.random() * 10 + 1); i++) {
  dataList.push(Mock.mock({
    'id': '@increment',
    'username': '@name',
    'operation': '保存角色',
    'method': 'io.renren.modules.sys.controller.SysRoleController.save()',
    'params': '{\'roleId\':1,\'roleName\':\'aaa\',\'remark\':\'111\',\'createUserId\':1,\'menuIdList\':[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30],\'createTime\':\'Mar 8,2018 2:29:31 PM\'}',
    'time|1-100': 100,
    'ip': '@ip',
    'createDate': '@datetime'
  }))
}

// 获取日志列表
export function list () {
  return {
    // isOpen: false,
    url: '/sys/log/list',
    type: 'get',
    data: {
      'msg': 'success',
      'code': 0,
      'page': {
        'totalCount': dataList.length,
        'pageSize': 10,
        'totalPage': 1,
        'currPage': 1,
        'list': dataList
      }
    }
  }
}
