import './App.css';
// router를 사용하기 위해 설치하기
// Terminal에 'npm install react-router-dom' 입력
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom'

// 처음 프로젝트를 Clone해왔을 때 ! (node_modules가 없음.)
// Terminal에 'cd 프로젝트 명' > 'npm install' > 'npm start' 입력해서 실행되는지 확인.

function App(){
  let [list, setList] = useState([{
    // 초기 샘플 데이터
    title : "공지사항 2",
    writer : "admin",
    content: "공지사항 2 입니다."
  },{
    title : "공지사항 1",
    writer : "admin",
    content: "공지사항 1 입니다."
  }])

  function deletePost(idx){
    let tmpList = [...list]
    tmpList.splice(idx, 1)
    setList(tmpList)
  }

  function addPost(post){
    setList([post, ...list])
  }

  return (
    <BrowserRouter>
      <ul>
        <li><Link to="/">메인</Link></li>
        <li><Link to="/post/list">게시글 리스트</Link></li>
        <li><Link to="/post/insert">게시글 작성</Link></li>
      </ul>
      <Routes>
        <Route path="/" exact element={<Home/>} /> 
        // 차이점 확인하기
        <Route path="/post/list" element={
          <List 
            list={list} 
            remove={deletePost} 
            add={addPost}
            />
        } />
        <Route path="/post/insert" element={<Insert/>} /> 
      </Routes>
    </BrowserRouter>
  )
          
};

function Home(){
  return (<h1>HOME</h1>)
}

function List({list, add, remove}){
  // 다른 페이지에서 전송한 정보를 받기 위해 Location을 이용함.
  const location = useLocation();

  // 누군가가 전송을 하면, location.state에 전송한 정보들이 담겨있다. 
  // 다른 페이지에서 보낸 정보가 있는지 확인함
  let post = location.state; 
  if(post != null){
    add(post)
    location.state = null // 추가 후 받아온 정보를 null로 비워줌
  }

  return (
    <table>
      <thead>
        <tr>
          <th>제목</th>
          <th>내용</th>
          <th>작성자</th>	
        </tr>
      </thead>
      <tbody>
        {
          list.map((item, idx)=>{
            return(
              <tr>
                <td>{item.title}</td>
                <td>{item.content}</td>
                <td>
                  {item.writer}
                  <button onClick={()=>remove(idx)}>x</button>
                  </td>	
              </tr>
            )
          })
        }
        
      </tbody>	
    </table>
  )
}

function Insert(){
  const navigate = useNavigate(); // 다른 페이지로 정보를 전송하기 위해 사용
  
  let [title, setTitle] = useState("")
  let [writer, setWriter] = useState("")
  let [content, setContent] = useState("")
    
  function insertPost(){
    // 첫 번째 매개변수: 보낼 url
    // 두 번째 매개변수 state: 상태 정보0

    navigate("/post/list", {
      state : {
        title,
        writer,
        content
      }
    })
  }

  return (
    <div>
      <input type="text" placeholder="제목" onChange={(e)=>setTitle(e.target.value)}/>
      <br/>
      <input type="text" placeholder="작성자" onChange={(e)=>setWriter(e.target.value)}/>
      <br/>
      <textarea placeholder="내용" onChange={(e)=>setContent(e.target.value)}></textarea>
      <br/>
      <button onClick={insertPost}>게시글 등록</button>
    </div>
  )
}


export default App;
