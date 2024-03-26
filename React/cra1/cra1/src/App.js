/*
  컴포넌트는 함수로 만듦
  컴포넌트 함수는 대문자로 시작함(반드시!)
  
  컴포넌트는 return을 통해 작성해야함.
  () 안은 하나의 최상위 태그로 이루어져야 함.

  컴포넌트에서 선언한 변수는 재랜더링이 되기 전 까지는 값이 변경되지 않음
  (span 태그 내부에 있는 {count})
*/

let count = 0;
function App() {
  return (

    // 클래스 이름은 className을 통해 변경함
    <div className="App">
      <button onClick={()=>{
       alert(--count)
      }}>-</button>
      <span style={{"padding":"0 10px"}}>{count}</span>
      <button onClick={()=>{
        alert(++count)
      }}>+</button>
    </div>
  );
}

// 만들어진 컴포넌트를 export로 내보내야 다른데에서 import해올 수 있음!
export default App;
