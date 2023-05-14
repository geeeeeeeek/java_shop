// import { resolve } from 'path';
// const fs = require('fs');
//
// function pathResolve(dir: string) {
//   return resolve(process.cwd(), '.', dir);
// }
//
// export const getFolder = (path: any) => {
//   const components: Array<string> = [];
//   const files = fs.readdirSync(path);
//   files.forEach(function (item: string) {
//     const stat = fs.lstatSync(path + '/' + item);
//     if (stat.isDirectory() === true && item != 'components') {
//       components.push(path + '/' + item);
//       components.push(pathResolve(path + '/' + item));
//     }
//   });
//   return components;
// };

export function getFormatTime(dateTime,flag) {
  if(dateTime != null ) {
    //若传入的dateTime为字符串类型，需要进行转换成数值，若不是无需下面注释代码
    var time = parseInt(dateTime)
    var date = new Date(time);
    //获取年份
    var YY = date.getFullYear();
    //获取月份
    var MM = (date.getMonth() + 1 < 10 ? '0'+(date.getMonth() + 1) : date.getMonth() + 1);
    //获取日期
    var DD = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate());
    if(flag) { //flag为true，显示时分秒格式
      //获取小时
      var hh = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours());
      //获取分
      var mm = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes());
      ///获取秒
      var ss = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());
      //返回时间格式： 2020-11-09 13:14:52
      return YY + '-' + MM + '-' + DD + ' ' + hh + ':' + mm + ':' + ss;
    } else {
      //返回时间格式： 2020-11-09
      return YY + '-' + MM + '-' + DD;
    }
  } else {
    return "";
  }
}
