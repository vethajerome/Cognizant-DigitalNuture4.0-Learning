import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore
      School={"Dnv public school"}
      total={284}
      goal={3}
      />
    </div>
  );
}

export default App;
