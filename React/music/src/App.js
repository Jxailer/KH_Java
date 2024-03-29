import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom'

function App() {

  // 음악을 조회하고 등록하는 사이트를 구현하세요. 
  /* 
    음악 조회는 / 에서
    = 음악 조회에서 삭제 버튼을 클릭하면 삭제되도록 구현(음악 번호 이용)
  */
  /*
    음악 등록은 /insert에서
    = 음악 등록시 음악번호(숫자), 제목, 가수, 장르를 입력하여 등록함 
    = 음악 번호는 중복되지 않게 입력해서 추가
  */

  let [list, setList] = useState([{
    num : 1,
    title : "ex1 title",
    singer : "ex1 singer",
    genre : "ex1 genre"
  },{
      num : 2,
      title : "ex2 title",
      singer : "ex2 singer",
      genre : "ex2 genre"
    }
  ])

  function add(music){
    setList([music, ...list])
  }

  // 기존 삭제 구현 방법과 비교하기
  function remove(num){
    let tmpList = list.filter(item=>item.num != num)  // 삭제하려는 음악 번호와 같지 않은 요소들만 가져와서 추가함
    setList(tmpList)
  }

  return (
    <BrowserRouter>
      <Nav />
      <Routes>
        <Route path="/" exact element={<Home list={list} remove={remove} add={add}/>} /> 
        <Route path="/insert" element={
          <Insert list={list}/>
        } />
      </Routes>
    </BrowserRouter>
  )
}

function Nav(){
  return(
    <ul className="menu-list">
      <li><Link to="/">음악 조회</Link></li>
      <li><Link to="/insert">음악 추가</Link></li>
    </ul>
  )
}

function Home({list, remove, add}){
  const location = useLocation()
  
  let music = location.state

  if(music != null){
    add(music)
    location.state = null
  }

  return (
    <table>
      <thead>
        <tr>
          <th>제목</th>
          <th>가수</th>
          <th>장르</th>
          <th>비고</th>
        </tr>
      </thead>
      <tbody>
        {
          list.map((item)=>{
            return(
            <tr key={item.num}>
              <td>{item.title}</td>
              <td>{item.singer}</td>
              <td>{item.genre}</td>
              <td>
                <button onClick={()=>remove(item.num)}>X</button>
              </td>
            </tr>)
            
          })
        }
      </tbody>
    </table>
  )
  
}

function Insert({list, add}){
  const navigate = useNavigate(); // 다른 페이지로 정보를 전송하기 위해 사용
  
  let [num, setNum] = useState("")
  let [title, setTitle] = useState("")
  let [singer, setSinger] = useState("")
  let [genre, setGenre] = useState("")

  const numChange = (e) => setNum(e.target.value)

  function add(){
    navigate("/",{
      state: {
        num, title, singer, genre
      }
    })
  }

  return(
    <div>
      <input placeholder='음악 번호' onChange={numChange}/>
      <input placeholder='제목' onChange={(e)=>{setTitle(e.target.value)}}/>
      <input placeholder='가수' onChange={(e)=>{setSinger(e.target.value)}}/>
      <input placeholder='장르' onChange={(e)=>{setGenre(e.target.value)}}/>
      <button onClick={()=>add()}>추가</button>
    </div>
  )
}

export default App;
