import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';

/*
  컴포넌트를 넣을 때는 <컴포넌트명 />을 통해 넣어줌.
  = 이 때, 컴포넌트 명이 소문자로 시작하면 동작이 안됨!!
*/

// id가 root인 요소를 통해 root 요소를 만들고
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // App을 렌더링함
    <App />
);

