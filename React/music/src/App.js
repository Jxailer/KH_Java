import './App.css';
import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate } from 'react-router-dom'

function App() {

  let [list, setList] = useState([{
    id : 1,
    title : "Movie 1",
    genre : "Drama",
    release_date : "2022-01-01"
  },{
      id : 2,
      title : "Movie 2",
      genre : "Action",
      release_date : "2022-02-01"
    },{
      id : 3,
      title : "Movie 3",
      genre : "Comedy",
      release_date : "2022-03-01"
    }
  ])

  function add(music){
    setList([music, ...list])
  }

  // 기존 삭제 구현 방법과 비교하기
  function remove(id){
    let tmpList = list.filter(item=>item.id != id)  // 삭제하려는 음악 번호와 같지 않은 요소들만 가져와서 추가함
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
      <li><Link to="/">List</Link></li>
      <li><Link to="/insert">Add New Movie</Link></li>
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
    <div className="container">
      <h1>Movies</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item)=>{
              return(
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.title}</td>
                <td>{item.genre}</td>
                <td>{item.release_date}</td>
                <td>
                  <button onClick={()=>remove(item.id)}>Delete</button>
                </td>
              </tr>)
              
            })
          }
        </tbody>
      </table>
    </div>
  )
  
}

function Insert({list, add}){
  const navigate = useNavigate(); // 다른 페이지로 정보를 전송하기 위해 사용
  
  let [id, setid] = useState("")
  let [title, setTitle] = useState("")
  let [genre, setgenre] = useState("")
  let [release_date, setrelease_date] = useState("")

  const idChange = (e) => setid(e.target.value)

  function add(){
    if(title == null || id == null || genre == null || release_date == null
      || title.length == 0 || id.length == 0 || genre.length == 0 || release_date.length == 0){
      alert("모든 값을 입력하세요")
      return false;
    }

    let dup = false;

    // 아이디 중복 확인
    list.map((item)=>{
      console.log("rooping")
      if(item.id == id){
        dup = true;
      }
      
    })
    
    if(dup == true){
      alert("이미 등록된 ID입니다. 다른 ID로 변경해주세요.")
      return false;
    }

    navigate("/",{
      state: {
        id, title, genre, release_date
      }
    })
  }

  return(
    <div className="container">
      <h1>Create movie</h1>
      <input placeholder='Input movie id' onChange={idChange}/><br/>
      <input placeholder='Input movie title' onChange={(e)=>{setTitle(e.target.value)}}/><br/>
      <input placeholder='Input movie release_date' onChange={(e)=>{setgenre(e.target.value)}}/><br/>
      <div>
        출시일 : <input type="date" onChange={(e)=>{setrelease_date(e.target.value)}}/>
      </div>
      <button onClick={()=>add()}>add Movie</button>
    </div>
  )
}

export default App;
