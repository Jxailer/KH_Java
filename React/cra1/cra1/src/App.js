/*
  컴포넌트는 함수로 만듦
  컴포넌트 함수는 대문자로 시작함(반드시!)
  
  컴포넌트는 return을 통해 작성해야함.
  () 안은 하나의 최상위 태그로 이루어져야 함.
*/
function App() {
  return (
    // 클래스 이름은 className을 통해 변경함
    <div className="App">
      <h1 >안녕하세요.</h1>
      <h2>안녕</h2>
    </div>
  );
}

// 만들어진 컴포넌트를 export로 내보내야 다른데에서 import해올 수 있음!
export default App;
