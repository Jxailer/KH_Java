// 프록시 설정을 위한 파일
// CRA 프로젝트는 기본 포트가 3000, 
// 스프링 프로젝트는 기본 포트가 8080이어서 CORS 관련 오류가 발생할 수 있음

const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/api/board/list', // /api/* 경로로 데이터를 주고 받음
    createProxyMiddleware({
      target: 'http://localhost:8080/spring',	//스프링 포트
      changeOrigin: true,
    })
  );
};