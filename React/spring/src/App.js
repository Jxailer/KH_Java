import { useState, useEffect } from 'react';

// 비동기 통신으로 서버에 데이터를 요청
function App() {
  let [list, setList] = useState([])
  
    useEffect(() => {
        fetch('/api/board/list')
            .then((res) => res.json())
            .then(res=>res.list)
            .then(res=>res.forEach(item=>{
              setList(list=>[...list, item])
            }))
    }, []);

    return (
        <div className="App">
          <table>
            <thead>
              <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>게시판</th>
              </tr>
            </thead>
            <tbody>
              {
                list.map(item=>{
                  return(
                  <tr>
                    <td>{item.bo_num}</td>
                    <td>{item.bo_title}</td>
                    <td>{item.me_id}</td>
                    <td>{item.bo_co_name}</td>
                  </tr>)
                })
              }
              
            </tbody>
          </table>
        </div>
    );
}

export default App;
