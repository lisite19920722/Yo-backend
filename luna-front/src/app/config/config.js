/**
 *  @author yiliang.guo
 */

let config = {
  // http 请求超时时间
  httpTimeout: 20000,

  // Api 的请求地址
  apiHost: 'http://localhost:8080',

  // 运行环境的 host
  host: 'http://localhost:9000'
};

// 判断是否为开发环境
const host = window.location.host;
if (('http://' + host) !== config.host) {
  config.apiHost = 'http://' + host;
}

export default config;
